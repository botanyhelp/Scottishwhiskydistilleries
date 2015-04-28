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

//import android.util.Log;

/**
 * Created on 1/26/15.
 */
public class Distillery extends ListActivity {
    static final String TAG = "SCOT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayListView();
    }

    private void displayListView() {
        ////Log.w(TAG, "In Flight.displayListView(), about to make distilleryList");
        List<String> distilleryList = new ArrayList<String>();
        if (!Scottishwhiskydistilleries.distillerySearchList.isEmpty()) {
            distilleryList = Scottishwhiskydistilleries.distillerySearchList;
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("location")) {
            String locationParam = getIntent().getStringExtra("location");
            if(locationParam.equals("Aberdeenshire")) {
                distilleryList.add("glendronach_distillery");
            } else if(locationParam.equals("Aberfeldy, Perth and Kinross")) {
                distilleryList.add("aberfeldy_whisky_distillery");
            } else if(locationParam.equals("Aberlour")) {
                distilleryList.add("dailuaine");
            } else if(locationParam.equals("Alexandria")) {
                distilleryList.add("loch_lomond_distillery");
                distilleryList.add("loch_lomond_distillery");
            } else if(locationParam.equals("Alloa")) {
                distilleryList.add("carsebridge");
            } else if(locationParam.equals("Alness")) {
                distilleryList.add("dalmore_single_malt");
                distilleryList.add("teaninich_distillery");
            } else if(locationParam.equals("Angus")) {
                distilleryList.add("glencadam_distillery");
            } else if(locationParam.equals("Annan")) {
                distilleryList.add("annandale_distillery");
            } else if(locationParam.equals("Ardnamurchan")) {
                distilleryList.add("ardnamurchan_distillery");
            } else if(locationParam.equals("Ballater")) {
                distilleryList.add("royal_lochnagar_distillery");
            } else if(locationParam.equals("Ballindalloch")) {
                distilleryList.add("braeval_distillery");
                distilleryList.add("cragganmore");
                distilleryList.add("the_glenlivet");
                distilleryList.add("tomintoul_distillery");
            } else if(locationParam.equals("Ballindollach")) {
                distilleryList.add("glenfarclas_single_malt");
            } else if(locationParam.equals("Banff")) {
                distilleryList.add("glen_deveron_distillery");
                distilleryList.add("macduff_distillery");
            } else if(locationParam.equals("Banffshire")) {
                distilleryList.add("aultmore_distillery");
                distilleryList.add("benrinnes");
                distilleryList.add("dufftown_distillery");
                distilleryList.add("glenallachie");
                distilleryList.add("glendullan_distillery");
            } else if(locationParam.equals("Blackford")) {
                distilleryList.add("tullibardine_distillery");
            } else if(locationParam.equals("Bowmore")) {
                distilleryList.add("gartbreck_distillery");
            } else if(locationParam.equals("Brora")) {
                distilleryList.add("clynelish_distillery");
            } else if(locationParam.equals("Buckie")) {
                distilleryList.add("inchgower_distillery");
            } else if(locationParam.equals("Campbeltown")) {
                distilleryList.add("glengyle");
            } else if(locationParam.equals("Carbost, Isle of Skye")) {
                distilleryList.add("talisker");
            } else if(locationParam.equals("Charlestown-of-Aberlour")) {
                distilleryList.add("aberlour_distillery");
            } else if(locationParam.equals("Craigellachie")) {
                distilleryList.add("the_macallan");
            } else if(locationParam.equals("Craigellachie, Moray")) {
                distilleryList.add("craigellachie_distillery");
            } else if(locationParam.equals("Crieff")) {
                distilleryList.add("glenturret_distillery");
            } else if(locationParam.equals("Cromdale")) {
                distilleryList.add("balmenach");
            } else if(locationParam.equals("Dalmuir")) {
                distilleryList.add("auchentoshan");
            } else if(locationParam.equals("Dalwhinnie")) {
                distilleryList.add("dalwhinnie_single_malt");
            } else if(locationParam.equals("Doune")) {
                distilleryList.add("deanston_distillery");
            } else if(locationParam.equals("Drumguish")) {
                distilleryList.add("the_speyside_distillery");
            } else if(locationParam.equals("Dufftown")) {
                distilleryList.add("balvenie");
                distilleryList.add("glenfiddich");
                distilleryList.add("kininvie_distillery");
            } else if(locationParam.equals("Dumgoyne")) {
                distilleryList.add("glengoyne_single_malt");
            } else if(locationParam.equals("Easter Ross")) {
                distilleryList.add("invergordon");
            } else if(locationParam.equals("Edderton")) {
                distilleryList.add("balblair_distillery");
            } else if(locationParam.equals("Edinburgh")) {
                distilleryList.add("north_british_distillery");
            } else if(locationParam.equals("Elgin")) {
                distilleryList.add("mannochmore");
                distilleryList.add("glen_moray");
                distilleryList.add("linkwood_whisky_distillery");
                distilleryList.add("longmorn_distillery");
                distilleryList.add("mannochmore");
            } else if(locationParam.equals("Elign")) {
                distilleryList.add("miltonduff");
            } else if(locationParam.equals("Fife")) {
                distilleryList.add("daftmill_distillery");
                distilleryList.add("cameronbridge");
            } else if(locationParam.equals("Forres")) {
                distilleryList.add("benromach");
            } else if(locationParam.equals("Fort William")) {
                distilleryList.add("ben_nevis_distillery");
            } else if(locationParam.equals("Girvan, Ayrshire")) {
                distilleryList.add("ailsa_bay");
            } else if(locationParam.equals("Glasgow")) {
                distilleryList.add("strathclyde_grain_distillery");
                distilleryList.add("port_dundas");
            } else if(locationParam.equals("Glenrinnes")) {
                distilleryList.add("allt_a_bhainne");
            } else if(locationParam.equals("Grantown N Spey")) {
                distilleryList.add("tormore_single_malt");
            } else if(locationParam.equals("Haymarket, Edinburgh")) {
                distilleryList.add("caledonian");
            } else if(locationParam.equals("Huntly")) {
                distilleryList.add("knockdhu_distillery");
            } else if(locationParam.equals("Isle of Islay")) {
                distilleryList.add("bowmore_single_malt");
                distilleryList.add("bruichladdich");
            } else if(locationParam.equals("Isle of Lewis")) {
                distilleryList.add("abhainn_dearg");
            } else if(locationParam.equals("Isle of Mull")) {
                distilleryList.add("tobermory_distillery");
            } else if(locationParam.equals("Jura")) {
                distilleryList.add("isle_of_jura_single_malt");
            } else if(locationParam.equals("Keith")) {
                distilleryList.add("glen_keith");
                distilleryList.add("mortlach_distillery");
                distilleryList.add("strathisla_distillery");
                distilleryList.add("strathmill");
            } else if(locationParam.equals("Kennethmont")) {
                distilleryList.add("ardmore_single_malt");
            } else if(locationParam.equals("Kilchoman")) {
                distilleryList.add("kilchoman_distillery");
            } else if(locationParam.equals("Kirkwall")) {
                distilleryList.add("highland_park_distillery");
                distilleryList.add("scapa");
            } else if(locationParam.equals("Knock")) {
                distilleryList.add("ancnoc");
            } else if(locationParam.equals("Knockando")) {
                distilleryList.add("cardhu");
                distilleryList.add("knockando");
                distilleryList.add("tamdhu");
            } else if(locationParam.equals("Laurencekirk")) {
                distilleryList.add("fettercairn_whisky_distillery");
            } else if(locationParam.equals("Livingston")) {
                distilleryList.add("glen_turner");
            } else if(locationParam.equals("Lochranza")) {
                distilleryList.add("arran_single_malt");
            } else if(locationParam.equals("Methven")) {
                distilleryList.add("strathearn");
            } else if(locationParam.equals("Morayshire")) {
                distilleryList.add("benriach");
                distilleryList.add("glenburgie");
                distilleryList.add("glen_elgin_distillery");
            } else if(locationParam.equals("Muir of Ord")) {
                distilleryList.add("glen_ord_distillery");
            } else if(locationParam.equals("Mulben")) {
                distilleryList.add("auchroisk");
                distilleryList.add("glentauchers_distillery");
            } else if(locationParam.equals("Mull of Kintyre")) {
                distilleryList.add("glen_scotia");
                distilleryList.add("springbank_distillery");
            } else if(locationParam.equals("Nairn")) {
                distilleryList.add("royal_brackla_single_malt");
            } else if(locationParam.equals("Oban")) {
                distilleryList.add("oban_distillery");
            } else if(locationParam.equals("Oldmeldrum")) {
                distilleryList.add("glen_garioch_distillery");
            } else if(locationParam.equals("Pencaitland")) {
                distilleryList.add("glenkinchie");
            } else if(locationParam.equals("Pitlochry")) {
                distilleryList.add("edradour");
            } else if(locationParam.equals("Pitlochry, Perthshire")) {
                distilleryList.add("blair_athol_distillery");
            } else if(locationParam.equals("Port Askaig")) {
                distilleryList.add("bunnahabhain_distillery");
                distilleryList.add("caol_ila");
            } else if(locationParam.equals("Port Ellen")) {
                distilleryList.add("ardbeg");
                distilleryList.add("lagavulin_single_malt");
                distilleryList.add("laphroaig");
            } else if(locationParam.equals("Portsoy")) {
                distilleryList.add("glenglassaugh_distillery");
            } else if(locationParam.equals("Roseisle")) {
                distilleryList.add("roseisle");
            } else if(locationParam.equals("Rothes")) {
                distilleryList.add("glen_grant_distillery");
                distilleryList.add("glenrothes_distillery");
                distilleryList.add("glen_spey_distillery");
                distilleryList.add("speyburn");
            } else if(locationParam.equals("Scotland")) {
                distilleryList.add("auchinblae");
                distilleryList.add("ballechin");
                distilleryList.add("banff_distillery");
                distilleryList.add("ben_wyvis_distillery");
                distilleryList.add("clynelish");
                distilleryList.add("caperdonich_distillery");
                distilleryList.add("coleburn");
                distilleryList.add("convalmore");
                distilleryList.add("dallas_dhu_distillery");
                distilleryList.add("finnieston_distillery");
                distilleryList.add("glen_albyn");
                distilleryList.add("glencraig");
                distilleryList.add("glenesk");
                distilleryList.add("glenflagler");
                distilleryList.add("glenlochy");
                distilleryList.add("glen_mhor");
                distilleryList.add("glenugie_distillery");
                distilleryList.add("glenury_whisky_distillery");
                distilleryList.add("hazelburn_distillery");
                distilleryList.add("inverleven");
                distilleryList.add("imperial_distillery");
                distilleryList.add("killyloch");
                distilleryList.add("kinclaith");
                distilleryList.add("ladyburn_distillery");
                distilleryList.add("littlemill_whisky_distillery");
                distilleryList.add("lochindaal");
                distilleryList.add("lochside_distillery");
                distilleryList.add("millburn_distillery");
                distilleryList.add("north_port_distillery");
                distilleryList.add("parkmore_distillery");
                distilleryList.add("pittyvaich_distillery");
                distilleryList.add("port_charlotte_distillery");
                distilleryList.add("port_ellen_distillery");
                distilleryList.add("rosebank_distillery");
                distilleryList.add("st_magdalene_distillery");
                distilleryList.add("towiemore");
            } else if(locationParam.equals("South Ayrshire")) {
                distilleryList.add("girvan_distillery");
            } else if(locationParam.equals("Tain")) {
                distilleryList.add("glenmorangie");
            } else if(locationParam.equals("Thurso")) {
                distilleryList.add("wolfburn");
            } else if(locationParam.equals("Tomatin")) {
                distilleryList.add("tomatin_distillery");
            } else if(locationParam.equals("Tomnavoulin")) {
                distilleryList.add("tamnavulin_whisky_distillery");
            } else if(locationParam.equals("Tullibody")) {
                distilleryList.add("cambus_clackmannanshire");
            } else if(locationParam.equals("West Dunbartonshire")) {
                distilleryList.add("dumbarton");
            } else if(locationParam.equals("Wick")) {
                distilleryList.add("old_pulteney");
            } else if(locationParam.equals("Wigtown")) {
                distilleryList.add("bladnoch_distillery");
            }
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("all")) {
            distilleryList.add("aberfeldy_whisky_distillery");
            distilleryList.add("aberlour_distillery");
            distilleryList.add("abhainn_dearg");
            distilleryList.add("ailsa_bay");
            distilleryList.add("allt_a_bhainne");
            distilleryList.add("ancnoc");
            distilleryList.add("annandale_distillery");
            distilleryList.add("ardbeg");
            distilleryList.add("ardmore_single_malt");
            distilleryList.add("ardnamurchan_distillery");
            distilleryList.add("arran_single_malt");
            distilleryList.add("auchentoshan");
            distilleryList.add("auchinblae");
            distilleryList.add("auchroisk");
            distilleryList.add("aultmore_distillery");
            distilleryList.add("balblair_distillery");
            distilleryList.add("ballechin");
            distilleryList.add("balmenach");
            distilleryList.add("balvenie");
            distilleryList.add("banff_distillery");
            distilleryList.add("ben_nevis_distillery");
            distilleryList.add("benriach");
            distilleryList.add("benrinnes");
            distilleryList.add("benromach");
            distilleryList.add("ben_wyvis_distillery");
            distilleryList.add("bladnoch_distillery");
            distilleryList.add("blair_athol_distillery");
            distilleryList.add("bowmore_single_malt");
            distilleryList.add("braeval_distillery");
            distilleryList.add("bruichladdich");
            distilleryList.add("bunnahabhain_distillery");
            distilleryList.add("caledonian");
            distilleryList.add("cambus_clackmannanshire");
            distilleryList.add("cameronbridge");
            distilleryList.add("caol_ila");
            distilleryList.add("caperdonich_distillery");
            distilleryList.add("cardhu");
            distilleryList.add("carsebridge");
            distilleryList.add("clynelish");
            distilleryList.add("clynelish_distillery");
            distilleryList.add("coleburn");
            distilleryList.add("convalmore");
            distilleryList.add("cragganmore");
            distilleryList.add("craigellachie_distillery");
            distilleryList.add("daftmill_distillery");
            distilleryList.add("dailuaine");
            distilleryList.add("dallas_dhu_distillery");
            distilleryList.add("dalmore_single_malt");
            distilleryList.add("dalwhinnie_single_malt");
            distilleryList.add("deanston_distillery");
            distilleryList.add("dufftown_distillery");
            distilleryList.add("dumbarton");
            distilleryList.add("edradour");
            distilleryList.add("fettercairn_whisky_distillery");
            distilleryList.add("finnieston_distillery");
            distilleryList.add("gartbreck_distillery");
            distilleryList.add("girvan_distillery");
            distilleryList.add("glen_albyn");
            distilleryList.add("glenallachie");
            distilleryList.add("glenburgie");
            distilleryList.add("glencadam_distillery");
            distilleryList.add("glencraig");
            distilleryList.add("glen_deveron_distillery");
            distilleryList.add("glendronach_distillery");
            distilleryList.add("glendullan_distillery");
            distilleryList.add("glen_elgin_distillery");
            distilleryList.add("glenesk");
            distilleryList.add("glenfarclas_single_malt");
            distilleryList.add("glenfiddich");
            distilleryList.add("glenflagler");
            distilleryList.add("glen_garioch_distillery");
            distilleryList.add("glenglassaugh_distillery");
            distilleryList.add("glengoyne_single_malt");
            distilleryList.add("glen_grant_distillery");
            distilleryList.add("glengyle");
            distilleryList.add("glen_keith");
            distilleryList.add("glenkinchie");
            distilleryList.add("glenlochy");
            distilleryList.add("glen_mhor");
            distilleryList.add("glenmorangie");
            distilleryList.add("glen_moray");
            distilleryList.add("glen_ord_distillery");
            distilleryList.add("glenrothes_distillery");
            distilleryList.add("glen_scotia");
            distilleryList.add("glen_spey_distillery");
            distilleryList.add("glentauchers_distillery");
            distilleryList.add("glen_turner");
            distilleryList.add("glenturret_distillery");
            distilleryList.add("glenugie_distillery");
            distilleryList.add("glenury_whisky_distillery");
            distilleryList.add("hazelburn_distillery");
            distilleryList.add("highland_park_distillery");
            distilleryList.add("imperial_distillery");
            distilleryList.add("inchgower_distillery");
            distilleryList.add("invergordon");
            distilleryList.add("inverleven");
            distilleryList.add("isle_of_jura_single_malt");
            distilleryList.add("kilchoman_distillery");
            distilleryList.add("killyloch");
            distilleryList.add("kinclaith");
            distilleryList.add("kininvie_distillery");
            distilleryList.add("knockando");
            distilleryList.add("knockdhu_distillery");
            distilleryList.add("ladyburn_distillery");
            distilleryList.add("lagavulin_single_malt");
            distilleryList.add("laphroaig");
            distilleryList.add("linkwood_whisky_distillery");
            distilleryList.add("littlemill_whisky_distillery");
            distilleryList.add("lochindaal");
            distilleryList.add("loch_lomond_distillery");
            distilleryList.add("loch_lomond_distillery");
            distilleryList.add("lochside_distillery");
            distilleryList.add("longmorn_distillery");
            distilleryList.add("macduff_distillery");
            distilleryList.add("mannochmore");
            distilleryList.add("mannochmore");
            distilleryList.add("millburn_distillery");
            distilleryList.add("miltonduff");
            distilleryList.add("mortlach_distillery");
            distilleryList.add("north_british_distillery");
            distilleryList.add("north_port_distillery");
            distilleryList.add("oban_distillery");
            distilleryList.add("old_pulteney");
            distilleryList.add("parkmore_distillery");
            distilleryList.add("pittyvaich_distillery");
            distilleryList.add("port_charlotte_distillery");
            distilleryList.add("port_dundas");
            distilleryList.add("port_ellen_distillery");
            distilleryList.add("rosebank_distillery");
            distilleryList.add("roseisle");
            distilleryList.add("royal_brackla_single_malt");
            distilleryList.add("royal_lochnagar_distillery");
            distilleryList.add("scapa");
            distilleryList.add("speyburn");
            distilleryList.add("springbank_distillery");
            distilleryList.add("st_magdalene_distillery");
            distilleryList.add("strathclyde_grain_distillery");
            distilleryList.add("strathearn");
            distilleryList.add("strathisla_distillery");
            distilleryList.add("strathmill");
            distilleryList.add("talisker");
            distilleryList.add("tamdhu");
            distilleryList.add("tamnavulin_whisky_distillery");
            distilleryList.add("teaninich_distillery");
            distilleryList.add("the_glenlivet");
            distilleryList.add("the_macallan");
            distilleryList.add("the_speyside_distillery");
            distilleryList.add("tobermory_distillery");
            distilleryList.add("tomatin_distillery");
            distilleryList.add("tomintoul_distillery");
            distilleryList.add("tormore_single_malt");
            distilleryList.add("towiemore");
            distilleryList.add("tullibardine_distillery");
            distilleryList.add("wolfburn");
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("open")) {
            distilleryList.add("aberlour_distillery");
            distilleryList.add("abhainn_dearg");
            distilleryList.add("ailsa_bay");
            distilleryList.add("allt_a_bhainne");
            distilleryList.add("ancnoc");
            distilleryList.add("annandale_distillery");
            distilleryList.add("ardbeg");
            distilleryList.add("ardmore_single_malt");
            distilleryList.add("ardnamurchan_distillery");
            distilleryList.add("arran_single_malt");
            distilleryList.add("auchentoshan");
            distilleryList.add("auchroisk");
            distilleryList.add("aultmore_distillery");
            distilleryList.add("balblair_distillery");
            distilleryList.add("balmenach");
            distilleryList.add("balvenie");
            distilleryList.add("ben_nevis_distillery");
            distilleryList.add("benriach");
            distilleryList.add("benrinnes");
            distilleryList.add("benromach");
            distilleryList.add("bladnoch_distillery");
            distilleryList.add("blair_athol_distillery");
            distilleryList.add("bowmore_single_malt");
            distilleryList.add("braeval_distillery");
            distilleryList.add("bruichladdich");
            distilleryList.add("bunnahabhain_distillery");
            distilleryList.add("cameronbridge");
            distilleryList.add("caol_ila");
            distilleryList.add("cardhu");
            distilleryList.add("clynelish_distillery");
            distilleryList.add("cragganmore");
            distilleryList.add("craigellachie_distillery");
            distilleryList.add("daftmill_distillery");
            distilleryList.add("dailuaine");
            distilleryList.add("dalmore_single_malt");
            distilleryList.add("dalwhinnie_single_malt");
            distilleryList.add("deanston_distillery");
            distilleryList.add("dufftown_distillery");
            distilleryList.add("edradour");
            distilleryList.add("fettercairn_whisky_distillery");
            distilleryList.add("gartbreck_distillery");
            distilleryList.add("girvan_distillery");
            distilleryList.add("glenallachie");
            distilleryList.add("glenburgie");
            distilleryList.add("glencadam_distillery");
            distilleryList.add("glen_deveron_distillery");
            distilleryList.add("glendronach_distillery");
            distilleryList.add("glendullan_distillery");
            distilleryList.add("glen_elgin_distillery");
            distilleryList.add("glenfarclas_single_malt");
            distilleryList.add("glenfiddich");
            distilleryList.add("glen_garioch_distillery");
            distilleryList.add("glenglassaugh_distillery");
            distilleryList.add("glengoyne_single_malt");
            distilleryList.add("glen_grant_distillery");
            distilleryList.add("glengyle");
            distilleryList.add("glen_keith");
            distilleryList.add("glenkinchie");
            distilleryList.add("glenmorangie");
            distilleryList.add("glen_moray");
            distilleryList.add("glen_ord_distillery");
            distilleryList.add("glenrothes_distillery");
            distilleryList.add("glen_scotia");
            distilleryList.add("glen_spey_distillery");
            distilleryList.add("glentauchers_distillery");
            distilleryList.add("glen_turner");
            distilleryList.add("glenturret_distillery");
            distilleryList.add("highland_park_distillery");
            distilleryList.add("inchgower_distillery");
            distilleryList.add("invergordon");
            distilleryList.add("isle_of_jura_single_malt");
            distilleryList.add("kilchoman_distillery");
            distilleryList.add("kininvie_distillery");
            distilleryList.add("knockando");
            distilleryList.add("knockdhu_distillery");
            distilleryList.add("lagavulin_single_malt");
            distilleryList.add("laphroaig");
            distilleryList.add("linkwood_whisky_distillery");
            distilleryList.add("loch_lomond_distillery");
            distilleryList.add("loch_lomond_distillery");
            distilleryList.add("longmorn_distillery");
            distilleryList.add("macduff_distillery");
            distilleryList.add("mannochmore");
            distilleryList.add("mannochmore");
            distilleryList.add("miltonduff");
            distilleryList.add("mortlach_distillery");
            distilleryList.add("north_british_distillery");
            distilleryList.add("oban_distillery");
            distilleryList.add("old_pulteney");
            distilleryList.add("roseisle");
            distilleryList.add("royal_brackla_single_malt");
            distilleryList.add("royal_lochnagar_distillery");
            distilleryList.add("scapa");
            distilleryList.add("speyburn");
            distilleryList.add("springbank_distillery");
            distilleryList.add("strathclyde_grain_distillery");
            distilleryList.add("strathearn");
            distilleryList.add("strathisla_distillery");
            distilleryList.add("strathmill");
            distilleryList.add("talisker");
            distilleryList.add("tamdhu");
            distilleryList.add("tamnavulin_whisky_distillery");
            distilleryList.add("teaninich_distillery");
            distilleryList.add("the_glenlivet");
            distilleryList.add("the_macallan");
            distilleryList.add("the_speyside_distillery");
            distilleryList.add("tobermory_distillery");
            distilleryList.add("tomatin_distillery");
            distilleryList.add("tomintoul_distillery");
            distilleryList.add("tormore_single_malt");
            distilleryList.add("tullibardine_distillery");
            distilleryList.add("wolfburn");
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("malt")) {
            distilleryList.add("aberlour_distillery");
            distilleryList.add("abhainn_dearg");
            distilleryList.add("ailsa_bay");
            distilleryList.add("allt_a_bhainne");
            distilleryList.add("ancnoc");
            distilleryList.add("annandale_distillery");
            distilleryList.add("ardbeg");
            distilleryList.add("ardmore_single_malt");
            distilleryList.add("ardnamurchan_distillery");
            distilleryList.add("arran_single_malt");
            distilleryList.add("auchentoshan");
            distilleryList.add("auchinblae");
            distilleryList.add("auchroisk");
            distilleryList.add("aultmore_distillery");
            distilleryList.add("balblair_distillery");
            distilleryList.add("ballechin");
            distilleryList.add("balmenach");
            distilleryList.add("balvenie");
            distilleryList.add("banff_distillery");
            distilleryList.add("ben_nevis_distillery");
            distilleryList.add("benriach");
            distilleryList.add("benrinnes");
            distilleryList.add("benromach");
            distilleryList.add("ben_wyvis_distillery");
            distilleryList.add("bladnoch_distillery");
            distilleryList.add("blair_athol_distillery");
            distilleryList.add("bowmore_single_malt");
            distilleryList.add("braeval_distillery");
            distilleryList.add("bruichladdich");
            distilleryList.add("bunnahabhain_distillery");
            distilleryList.add("caol_ila");
            distilleryList.add("caperdonich_distillery");
            distilleryList.add("cardhu");
            distilleryList.add("clynelish");
            distilleryList.add("clynelish_distillery");
            distilleryList.add("coleburn");
            distilleryList.add("convalmore");
            distilleryList.add("cragganmore");
            distilleryList.add("craigellachie_distillery");
            distilleryList.add("daftmill_distillery");
            distilleryList.add("dailuaine");
            distilleryList.add("dallas_dhu_distillery");
            distilleryList.add("dalmore_single_malt");
            distilleryList.add("dalwhinnie_single_malt");
            distilleryList.add("deanston_distillery");
            distilleryList.add("dufftown_distillery");
            distilleryList.add("edradour");
            distilleryList.add("fettercairn_whisky_distillery");
            distilleryList.add("finnieston_distillery");
            distilleryList.add("gartbreck_distillery");
            distilleryList.add("glen_albyn");
            distilleryList.add("glenallachie");
            distilleryList.add("glenburgie");
            distilleryList.add("glencadam_distillery");
            distilleryList.add("glencraig");
            distilleryList.add("glen_deveron_distillery");
            distilleryList.add("glendronach_distillery");
            distilleryList.add("glendullan_distillery");
            distilleryList.add("glen_elgin_distillery");
            distilleryList.add("glenesk");
            distilleryList.add("glenfarclas_single_malt");
            distilleryList.add("glenfiddich");
            distilleryList.add("glenflagler");
            distilleryList.add("glen_garioch_distillery");
            distilleryList.add("glenglassaugh_distillery");
            distilleryList.add("glengoyne_single_malt");
            distilleryList.add("glen_grant_distillery");
            distilleryList.add("glengyle");
            distilleryList.add("glen_keith");
            distilleryList.add("glenkinchie");
            distilleryList.add("glenlochy");
            distilleryList.add("glen_mhor");
            distilleryList.add("glenmorangie");
            distilleryList.add("glen_moray");
            distilleryList.add("glen_ord_distillery");
            distilleryList.add("glenrothes_distillery");
            distilleryList.add("glen_scotia");
            distilleryList.add("glen_spey_distillery");
            distilleryList.add("glentauchers_distillery");
            distilleryList.add("glenturret_distillery");
            distilleryList.add("glenugie_distillery");
            distilleryList.add("glenury_whisky_distillery");
            distilleryList.add("hazelburn_distillery");
            distilleryList.add("highland_park_distillery");
            distilleryList.add("imperial_distillery");
            distilleryList.add("inchgower_distillery");
            distilleryList.add("inverleven");
            distilleryList.add("isle_of_jura_single_malt");
            distilleryList.add("kilchoman_distillery");
            distilleryList.add("killyloch");
            distilleryList.add("kinclaith");
            distilleryList.add("kininvie_distillery");
            distilleryList.add("knockando");
            distilleryList.add("knockdhu_distillery");
            distilleryList.add("ladyburn_distillery");
            distilleryList.add("lagavulin_single_malt");
            distilleryList.add("laphroaig");
            distilleryList.add("linkwood_whisky_distillery");
            distilleryList.add("littlemill_whisky_distillery");
            distilleryList.add("lochindaal");
            distilleryList.add("loch_lomond_distillery");
            distilleryList.add("lochside_distillery");
            distilleryList.add("longmorn_distillery");
            distilleryList.add("macduff_distillery");
            distilleryList.add("mannochmore");
            distilleryList.add("mannochmore");
            distilleryList.add("millburn_distillery");
            distilleryList.add("miltonduff");
            distilleryList.add("mortlach_distillery");
            distilleryList.add("north_port_distillery");
            distilleryList.add("oban_distillery");
            distilleryList.add("old_pulteney");
            distilleryList.add("parkmore_distillery");
            distilleryList.add("pittyvaich_distillery");
            distilleryList.add("port_charlotte_distillery");
            distilleryList.add("port_ellen_distillery");
            distilleryList.add("rosebank_distillery");
            distilleryList.add("roseisle");
            distilleryList.add("royal_brackla_single_malt");
            distilleryList.add("royal_lochnagar_distillery");
            distilleryList.add("scapa");
            distilleryList.add("speyburn");
            distilleryList.add("springbank_distillery");
            distilleryList.add("st_magdalene_distillery");
            distilleryList.add("strathearn");
            distilleryList.add("strathisla_distillery");
            distilleryList.add("strathmill");
            distilleryList.add("talisker");
            distilleryList.add("tamdhu");
            distilleryList.add("tamnavulin_whisky_distillery");
            distilleryList.add("teaninich_distillery");
            distilleryList.add("the_glenlivet");
            distilleryList.add("the_macallan");
            distilleryList.add("the_speyside_distillery");
            distilleryList.add("tobermory_distillery");
            distilleryList.add("tomatin_distillery");
            distilleryList.add("tomintoul_distillery");
            distilleryList.add("tormore_single_malt");
            distilleryList.add("towiemore");
            distilleryList.add("tullibardine_distillery");
            distilleryList.add("wolfburn");
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("grain")) {
            distilleryList.add("caledonian");
            distilleryList.add("cambus_clackmannanshire");
            distilleryList.add("cameronbridge");
            distilleryList.add("carsebridge");
            distilleryList.add("dumbarton");
            distilleryList.add("girvan_distillery");
            distilleryList.add("glen_turner");
            distilleryList.add("invergordon");
            distilleryList.add("loch_lomond_distillery");
            distilleryList.add("north_british_distillery");
            distilleryList.add("port_dundas");
            distilleryList.add("strathclyde_grain_distillery");
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("closed")) {
            distilleryList.add("ballechin");
            distilleryList.add("banff_distillery");
            distilleryList.add("ben_wyvis_distillery");
            distilleryList.add("caledonian");
            distilleryList.add("cambus_clackmannanshire");
            distilleryList.add("caperdonich_distillery");
            distilleryList.add("carsebridge");
            distilleryList.add("clynelish");
            distilleryList.add("coleburn");
            distilleryList.add("convalmore");
            distilleryList.add("dallas_dhu_distillery");
            distilleryList.add("dumbarton");
            distilleryList.add("finnieston_distillery");
            distilleryList.add("glen_albyn");
            distilleryList.add("glencraig");
            distilleryList.add("glenesk");
            distilleryList.add("glenflagler");
            distilleryList.add("glenlochy");
            distilleryList.add("glen_mhor");
            distilleryList.add("glenugie_distillery");
            distilleryList.add("glenury_whisky_distillery");
            distilleryList.add("hazelburn_distillery");
            distilleryList.add("imperial_distillery");
            distilleryList.add("inverleven");
            distilleryList.add("killyloch");
            distilleryList.add("kinclaith");
            distilleryList.add("ladyburn_distillery");
            distilleryList.add("littlemill_whisky_distillery");
            distilleryList.add("lochindaal");
            distilleryList.add("lochside_distillery");
            distilleryList.add("millburn_distillery");
            distilleryList.add("north_port_distillery");
            distilleryList.add("parkmore_distillery");
            distilleryList.add("pittyvaich_distillery");
            distilleryList.add("port_charlotte_distillery");
            distilleryList.add("port_dundas");
            distilleryList.add("port_ellen_distillery");
            distilleryList.add("rosebank_distillery");
            distilleryList.add("st_magdalene_distillery");
            distilleryList.add("towiemore");
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("region")) {
            String regionParam = getIntent().getStringExtra("region");
            if(regionParam.equals("Campbeltown")) {
                distilleryList.add("glengyle");
                distilleryList.add("glen_scotia");
                distilleryList.add("springbank_distillery");
                distilleryList.add("hazelburn_distillery");
            } else if(regionParam.equals("Highland")) {
                distilleryList.add("ancnoc");
                distilleryList.add("ardnamurchan_distillery");
            } else if(regionParam.equals("Highlands")) {
                distilleryList.add("aberfeldy_whisky_distillery");
                distilleryList.add("ardmore_single_malt");
                distilleryList.add("balblair_distillery");
                distilleryList.add("ben_nevis_distillery");
                distilleryList.add("blair_athol_distillery");
                distilleryList.add("clynelish_distillery");
                distilleryList.add("dalmore_single_malt");
                distilleryList.add("dalwhinnie_single_malt");
                distilleryList.add("deanston_distillery");
                distilleryList.add("edradour");
                distilleryList.add("fettercairn_whisky_distillery");
                distilleryList.add("glencadam_distillery");
                distilleryList.add("glendronach_distillery");
                distilleryList.add("glen_garioch_distillery");
                distilleryList.add("glenglassaugh_distillery");
                distilleryList.add("glengoyne_single_malt");
                distilleryList.add("glenmorangie");
                distilleryList.add("glenturret_distillery");
                distilleryList.add("loch_lomond_distillery");
                distilleryList.add("royal_lochnagar_distillery");
                distilleryList.add("oban_distillery");
                distilleryList.add("old_pulteney");
                distilleryList.add("strathearn");
                distilleryList.add("teaninich_distillery");
                distilleryList.add("tomatin_distillery");
                distilleryList.add("tullibardine_distillery");
                distilleryList.add("wolfburn");
                distilleryList.add("auchinblae");
                distilleryList.add("ballechin");
                distilleryList.add("ben_wyvis_distillery");
                distilleryList.add("clynelish");
                distilleryList.add("glen_albyn");
                distilleryList.add("glenesk");
                distilleryList.add("glenlochy");
                distilleryList.add("glen_mhor");
                distilleryList.add("glenugie_distillery");
                distilleryList.add("glenury_whisky_distillery");
                distilleryList.add("lochside_distillery");
                distilleryList.add("north_port_distillery");
            } else if(regionParam.equals("Islands")) {
                distilleryList.add("abhainn_dearg");
                distilleryList.add("arran_single_malt");
                distilleryList.add("highland_park_distillery");
                distilleryList.add("isle_of_jura_single_malt");
                distilleryList.add("scapa");
                distilleryList.add("talisker");
                distilleryList.add("tobermory_distillery");
            } else if(regionParam.equals("Islay")) {
                distilleryList.add("ardbeg");
                distilleryList.add("bowmore_single_malt");
                distilleryList.add("bruichladdich");
                distilleryList.add("bunnahabhain_distillery");
                distilleryList.add("caol_ila");
                distilleryList.add("gartbreck_distillery");
                distilleryList.add("kilchoman_distillery");
                distilleryList.add("lagavulin_single_malt");
                distilleryList.add("laphroaig");
                distilleryList.add("lochindaal");
                distilleryList.add("port_charlotte_distillery");
                distilleryList.add("port_ellen_distillery");
            } else if(regionParam.equals("Lowland")) {
                distilleryList.add("annandale_distillery");
                distilleryList.add("finnieston_distillery");
            } else if(regionParam.equals("Lowlands")) {
                distilleryList.add("ailsa_bay");
                distilleryList.add("auchentoshan");
                distilleryList.add("bladnoch_distillery");
                distilleryList.add("daftmill_distillery");
                distilleryList.add("glenkinchie");
                distilleryList.add("glenflagler");
                distilleryList.add("inverleven");
                distilleryList.add("killyloch");
                distilleryList.add("kinclaith");
                distilleryList.add("ladyburn_distillery");
                distilleryList.add("littlemill_whisky_distillery");
                distilleryList.add("rosebank_distillery");
                distilleryList.add("st_magdalene_distillery");
            } else if(regionParam.equals("Northern Highlands")) {
                distilleryList.add("glen_ord_distillery");
            } else if(regionParam.equals("Scotland")) {
                distilleryList.add("cameronbridge");
                distilleryList.add("north_british_distillery");
                distilleryList.add("strathclyde_grain_distillery");
                distilleryList.add("invergordon");
                distilleryList.add("girvan_distillery");
                distilleryList.add("loch_lomond_distillery");
                distilleryList.add("glen_turner");
                distilleryList.add("caledonian");
                distilleryList.add("cambus_clackmannanshire");
                distilleryList.add("carsebridge");
                distilleryList.add("dumbarton");
                distilleryList.add("port_dundas");
            } else if(regionParam.equals("Speyside")) {
                distilleryList.add("aberlour_distillery");
                distilleryList.add("allt_a_bhainne");
                distilleryList.add("auchroisk");
                distilleryList.add("aultmore_distillery");
                distilleryList.add("balmenach");
                distilleryList.add("balvenie");
                distilleryList.add("benriach");
                distilleryList.add("benrinnes");
                distilleryList.add("benromach");
                distilleryList.add("royal_brackla_single_malt");
                distilleryList.add("braeval_distillery");
                distilleryList.add("cardhu");
                distilleryList.add("cragganmore");
                distilleryList.add("craigellachie_distillery");
                distilleryList.add("dailuaine");
                distilleryList.add("dufftown_distillery");
                distilleryList.add("glenallachie");
                distilleryList.add("glenburgie");
                distilleryList.add("glen_deveron_distillery");
                distilleryList.add("glendullan_distillery");
                distilleryList.add("glen_elgin_distillery");
                distilleryList.add("glenfarclas_single_malt");
                distilleryList.add("glenfiddich");
                distilleryList.add("glen_grant_distillery");
                distilleryList.add("glen_keith");
                distilleryList.add("the_glenlivet");
                distilleryList.add("mannochmore");
                distilleryList.add("glen_moray");
                distilleryList.add("glenrothes_distillery");
                distilleryList.add("glen_spey_distillery");
                distilleryList.add("glentauchers_distillery");
                distilleryList.add("inchgower_distillery");
                distilleryList.add("kininvie_distillery");
                distilleryList.add("knockando");
                distilleryList.add("knockdhu_distillery");
                distilleryList.add("linkwood_whisky_distillery");
                distilleryList.add("longmorn_distillery");
                distilleryList.add("the_macallan");
                distilleryList.add("macduff_distillery");
                distilleryList.add("mannochmore");
                distilleryList.add("miltonduff");
                distilleryList.add("mortlach_distillery");
                distilleryList.add("roseisle");
                distilleryList.add("speyburn");
                distilleryList.add("the_speyside_distillery");
                distilleryList.add("strathisla_distillery");
                distilleryList.add("strathmill");
                distilleryList.add("tamdhu");
                distilleryList.add("tamnavulin_whisky_distillery");
                distilleryList.add("tomintoul_distillery");
                distilleryList.add("tormore_single_malt");
                distilleryList.add("banff_distillery");
                distilleryList.add("caperdonich_distillery");
                distilleryList.add("coleburn");
                distilleryList.add("convalmore");
                distilleryList.add("dallas_dhu_distillery");
                distilleryList.add("glencraig");
                distilleryList.add("imperial_distillery");
                distilleryList.add("millburn_distillery");
                distilleryList.add("parkmore_distillery");
                distilleryList.add("pittyvaich_distillery");
                distilleryList.add("towiemore");
            } else {
                distilleryList.add("zero_results");
            }
        } else if (Scottishwhiskydistilleries.ownerregionlocationclosedgrain.equals("owner")) {
            String ownerParam = getIntent().getStringExtra("owner");
            if (ownerParam.equals("Adelphi Whisky")) {
                distilleryList.add("ardnamurchan_distillery");
            } else if (ownerParam.equals("Angus Dundee Distiller")) {
                distilleryList.add("glencadam_distillery");
                distilleryList.add("tomintoul_distillery");
            } else if (ownerParam.equals("Annandale Distillery Company Limited")) {
                distilleryList.add("annandale_distillery");
            } else if (ownerParam.equals("Bacardi")) {
                distilleryList.add("aberfeldy_whisky_distillery");
                distilleryList.add("aultmore_distillery");
                distilleryList.add("benrinnes");
                distilleryList.add("royal_brackla_single_malt");
                distilleryList.add("craigellachie_distillery");
                distilleryList.add("glen_deveron_distillery");
                distilleryList.add("macduff_distillery");
            } else if (ownerParam.equals("Beam Suntory")) {
                distilleryList.add("ardmore_single_malt");
                distilleryList.add("bowmore_single_malt");
                distilleryList.add("laphroaig");
            } else if (ownerParam.equals("BenRiach Distillery Company")) {
                distilleryList.add("benriach");
                distilleryList.add("glendronach_distillery");
            } else if (ownerParam.equals("Berry Brothers & Rudd")) {
                distilleryList.add("glenrothes_distillery");
            } else if (ownerParam.equals("Burn Stewart Distillers")) {
                distilleryList.add("tobermory_distillery");
            } else if (ownerParam.equals("CL Financial")) {
                distilleryList.add("bunnahabhain_distillery");
                distilleryList.add("deanston_distillery");
            } else if (ownerParam.equals("Campari")) {
                distilleryList.add("glen_grant_distillery");
            } else if (ownerParam.equals("Diageo")) {
                distilleryList.add("auchroisk");
                distilleryList.add("blair_athol_distillery");
                distilleryList.add("caol_ila");
                distilleryList.add("cardhu");
                distilleryList.add("clynelish_distillery");
                distilleryList.add("cragganmore");
                distilleryList.add("dailuaine");
                distilleryList.add("dalwhinnie_single_malt");
                distilleryList.add("dufftown_distillery");
                distilleryList.add("glendullan_distillery");
                distilleryList.add("glen_elgin_distillery");
                distilleryList.add("glenkinchie");
                distilleryList.add("mannochmore");
                distilleryList.add("glen_ord_distillery");
                distilleryList.add("glen_spey_distillery");
                distilleryList.add("inchgower_distillery");
                distilleryList.add("knockando");
                distilleryList.add("lagavulin_single_malt");
                distilleryList.add("linkwood_whisky_distillery");
                distilleryList.add("royal_lochnagar_distillery");
                distilleryList.add("mannochmore");
                distilleryList.add("mortlach_distillery");
                distilleryList.add("oban_distillery");
                distilleryList.add("roseisle");
                distilleryList.add("strathmill");
                distilleryList.add("talisker");
                distilleryList.add("teaninich_distillery");
                distilleryList.add("cameronbridge");
                distilleryList.add("caledonian");
                distilleryList.add("cambus_clackmannanshire");
                distilleryList.add("port_dundas");
            } else if (ownerParam.equals("Diageo/The Edrington Group")) {
                distilleryList.add("north_british_distillery");
            } else if (ownerParam.equals("Edrington")) {
                distilleryList.add("highland_park_distillery");
                distilleryList.add("the_macallan");
            } else if (ownerParam.equals("Emperador Inc")) {
                distilleryList.add("dalmore_single_malt");
                distilleryList.add("fettercairn_whisky_distillery");
            } else if (ownerParam.equals("Emperador Inc.")) {
                distilleryList.add("invergordon");
            } else if (ownerParam.equals("Gartbreck Distilling Company")) {
                distilleryList.add("gartbreck_distillery");
            } else if (ownerParam.equals("Gordon & MacPhail")) {
                distilleryList.add("benromach");
            } else if (ownerParam.equals("Highland Distillers")) {
                distilleryList.add("glenturret_distillery");
            } else if (ownerParam.equals("Ian MacLeod Distillers")) {
                distilleryList.add("tamdhu");
            } else if (ownerParam.equals("Ian Macleod Distillers")) {
                distilleryList.add("glengoyne_single_malt");
            } else if (ownerParam.equals("Independent")) {
                distilleryList.add("abhainn_dearg");
                distilleryList.add("daftmill_distillery");
                distilleryList.add("glenglassaugh_distillery");
                distilleryList.add("kilchoman_distillery");
                distilleryList.add("springbank_distillery");
                distilleryList.add("strathearn");
                distilleryList.add("wolfburn");
            } else if (ownerParam.equals("Inver House Distillers")) {
                distilleryList.add("ancnoc");
            } else if (ownerParam.equals("Isle of Arran Distillers Ltd")) {
                distilleryList.add("arran_single_malt");
            } else if (ownerParam.equals("J. & G. Grant")) {
                distilleryList.add("glenfarclas_single_malt");
            } else if (ownerParam.equals("LVMH")) {
                distilleryList.add("ardbeg");
                distilleryList.add("glenmorangie");
            } else if (ownerParam.equals("La Martiniquaise")) {
                distilleryList.add("glen_moray");
                distilleryList.add("glen_turner");
            } else if (ownerParam.equals("Loch Lomond Distillers")) {
                distilleryList.add("loch_lomond_distillery");
            } else if (ownerParam.equals("Loch Lomond Distillery Company")) {
                distilleryList.add("loch_lomond_distillery");
            } else if (ownerParam.equals("Loch Lomond Group")) {
                distilleryList.add("glen_scotia");
            } else if (ownerParam.equals("Mitchells Glengyle Ltd")) {
                distilleryList.add("glengyle");
            } else if (ownerParam.equals("Morrison Bowmore")) {
                distilleryList.add("auchentoshan");
            } else if (ownerParam.equals("Morrison Bowmore Distillers")) {
                distilleryList.add("glen_garioch_distillery");
            } else if (ownerParam.equals("Nikka Whisky Distilling")) {
                distilleryList.add("ben_nevis_distillery");
            } else if (ownerParam.equals("Pernod Ricard")) {
                distilleryList.add("aberlour_distillery");
                distilleryList.add("allt_a_bhainne");
                distilleryList.add("braeval_distillery");
                distilleryList.add("glenallachie");
                distilleryList.add("glenburgie");
                distilleryList.add("glen_keith");
                distilleryList.add("the_glenlivet");
                distilleryList.add("glentauchers_distillery");
                distilleryList.add("longmorn_distillery");
                distilleryList.add("miltonduff");
                distilleryList.add("scapa");
                distilleryList.add("strathisla_distillery");
                distilleryList.add("tormore_single_malt");
                distilleryList.add("strathclyde_grain_distillery");
                distilleryList.add("dumbarton");
            } else if (ownerParam.equals("Picard Vins & Spiritueux")) {
                distilleryList.add("tullibardine_distillery");
            } else if (ownerParam.equals("Raymond and Colin Armstrong")) {
                distilleryList.add("bladnoch_distillery");
            } else if (ownerParam.equals("Rémy Cointreau")) {
                distilleryList.add("bruichladdich");
            } else if (ownerParam.equals("Scottish Grain Distillers")) {
                distilleryList.add("carsebridge");
            } else if (ownerParam.equals("Signatory Vintage Scotch Whisky Company")) {
                distilleryList.add("edradour");
            } else if (ownerParam.equals("Speyside Distillery Co. Ltd.")) {
                distilleryList.add("the_speyside_distillery");
            } else if (ownerParam.equals("Takara Shuzo Corp.")) {
                distilleryList.add("tomatin_distillery");
            } else if (ownerParam.equals("ThaiBev")) {
                distilleryList.add("balblair_distillery");
                distilleryList.add("balmenach");
                distilleryList.add("knockdhu_distillery");
                distilleryList.add("old_pulteney");
                distilleryList.add("speyburn");
            } else if (ownerParam.equals("United Breweries Group")) {
                distilleryList.add("isle_of_jura_single_malt");
            } else if (ownerParam.equals("Whyte & Mackay")) {
                distilleryList.add("tamnavulin_whisky_distillery");
            } else if (ownerParam.equals("William Grant & Sons")) {
                distilleryList.add("ailsa_bay");
                distilleryList.add("balvenie");
                distilleryList.add("glenfiddich");
                distilleryList.add("kininvie_distillery");
                distilleryList.add("girvan_distillery");
            } else {
                distilleryList.add("zero_results");
            }
        } else {
            distilleryList.add("zero_results");
        }
        //distilleryList.add("Aberfeldy");
        //Scottishwhiskydistilleries.distillerySearchList.add(c.)
        //distilleryList = Scottishwhiskydistilleries.distillerySearchList;
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.distillerytextview, distilleryList);
        setListAdapter(dataAdapter);
        ListView listView = getListView();
        // filtering for contents of ListView
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ScottishDistilleries.distillerySearchList.clear();
                Intent i = new Intent("");
                String distilleryChoice = ((TextView) view).getText().toString();
                Scottishwhiskydistilleries.distilleryChoice = distilleryChoice;
                i.setData(Uri.parse(distilleryChoice));
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
