/**Copyright (C) 2015 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.jimsuplee.scottishwhiskydistilleries;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created on 1/26/15.
 */
public class DBAdapter {
    static final String TAG = "SCOTCH";

    static final String DATABASE_NAME = "scottishdistilleries";
    static final String DATABASE_TABLE = "scottishdistilleries";
    static final int DATABASE_VERSION = 1;

    static final String distilleryname = "distillery";
    static final String distillerydata = "distillerydata";

    static final String nameid = "nameid";
    static final String distillery = "distillery";
    static final String location = "location";
    static final String region = "region";
    static final String owner = "owner";
    static final String maltgrain = "maltgrain";
    static final String open = "open";
    static final String notes = "notes";


    //static final String DATABASE_CREATE = "CREATE TABLE distillery (distillery text default null, distillerydata text default null);";
    static final String DATABASE_CREATE = "CREATE TABLE scottishdistilleries (nameid text default null, distillery text default null, location text default null, region text default null, owner text default null, maltgrain integer default null, open integer default null, notes text default null);";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //////Log.w(TAG, "Upgrading database");
            db.execSQL("DROP TABLE IF EXISTS distillery");
            onCreate(db);
        }
    }

    // open
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    // close
    public void close() {
        DBHelper.close();
    }

    public Cursor getByDistillerydata(String distillerydataParam) throws SQLException {
        Log.w(TAG, "In DBAdapter.getByDistillerydata("+distillerydataParam+")");
        //String[] columns = new String[] {distilleryname, distillerydata};
        //We only need the distilleryname column to be returned, even though we search on carrierdata
        String[] columns = new String[] {nameid};
        String selection;
        //distillerydataParam = "%"+distillerydataParam+"%";
        //We assume that the distillerydataParam has ALREADY be pre-and-post-pended with "%" for LIKE sql:
        //WORKS-these two lines work for unsplit search term:
        //selection = "notes LIKE ?";
        //String[] selectionArgs = new String[] { distillerydataParam };

        String[] infoArray = distillerydataParam.split("\\s*,\\s*");
        String[] selectionArgs = infoArray;

        selection = "(notes LIKE ?)";
        if (infoArray.length > 0) {
            int j = 0;
            for (int i = 0; i < infoArray.length; i++) {
                if (i > 0) {
                    selection += " AND (notes LIKE ?)";
                    Log.w(TAG, "In DBAdapter.getByDistillerydata, AND notes LIKE");
                }
                //selectionArgs[i] = "%"+infoArray[i]+"%";
                selectionArgs[j++] = "%" + infoArray[i] + "%";
                //selectionArgs[j++] = "%" + infoArray[i] + "%";
                //selectionArgs[j++] = "%" + infoArray[i] + "%";
                Log.w(TAG, "In DBAdapter.getByDistillerydata, selectionArgs+="+selectionArgs[i]);
            }

        } else {
            ;
        }

        Log.w(TAG, "In DBAdapter.getByDistillerydata, about to dbquery("+selection+" "+selectionArgs[0]);
        Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        Log.w(TAG, "In DBAdapter.getByDistillerydata(StringdistillerydataParam), About to check if Cursor c is null");
        if (mCursor != null) {
            Log.w(TAG,"In DBAdapter.getByDistillerydata(String distillerydataParam), c is NOT null, about to NOT c.moveToFirst()");
            //mCursor.moveToFirst();
            if(mCursor.moveToFirst()) {
                Log.w(TAG,"In DBAdapter.getByDistillerydata(),mCursor.moveToFirst() is true");
            } else {
                Log.w(TAG,"In DBAdapter.getByDistillerydata(),mCursor.moveToFirst() is NOT true");
            }
        }
        Log.w(TAG, "In DBAdapter.getByDistillerydata(String distillerydataParam), about to return cursor, c");
        return mCursor;
    }
}
