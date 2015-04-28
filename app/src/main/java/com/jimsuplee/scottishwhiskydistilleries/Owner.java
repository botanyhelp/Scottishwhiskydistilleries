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

public class Owner extends ListActivity {
    static final String TAG = "SCOT";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayListView();
    }

    private void displayListView() {
        List<String> ownerList = new ArrayList<String>();
        ownerList.add("Adelphi Whisky");
        ownerList.add("Angus Dundee Distiller");
        ownerList.add("Annandale Distillery Company Limited");
        ownerList.add("Bacardi");
        ownerList.add("Beam Suntory");
        ownerList.add("BenRiach Distillery Company");
        ownerList.add("Berry Brothers & Rudd");
        ownerList.add("Burn Stewart Distillers");
        ownerList.add("CL Financial");
        ownerList.add("Campari");
        ownerList.add("Diageo");
        ownerList.add("Diageo/The Edrington Group");
        ownerList.add("Edrington");
        ownerList.add("Emperador Inc");
        ownerList.add("Emperador Inc.");
        ownerList.add("Gartbreck Distilling Company");
        ownerList.add("Gordon & MacPhail");
        ownerList.add("Highland Distillers");
        ownerList.add("Ian MacLeod Distillers");
        ownerList.add("Ian Macleod Distillers");
        ownerList.add("Independent");
        ownerList.add("Inver House Distillers");
        ownerList.add("Isle of Arran Distillers Ltd");
        ownerList.add("J. & G. Grant");
        ownerList.add("LVMH");
        ownerList.add("La Martiniquaise");
        ownerList.add("Loch Lomond Distillers");
        ownerList.add("Loch Lomond Distillery Company");
        ownerList.add("Loch Lomond Group");
        ownerList.add("Mitchells Glengyle Ltd");
        ownerList.add("Morrison Bowmore");
        ownerList.add("Morrison Bowmore Distillers");
        ownerList.add("Nikka Whisky Distilling");
        ownerList.add("Pernod Ricard");
        ownerList.add("Picard Vins & Spiritueux");
        ownerList.add("Raymond and Colin Armstrong");
        ownerList.add("Rémy Cointreau");
        ownerList.add("Scottish Grain Distillers");
        ownerList.add("Signatory Vintage Scotch Whisky Company");
        ownerList.add("Speyside Distillery Co. Ltd.");
        ownerList.add("Takara Shuzo Corp.");
        ownerList.add("ThaiBev");
        ownerList.add("United Breweries Group");
        ownerList.add("Whyte & Mackay");
        ownerList.add("William Grant & Sons");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.distillerytextview, ownerList);
        setListAdapter(dataAdapter);
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent("");
                String ownerChoice = ((TextView) view).getText().toString();
                i.setData(Uri.parse(ownerChoice));
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}