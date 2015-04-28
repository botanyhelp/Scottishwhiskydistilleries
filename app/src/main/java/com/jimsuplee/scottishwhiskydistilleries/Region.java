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

import android.app.ListActivity;
//import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
//import android.widget.ArrayAdapter;
import android.net.Uri;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.util.Log;

public class Region extends ListActivity {
    static final String TAG = "SCOT";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayListView();
    }
    private void displayListView() {
        List<String> regionList = new ArrayList<String>();
        regionList.add("Campbeltown");
        regionList.add("Highland");
        regionList.add("Highlands");
        regionList.add("Islands");
        regionList.add("Islay");
        regionList.add("Lowland");
        regionList.add("Lowlands");
        regionList.add("Northern Highlands");
        regionList.add("Scotland");
        regionList.add("Speyside");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.distillerytextview, regionList);
        setListAdapter(dataAdapter);
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent("");
                String regionChoice = ((TextView) view).getText().toString();
                i.setData(Uri.parse(regionChoice));
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}
