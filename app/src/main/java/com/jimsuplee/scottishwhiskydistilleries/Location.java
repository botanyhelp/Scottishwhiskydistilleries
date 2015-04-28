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

public class Location extends ListActivity {
    static final String TAG = "SCOT";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayListView();
    }
    private void displayListView() {
        List<String> locationList = new ArrayList<String>();
        //locationList.add("");
        locationList.add("Aberdeenshire");
        locationList.add("Aberfeldy, Perth and Kinross");
        locationList.add("Aberlour");
        locationList.add("Alexandria");
        locationList.add("Alloa");
        locationList.add("Alness");
        locationList.add("Angus");
        locationList.add("Annan");
        locationList.add("Ardnamurchan");
        locationList.add("Ballater");
        locationList.add("Ballindalloch");
        locationList.add("Ballindollach");
        locationList.add("Banff");
        locationList.add("Banffshire");
        locationList.add("Blackford");
        locationList.add("Bowmore");
        locationList.add("Brora");
        locationList.add("Buckie");
        locationList.add("Campbeltown");
        locationList.add("Carbost, Isle of Skye");
        locationList.add("Charlestown-of-Aberlour");
        locationList.add("Craigellachie");
        locationList.add("Craigellachie, Moray");
        locationList.add("Crieff");
        locationList.add("Cromdale");
        locationList.add("Dalmuir");
        locationList.add("Dalwhinnie");
        locationList.add("Doune");
        locationList.add("Drumguish");
        locationList.add("Dufftown");
        locationList.add("Dumgoyne");
        locationList.add("Easter Ross");
        locationList.add("Edderton");
        locationList.add("Edinburgh");
        locationList.add("Elgin");
        locationList.add("Elign");
        locationList.add("Fife");
        locationList.add("Forres");
        locationList.add("Fort William");
        locationList.add("Girvan, Ayrshire");
        locationList.add("Glasgow");
        locationList.add("Glenrinnes");
        locationList.add("Grantown N Spey");
        locationList.add("Haymarket, Edinburgh");
        locationList.add("Huntly");
        locationList.add("Isle of Islay");
        locationList.add("Isle of Lewis");
        locationList.add("Isle of Mull");
        locationList.add("Jura");
        locationList.add("Keith");
        locationList.add("Kennethmont");
        locationList.add("Kilchoman");
        locationList.add("Kirkwall");
        locationList.add("Knock");
        locationList.add("Knockando");
        locationList.add("Laurencekirk");
        locationList.add("Livingston");
        locationList.add("Lochranza");
        locationList.add("Methven");
        locationList.add("Morayshire");
        locationList.add("Muir of Ord");
        locationList.add("Mulben");
        locationList.add("Mull of Kintyre");
        locationList.add("Nairn");
        locationList.add("Oban");
        locationList.add("Oldmeldrum");
        locationList.add("Pencaitland");
        locationList.add("Pitlochry");
        locationList.add("Pitlochry, Perthshire");
        locationList.add("Port Askaig");
        locationList.add("Port Ellen");
        locationList.add("Portsoy");
        locationList.add("Roseisle");
        locationList.add("Rothes");
        locationList.add("Scotland");
        locationList.add("South Ayrshire");
        locationList.add("Tain");
        locationList.add("Thurso");
        locationList.add("Tomatin");
        locationList.add("Tomnavoulin");
        locationList.add("Tullibody");
        locationList.add("West Dunbartonshire");
        locationList.add("Wick");
        locationList.add("Wigtown");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.distillerytextview, locationList);
        setListAdapter(dataAdapter);
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent("");
                String locationChoice = ((TextView) view).getText().toString();
                i.setData(Uri.parse(locationChoice));
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
