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

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

//import com.jimsuplee.scottishdistilleries.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

import java.util.HashMap;
//import java.util.Map;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
//import android.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.widget.Toast;
import android.database.Cursor;
import android.widget.EditText;

import java.util.List;
import java.util.ArrayList;
//import com.jimsuplee.scottishdistilleries.R;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
//import android.R;
import android.net.Uri;

public class Scottishwhiskydistilleries extends ActionBarActivity {

    static final String TAG = "SCOT";
    static String ownerregionlocationclosedgrain = "";
    static String distilleryChoice = "zero_results";
    static List<String> distillerySearchList = new ArrayList<String>();
    HashMap<String, Integer> distilleryMap = new HashMap<String, Integer>();
    HashMap<String, Integer> photoMap = new HashMap<String, Integer>();
    HashMap<String, String> mapMap = new HashMap<String, String>();
    DBAdapter db;
    //final String[] owners = {"Adelphi Whisky", "Angus Dundee Distiller", "Annandale Distillery Company Limited", "Bacardi", "Beam Suntory", "BenRiach Distillery Company", "Berry Brothers & Rudd", "Burn Stewart Distillers", "CL Financial", "Campari", "Diageo", "Diageo/The Edrington Group", "Edrington", "Emperador Inc", "Emperador Inc.", "Gartbreck Distilling Company", "Gordon & MacPhail", "Highland Distillers", "Ian MacLeod Distillers", "Ian Macleod Distillers", "Independent", "Inver House Distillers", "Isle of Arran Distillers Ltd", "J. & G. Grant", "LVMH", "La Martiniquaise", "Loch Lomond Distillers", "Loch Lomond Distillery Company", "Loch Lomond Group", "Mitchells Glengyle Ltd", "Morrison Bowmore", "Morrison Bowmore Distillers", "Nikka Whisky Distilling", "Pernod Ricard", "Picard Vins & Spiritueux", "Raymond and Colin Armstrong", "Rémy Cointreau", "Scottish Grain Distillers", "Signatory Vintage Scotch Whisky Company", "Speyside Distillery Co. Ltd.", "Takara Shuzo Corp.", "ThaiBev", "United Breweries Group", "Whyte & Mackay", "William Grant & Sons"};
    //final String[] owners = getResources().getStringArray(R.array.owners);
    //Spinner s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            String destPath = "/data/data/" + getPackageName() + "/databases";
            File f = new File(destPath);
            if (!f.exists()) {
                f.mkdirs();
                f.createNewFile();
                Toast.makeText(this, "Please Wait...Database Being Created",
                        Toast.LENGTH_LONG).show();
                CopyDB(getBaseContext().getAssets().open("scottishdistilleries"),
                        new FileOutputStream(destPath + "/scottishdistilleries"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Now that we (hopefully) have an SQLiteDatabase available, lets make
        // an adapter and put it
        // into our global variable.
        db = new DBAdapter(this);

        photoMap.put("aberfeldy_whisky_distillery", R.drawable.aberfeldy_whisky_distillery);
        photoMap.put("aberlour_distillery", R.drawable.aberlour_distillery);
        photoMap.put("ardbeg", R.drawable.ardbeg);
        photoMap.put("ardmore_single_malt", R.drawable.ardmore_single_malt);
        photoMap.put("arran_single_malt", R.drawable.arran_single_malt);
        photoMap.put("auchroisk", R.drawable.auchroisk);
        photoMap.put("aultmore_distillery", R.drawable.aultmore_distillery);
        photoMap.put("balblair_distillery", R.drawable.balblair_distillery);
        photoMap.put("balvenie", R.drawable.balvenie);
        photoMap.put("ben_nevis_distillery", R.drawable.ben_nevis_distillery);
        photoMap.put("benrinnes", R.drawable.benrinnes);
        photoMap.put("benromach", R.drawable.benromach);
        photoMap.put("bladnoch_distillery", R.drawable.bladnoch_distillery);
        photoMap.put("blair_athol_distillery", R.drawable.blair_athol_distillery);
        photoMap.put("bowmore_single_malt", R.drawable.bowmore_single_malt);
        photoMap.put("bruichladdich", R.drawable.bruichladdich);
        photoMap.put("bunnahabhain_distillery", R.drawable.bunnahabhain_distillery);
        photoMap.put("cambus_clackmannanshire", R.drawable.cambus_clackmannanshire);
        photoMap.put("cameronbridge", R.drawable.cameronbridge);
        photoMap.put("caol_ila", R.drawable.caol_ila);
        photoMap.put("cardhu", R.drawable.cardhu);
        photoMap.put("cragganmore", R.drawable.cragganmore);
        photoMap.put("daftmill_distillery", R.drawable.daftmill_distillery);
        photoMap.put("dallas_dhu_distillery", R.drawable.dallas_dhu_distillery);
        photoMap.put("dalmore_single_malt", R.drawable.dalmore_single_malt);
        photoMap.put("dalwhinnie_single_malt", R.drawable.dalwhinnie_single_malt);
        photoMap.put("dumbarton", R.drawable.dumbarton);
        photoMap.put("edradour", R.drawable.edradour);
        photoMap.put("fettercairn_whisky_distillery", R.drawable.fettercairn_whisky_distillery);
        photoMap.put("finnieston_distillery", R.drawable.finnieston_distillery);
        photoMap.put("glenallachie", R.drawable.glenallachie);
        photoMap.put("glenburgie", R.drawable.glenburgie);
        photoMap.put("glendronach_distillery", R.drawable.glendronach_distillery);
        photoMap.put("glendullan_distillery", R.drawable.glendullan_distillery);
        photoMap.put("glenfarclas_single_malt", R.drawable.glenfarclas_single_malt);
        photoMap.put("glenfiddich", R.drawable.glenfiddich);
        photoMap.put("glenflagler", R.drawable.glenflagler);
        photoMap.put("glen_garioch_distillery", R.drawable.glen_garioch_distillery);
        photoMap.put("glenglassaugh_distillery", R.drawable.glenglassaugh_distillery);
        photoMap.put("glengoyne_single_malt", R.drawable.glengoyne_single_malt);
        photoMap.put("glen_grant_distillery", R.drawable.glen_grant_distillery);
        photoMap.put("glen_keith", R.drawable.glen_keith);
        photoMap.put("glenkinchie", R.drawable.glenkinchie);
        photoMap.put("glenmorangie", R.drawable.glenmorangie);
        photoMap.put("glen_moray", R.drawable.glen_moray);
        photoMap.put("glen_ord_distillery", R.drawable.glen_ord_distillery);
        photoMap.put("glenrothes_distillery", R.drawable.glenrothes_distillery);
        photoMap.put("glen_scotia", R.drawable.glen_scotia);
        photoMap.put("glenturret_distillery", R.drawable.glenturret_distillery);
        photoMap.put("glenugie_distillery", R.drawable.glenugie_distillery);
        photoMap.put("highland_park_distillery", R.drawable.highland_park_distillery);
        photoMap.put("invergordon", R.drawable.invergordon);
        photoMap.put("isle_of_jura_single_malt", R.drawable.isle_of_jura_single_malt);
        photoMap.put("kilchoman_distillery", R.drawable.kilchoman_distillery);
        photoMap.put("lagavulin_single_malt", R.drawable.lagavulin_single_malt);
        photoMap.put("laphroaig", R.drawable.laphroaig);
        photoMap.put("linkwood_whisky_distillery", R.drawable.linkwood_whisky_distillery);
        photoMap.put("littlemill_whisky_distillery", R.drawable.littlemill_whisky_distillery);
        photoMap.put("lochside_distillery", R.drawable.lochside_distillery);
        photoMap.put("mortlach_distillery", R.drawable.mortlach_distillery);
        photoMap.put("north_british_distillery", R.drawable.north_british_distillery);
        photoMap.put("oban_distillery", R.drawable.oban_distillery);
        photoMap.put("parkmore_distillery", R.drawable.parkmore_distillery);
        photoMap.put("pittyvaich_distillery", R.drawable.pittyvaich_distillery);
        photoMap.put("port_charlotte_distillery", R.drawable.port_charlotte_distillery);
        photoMap.put("port_dundas", R.drawable.port_dundas);
        photoMap.put("port_ellen_distillery", R.drawable.port_ellen_distillery);
        photoMap.put("rosebank_distillery", R.drawable.rosebank_distillery);
        photoMap.put("royal_lochnagar_distillery", R.drawable.royal_lochnagar_distillery);
        photoMap.put("scapa", R.drawable.scapa);
        photoMap.put("speyburn", R.drawable.speyburn);
        photoMap.put("springbank_distillery", R.drawable.springbank_distillery);
        photoMap.put("st_magdalene_distillery", R.drawable.st_magdalene_distillery);
        photoMap.put("strathclyde_grain_distillery", R.drawable.strathclyde_grain_distillery);
        photoMap.put("strathisla_distillery", R.drawable.strathisla_distillery);
        photoMap.put("strathmill", R.drawable.strathmill);
        photoMap.put("talisker", R.drawable.talisker);
        photoMap.put("tamdhu", R.drawable.tamdhu);
        photoMap.put("teaninich_distillery", R.drawable.teaninich_distillery);
        photoMap.put("the_glenlivet", R.drawable.the_glenlivet);
        photoMap.put("the_macallan", R.drawable.the_macallan);
        photoMap.put("the_speyside_distillery", R.drawable.the_speyside_distillery);
        photoMap.put("tobermory_distillery", R.drawable.tobermory_distillery);
        photoMap.put("tomatin_distillery", R.drawable.tomatin_distillery);
        photoMap.put("tomintoul_distillery", R.drawable.tomintoul_distillery);
        photoMap.put("tormore_single_malt", R.drawable.tormore_single_malt);
        photoMap.put("tullibardine_distillery", R.drawable.tullibardine_distillery);
        photoMap.put("zero_results", R.drawable.zero_results);
        photoMap.put("abhainn_dearg", R.drawable.erskine_nicol);
        photoMap.put("ailsa_bay", R.drawable.erskine_nicol);
        photoMap.put("allt_a_bhainne", R.drawable.erskine_nicol);
        photoMap.put("ancnoc", R.drawable.erskine_nicol);
        photoMap.put("annandale_distillery", R.drawable.erskine_nicol);
        photoMap.put("ardnamurchan_distillery", R.drawable.erskine_nicol);
        photoMap.put("auchentoshan", R.drawable.erskine_nicol);
        photoMap.put("auchinblae", R.drawable.erskine_nicol);
        photoMap.put("ballechin", R.drawable.erskine_nicol);
        photoMap.put("balmenach", R.drawable.erskine_nicol);
        photoMap.put("banff_distillery", R.drawable.erskine_nicol);
        photoMap.put("benriach", R.drawable.erskine_nicol);
        photoMap.put("ben_wyvis_distillery", R.drawable.erskine_nicol);
        photoMap.put("braeval_distillery", R.drawable.erskine_nicol);
        photoMap.put("caledonian", R.drawable.erskine_nicol);
        photoMap.put("caperdonich_distillery", R.drawable.erskine_nicol);
        photoMap.put("carsebridge", R.drawable.erskine_nicol);
        photoMap.put("clynelish", R.drawable.erskine_nicol);
        photoMap.put("clynelish_distillery", R.drawable.erskine_nicol);
        photoMap.put("coleburn", R.drawable.erskine_nicol);
        photoMap.put("convalmore", R.drawable.erskine_nicol);
        photoMap.put("craigellachie_distillery", R.drawable.erskine_nicol);
        photoMap.put("dailuaine", R.drawable.erskine_nicol);
        photoMap.put("deanston_distillery", R.drawable.erskine_nicol);
        photoMap.put("dufftown_distillery", R.drawable.erskine_nicol);
        photoMap.put("gartbreck_distillery", R.drawable.erskine_nicol);
        photoMap.put("girvan_distillery", R.drawable.erskine_nicol);
        photoMap.put("glen_albyn", R.drawable.erskine_nicol);
        photoMap.put("glencadam_distillery", R.drawable.erskine_nicol);
        photoMap.put("glencraig", R.drawable.erskine_nicol);
        photoMap.put("glen_deveron_distillery", R.drawable.erskine_nicol);
        photoMap.put("glen_elgin_distillery", R.drawable.erskine_nicol);
        photoMap.put("glenesk", R.drawable.erskine_nicol);
        photoMap.put("glengyle", R.drawable.erskine_nicol);
        photoMap.put("glenlochy", R.drawable.erskine_nicol);
        photoMap.put("glen_mhor", R.drawable.erskine_nicol);
        photoMap.put("glen_spey_distillery", R.drawable.erskine_nicol);
        photoMap.put("glentauchers_distillery", R.drawable.erskine_nicol);
        photoMap.put("glen_turner", R.drawable.erskine_nicol);
        photoMap.put("glenury_whisky_distillery", R.drawable.erskine_nicol);
        photoMap.put("hazelburn_distillery", R.drawable.erskine_nicol);
        photoMap.put("imperial_distillery", R.drawable.erskine_nicol);
        photoMap.put("inchgower_distillery", R.drawable.erskine_nicol);
        photoMap.put("inverleven", R.drawable.erskine_nicol);
        photoMap.put("killyloch", R.drawable.erskine_nicol);
        photoMap.put("kinclaith", R.drawable.erskine_nicol);
        photoMap.put("kininvie_distillery", R.drawable.erskine_nicol);
        photoMap.put("knockando", R.drawable.erskine_nicol);
        photoMap.put("knockdhu_distillery", R.drawable.erskine_nicol);
        photoMap.put("ladyburn_distillery", R.drawable.erskine_nicol);
        photoMap.put("lochindaal", R.drawable.erskine_nicol);
        photoMap.put("loch_lomond_distillery", R.drawable.erskine_nicol);
        photoMap.put("loch_lomond_distillery", R.drawable.erskine_nicol);
        photoMap.put("longmorn_distillery", R.drawable.erskine_nicol);
        photoMap.put("macduff_distillery", R.drawable.erskine_nicol);
        photoMap.put("mannochmore", R.drawable.erskine_nicol);
        photoMap.put("mannochmore", R.drawable.erskine_nicol);
        photoMap.put("millburn_distillery", R.drawable.erskine_nicol);
        photoMap.put("miltonduff", R.drawable.erskine_nicol);
        photoMap.put("north_port_distillery", R.drawable.erskine_nicol);
        photoMap.put("old_pulteney", R.drawable.erskine_nicol);
        photoMap.put("roseisle", R.drawable.erskine_nicol);
        photoMap.put("royal_brackla_single_malt", R.drawable.erskine_nicol);
        photoMap.put("strathearn", R.drawable.erskine_nicol);
        photoMap.put("tamnavulin_whisky_distillery", R.drawable.erskine_nicol);
        photoMap.put("towiemore", R.drawable.erskine_nicol);
        photoMap.put("wolfburn", R.drawable.erskine_nicol);

        distilleryMap.put("aberfeldy_whisky_distillery", R.string.aberfeldy_whisky_distillery);
        distilleryMap.put("aberlour_distillery", R.string.aberlour_distillery);
        distilleryMap.put("abhainn_dearg", R.string.abhainn_dearg);
        distilleryMap.put("ailsa_bay", R.string.ailsa_bay);
        distilleryMap.put("allt_a_bhainne", R.string.allt_a_bhainne);
        distilleryMap.put("ancnoc", R.string.ancnoc);
        distilleryMap.put("annandale_distillery", R.string.annandale_distillery);
        distilleryMap.put("ardbeg", R.string.ardbeg);
        distilleryMap.put("ardmore_single_malt", R.string.ardmore_single_malt);
        distilleryMap.put("ardnamurchan_distillery", R.string.ardnamurchan_distillery);
        distilleryMap.put("arran_single_malt", R.string.arran_single_malt);
        distilleryMap.put("auchentoshan", R.string.auchentoshan);
        distilleryMap.put("auchroisk", R.string.auchroisk);
        distilleryMap.put("aultmore_distillery", R.string.aultmore_distillery);
        distilleryMap.put("balblair_distillery", R.string.balblair_distillery);
        distilleryMap.put("balmenach", R.string.balmenach);
        distilleryMap.put("balvenie", R.string.balvenie);
        distilleryMap.put("ben_nevis_distillery", R.string.ben_nevis_distillery);
        distilleryMap.put("benriach", R.string.benriach);
        distilleryMap.put("benrinnes", R.string.benrinnes);
        distilleryMap.put("benromach", R.string.benromach);
        distilleryMap.put("bladnoch_distillery", R.string.bladnoch_distillery);
        distilleryMap.put("blair_athol_distillery", R.string.blair_athol_distillery);
        distilleryMap.put("bowmore_single_malt", R.string.bowmore_single_malt);
        distilleryMap.put("royal_brackla_single_malt", R.string.royal_brackla_single_malt);
        distilleryMap.put("braeval_distillery", R.string.braeval_distillery);
        distilleryMap.put("bruichladdich", R.string.bruichladdich);
        distilleryMap.put("bunnahabhain_distillery", R.string.bunnahabhain_distillery);
        distilleryMap.put("caol_ila", R.string.caol_ila);
        distilleryMap.put("cardhu", R.string.cardhu);
        distilleryMap.put("clynelish_distillery", R.string.clynelish_distillery);
        distilleryMap.put("cragganmore", R.string.cragganmore);
        distilleryMap.put("craigellachie_distillery", R.string.craigellachie_distillery);
        distilleryMap.put("daftmill_distillery", R.string.daftmill_distillery);
        distilleryMap.put("dailuaine", R.string.dailuaine);
        distilleryMap.put("dalmore_single_malt", R.string.dalmore_single_malt);
        distilleryMap.put("dalwhinnie_single_malt", R.string.dalwhinnie_single_malt);
        distilleryMap.put("deanston_distillery", R.string.deanston_distillery);
        distilleryMap.put("dufftown_distillery", R.string.dufftown_distillery);
        distilleryMap.put("edradour", R.string.edradour);
        distilleryMap.put("fettercairn_whisky_distillery", R.string.fettercairn_whisky_distillery);
        distilleryMap.put("gartbreck_distillery", R.string.gartbreck_distillery);
        distilleryMap.put("glenallachie", R.string.glenallachie);
        distilleryMap.put("glenburgie", R.string.glenburgie);
        distilleryMap.put("glencadam_distillery", R.string.glencadam_distillery);
        distilleryMap.put("glen_deveron_distillery", R.string.glen_deveron_distillery);
        distilleryMap.put("glendronach_distillery", R.string.glendronach_distillery);
        distilleryMap.put("glendullan_distillery", R.string.glendullan_distillery);
        distilleryMap.put("glen_elgin_distillery", R.string.glen_elgin_distillery);
        distilleryMap.put("glenfarclas_single_malt", R.string.glenfarclas_single_malt);
        distilleryMap.put("glenfiddich", R.string.glenfiddich);
        distilleryMap.put("glen_garioch_distillery", R.string.glen_garioch_distillery);
        distilleryMap.put("glenglassaugh_distillery", R.string.glenglassaugh_distillery);
        distilleryMap.put("glengoyne_single_malt", R.string.glengoyne_single_malt);
        distilleryMap.put("glen_grant_distillery", R.string.glen_grant_distillery);
        distilleryMap.put("glengyle", R.string.glengyle);
        distilleryMap.put("glen_keith", R.string.glen_keith);
        distilleryMap.put("glenkinchie", R.string.glenkinchie);
        distilleryMap.put("the_glenlivet", R.string.the_glenlivet);
        distilleryMap.put("mannochmore", R.string.mannochmore);
        distilleryMap.put("glenmorangie", R.string.glenmorangie);
        distilleryMap.put("glen_moray", R.string.glen_moray);
        distilleryMap.put("glen_ord_distillery", R.string.glen_ord_distillery);
        distilleryMap.put("glenrothes_distillery", R.string.glenrothes_distillery);
        distilleryMap.put("glen_scotia", R.string.glen_scotia);
        distilleryMap.put("glen_spey_distillery", R.string.glen_spey_distillery);
        distilleryMap.put("glentauchers_distillery", R.string.glentauchers_distillery);
        distilleryMap.put("glenturret_distillery", R.string.glenturret_distillery);
        distilleryMap.put("highland_park_distillery", R.string.highland_park_distillery);
        distilleryMap.put("inchgower_distillery", R.string.inchgower_distillery);
        distilleryMap.put("isle_of_jura_single_malt", R.string.isle_of_jura_single_malt);
        distilleryMap.put("kilchoman_distillery", R.string.kilchoman_distillery);
        distilleryMap.put("kininvie_distillery", R.string.kininvie_distillery);
        distilleryMap.put("knockando", R.string.knockando);
        distilleryMap.put("knockdhu_distillery", R.string.knockdhu_distillery);
        distilleryMap.put("lagavulin_single_malt", R.string.lagavulin_single_malt);
        distilleryMap.put("laphroaig", R.string.laphroaig);
        distilleryMap.put("linkwood_whisky_distillery", R.string.linkwood_whisky_distillery);
        distilleryMap.put("loch_lomond_distillery", R.string.loch_lomond_distillery);
        distilleryMap.put("royal_lochnagar_distillery", R.string.royal_lochnagar_distillery);
        distilleryMap.put("longmorn_distillery", R.string.longmorn_distillery);
        distilleryMap.put("the_macallan", R.string.the_macallan);
        distilleryMap.put("macduff_distillery", R.string.macduff_distillery);
        distilleryMap.put("mannochmore", R.string.mannochmore);
        distilleryMap.put("miltonduff", R.string.miltonduff);
        distilleryMap.put("mortlach_distillery", R.string.mortlach_distillery);
        distilleryMap.put("oban_distillery", R.string.oban_distillery);
        distilleryMap.put("old_pulteney", R.string.old_pulteney);
        distilleryMap.put("roseisle", R.string.roseisle);
        distilleryMap.put("scapa", R.string.scapa);
        distilleryMap.put("speyburn", R.string.speyburn);
        distilleryMap.put("the_speyside_distillery", R.string.the_speyside_distillery);
        distilleryMap.put("springbank_distillery", R.string.springbank_distillery);
        distilleryMap.put("strathearn", R.string.strathearn);
        distilleryMap.put("strathisla_distillery", R.string.strathisla_distillery);
        distilleryMap.put("strathmill", R.string.strathmill);
        distilleryMap.put("talisker", R.string.talisker);
        distilleryMap.put("tamdhu", R.string.tamdhu);
        distilleryMap.put("tamnavulin_whisky_distillery", R.string.tamnavulin_whisky_distillery);
        distilleryMap.put("teaninich_distillery", R.string.teaninich_distillery);
        distilleryMap.put("tobermory_distillery", R.string.tobermory_distillery);
        distilleryMap.put("tomatin_distillery", R.string.tomatin_distillery);
        distilleryMap.put("tomintoul_distillery", R.string.tomintoul_distillery);
        distilleryMap.put("tormore_single_malt", R.string.tormore_single_malt);
        distilleryMap.put("tullibardine_distillery", R.string.tullibardine_distillery);
        distilleryMap.put("wolfburn", R.string.wolfburn);
        distilleryMap.put("cameronbridge", R.string.cameronbridge);
        distilleryMap.put("north_british_distillery", R.string.north_british_distillery);
        distilleryMap.put("strathclyde_grain_distillery", R.string.strathclyde_grain_distillery);
        distilleryMap.put("invergordon", R.string.invergordon);
        distilleryMap.put("girvan_distillery", R.string.girvan_distillery);
        distilleryMap.put("loch_lomond_distillery", R.string.loch_lomond_distillery);
        distilleryMap.put("glen_turner", R.string.glen_turner);
        distilleryMap.put("auchinblae", R.string.auchinblae);
        distilleryMap.put("ballechin", R.string.ballechin);
        distilleryMap.put("banff_distillery", R.string.banff_distillery);
        distilleryMap.put("ben_wyvis_distillery", R.string.ben_wyvis_distillery);
        distilleryMap.put("clynelish", R.string.clynelish);
        distilleryMap.put("caperdonich_distillery", R.string.caperdonich_distillery);
        distilleryMap.put("coleburn", R.string.coleburn);
        distilleryMap.put("convalmore", R.string.convalmore);
        distilleryMap.put("dallas_dhu_distillery", R.string.dallas_dhu_distillery);
        distilleryMap.put("finnieston_distillery", R.string.finnieston_distillery);
        distilleryMap.put("glen_albyn", R.string.glen_albyn);
        distilleryMap.put("glencraig", R.string.glencraig);
        distilleryMap.put("glenesk", R.string.glenesk);
        distilleryMap.put("glenflagler", R.string.glenflagler);
        distilleryMap.put("glenlochy", R.string.glenlochy);
        distilleryMap.put("glen_mhor", R.string.glen_mhor);
        distilleryMap.put("glenugie_distillery", R.string.glenugie_distillery);
        distilleryMap.put("glenury_whisky_distillery", R.string.glenury_whisky_distillery);
        distilleryMap.put("hazelburn_distillery", R.string.hazelburn_distillery);
        distilleryMap.put("inverleven", R.string.inverleven);
        distilleryMap.put("imperial_distillery", R.string.imperial_distillery);
        distilleryMap.put("killyloch", R.string.killyloch);
        distilleryMap.put("kinclaith", R.string.kinclaith);
        distilleryMap.put("ladyburn_distillery", R.string.ladyburn_distillery);
        distilleryMap.put("littlemill_whisky_distillery", R.string.littlemill_whisky_distillery);
        distilleryMap.put("lochindaal", R.string.lochindaal);
        distilleryMap.put("lochside_distillery", R.string.lochside_distillery);
        distilleryMap.put("millburn_distillery", R.string.millburn_distillery);
        distilleryMap.put("north_port_distillery", R.string.north_port_distillery);
        distilleryMap.put("parkmore_distillery", R.string.parkmore_distillery);
        distilleryMap.put("pittyvaich_distillery", R.string.pittyvaich_distillery);
        distilleryMap.put("port_charlotte_distillery", R.string.port_charlotte_distillery);
        distilleryMap.put("port_ellen_distillery", R.string.port_ellen_distillery);
        distilleryMap.put("rosebank_distillery", R.string.rosebank_distillery);
        distilleryMap.put("st_magdalene_distillery", R.string.st_magdalene_distillery);
        distilleryMap.put("towiemore", R.string.towiemore);
        distilleryMap.put("caledonian", R.string.caledonian);
        distilleryMap.put("cambus_clackmannanshire", R.string.cambus_clackmannanshire);
        distilleryMap.put("carsebridge", R.string.carsebridge);
        distilleryMap.put("dumbarton", R.string.dumbarton);
        distilleryMap.put("port_dundas", R.string.port_dundas);
        distilleryMap.put("zero_results", R.string.zero_results);

        mapMap.put("aberfeldy_whisky_distillery","geo:56.62444,-3.84972?z=16");
        mapMap.put("aberlour_distillery","geo:57.46722,-3.22889?z=16");
        mapMap.put("abhainn_dearg","geo:58.17083,-7.04472?z=16");
        mapMap.put("girvan_distillery","geo:55.2618,-4.8335?z=16");
        mapMap.put("allt_a_bhainne","geo:57.39472,-3.20667?z=16");
        mapMap.put("knockdhu_distillery","geo:57.56333,-2.75917?z=16");
        mapMap.put("annandale_distillery","geo:55.001681,-3.255708?z=16");
        mapMap.put("ardbeg","geo:55.64056,-6.10861?z=16");
        mapMap.put("ardmore_single_malt","geo:57.35111,-2.74500?z=16");
        mapMap.put("arran_single_malt","geo:55.69806,-5.27528?z=16");
        mapMap.put("auchentoshan","geo:55.922,-4.439?z=16");
        mapMap.put("auchroisk","geo:57.54778,-3.11306?z=16");
        mapMap.put("aultmore_distillery","geo:57.5673,-3.0021?z=16");
        mapMap.put("balblair_distillery","geo:57.840472,-4.180417?z=16");
        mapMap.put("balmenach","geo:57.3267083,-3.5339083?z=16");
        mapMap.put("balvenie","geo:57.459194,-3.128583?z=16");
        mapMap.put("ben_nevis_distillery","geo:56.8351444,-5.0738861?z=16");
        mapMap.put("benriach","geo:57.61194,-3.29278?z=16");
        mapMap.put("benrinnes","geo:57.441908,-3.236119?z=16");
        mapMap.put("benromach","geo:57.6141306,-3.6200389?z=16");
        mapMap.put("bladnoch_distillery","geo:54.85833,-4.46194?z=16");
        mapMap.put("blair_athol_distillery","geo:56.698472,-3.720833?z=16");
        mapMap.put("bowmore_single_malt","geo:55.757139,-6.2898444?z=16");
        mapMap.put("royal_brackla_single_malt","geo:57.5396917,-3.9054667?z=16");
        mapMap.put("braeval_distillery","geo:57.271389,-3.259111?z=16");
        mapMap.put("bruichladdich","geo:55.766359,-6.3625?z=16");
        mapMap.put("bunnahabhain_distillery","geo:55.883230,-6.126261?z=16");
        mapMap.put("caol_ila","geo:55.854480,-6.109343?z=16");
        mapMap.put("cardhu","geo:57.470472,-3.350056?z=16");
        mapMap.put("clynelish_distillery","geo:58.024583,-3.868194?z=16");
        mapMap.put("cragganmore","geo:57.41028,-3.39500?z=16");
        mapMap.put("craigellachie_distillery","geo:57.48861,-3.18472?z=16");
        mapMap.put("daftmill_distillery","geo:56.2972500,-3.1039833?z=16");
        mapMap.put("dailuaine","geo:57.453139,-3.272944?z=16");
        mapMap.put("dalmore_single_malt","geo:57.6884111,-4.2394806?z=16");
        mapMap.put("dalwhinnie_single_malt","geo:56.9401278,-4.2380611?z=16");
        mapMap.put("deanston_distillery","geo:56.189278,-4.071417?z=16");
        mapMap.put("dufftown_distillery","geo:57.435748,-3.127820?z=16");
        mapMap.put("edradour","geo:56.7008944,-3.7028139?z=16");
        mapMap.put("fettercairn_whisky_distillery","geo:56.8535,-2.5825?z=16");
        mapMap.put("glenallachie","geo:57.45518,-3.22871?z=16");
        mapMap.put("glenburgie","geo:57.62179,-3.51675?z=16");
        mapMap.put("glencadam_distillery","geo:56.7365083,-2.6528111?z=16");
        mapMap.put("macduff_distillery","geo:57.6578806,-2.5127500?z=16");
        mapMap.put("glendronach_distillery","geo:57.4847,-2.6255?z=16");
        mapMap.put("glendullan_distillery","geo:57.44806,-3.11861?z=16");
        mapMap.put("glen_elgin_distillery","geo:57.5990694,-3.2775611?z=16");
        mapMap.put("glenfarclas_single_malt","geo:57.427000,-3.316361?z=16");
        mapMap.put("glenfiddich","geo:57.453722,-3.128611?z=16");
        mapMap.put("glen_garioch_distillery","geo:57.3385194,-2.3193583?z=16");
        mapMap.put("glenglassaugh_distillery","geo:57.67944,-2.73694?z=16");
        mapMap.put("glengoyne_single_malt","geo:56.01403,-4.36378?z=16");
        mapMap.put("glen_grant_distillery","geo:57.532000,-3.2107972?z=16");
        mapMap.put("glengyle","geo:55.4272083,-5.6109500?z=16");
        mapMap.put("glen_keith","geo:57.54639,-2.95722?z=16");
        mapMap.put("glenkinchie","geo:55.891444,-2.891528?z=16");
        mapMap.put("the_glenlivet","geo:57.343056,-3.338694?z=16");
        mapMap.put("mannochmore","geo:57.598778,-3.319972?z=16");
        mapMap.put("glenmorangie","geo:57.825889,-4.078000?z=16");
        mapMap.put("glen_moray","geo:57.64444,-3.34111?z=16");
        mapMap.put("glen_ord_distillery","geo:57.52222,-4.47556?z=16");
        mapMap.put("glenrothes_distillery","geo:57.526750,-3.216583?z=16");
        mapMap.put("glen_scotia","geo:55.4295139,-5.6042361?z=16");
        mapMap.put("glen_spey_distillery","geo:57.525611,-3.210111?z=16");
        mapMap.put("glentauchers_distillery","geo:0,0?q57.53417,-3.05028?z=16");
        mapMap.put("glenturret_distillery","geo:56.38944,-3.85389?z=16");
        mapMap.put("highland_park_distillery","geo:58.9686028,-2.9554500?z=16");
        mapMap.put("inchgower_distillery","geo:57.6623917,-2.964250?z=16");
        mapMap.put("isle_of_jura_single_malt","geo:55.832889,-5.951056?z=16");
        mapMap.put("kilchoman_distillery","geo:55.78694,-6.43083?z=16");
        mapMap.put("kininvie_distillery","geo:57.466222,-3.130028?z=16");
        mapMap.put("knockando","geo:57.457000,-3.343944?z=16");
        mapMap.put("knockdhu_distillery","geo:57.56333,-2.75917?z=16");
        mapMap.put("lagavulin_single_malt","geo:55.635500,-6.126194?z=16");
        mapMap.put("laphroaig","geo:55.629889,-6.152333?z=16");
        mapMap.put("linkwood_whisky_distillery","geo:57.635448,-3.286238?z=16");
        mapMap.put("royal_lochnagar_distillery","geo:57.03000,-3.20917?z=16");
        mapMap.put("longmorn_distillery","geo:57.6081528,-3.2825083?z=16");
        mapMap.put("the_macallan","geo:57.4843722,-3.2075778?z=16");
        mapMap.put("macduff_distillery","geo:57.6578806,-2.5127500?z=16");
        mapMap.put("mortlach_distillery","geo:57.44278,-3.12278?z=16");
        mapMap.put("oban_distillery","geo:56.4147000,-5.4728000?z=16");
        mapMap.put("old_pulteney","geo:58.43444,-3.08472?z=16");
        mapMap.put("scapa","geo:58.96361,-2.98500?z=16");
        mapMap.put("speyburn","geo:57.53667,-3.21528?z=16");
        mapMap.put("the_speyside_distillery","geo:57.07278,-4.002056?z=16");
        mapMap.put("springbank_distillery","geo:55.425417,-5.608861?z=16");
        mapMap.put("strathisla_distillery","geo:57.54649,-2.95427?z=16");
        mapMap.put("strathmill","geo:57.540417,-2.961222?z=16");
        mapMap.put("talisker","geo:57.30278,-6.35611?z=16");
        mapMap.put("tamdhu","geo:57.459028,-3.353611?z=16");
        mapMap.put("tamnavulin_whisky_distillery","geo:57.31750,-3.30778?z=16");
        mapMap.put("teaninich_distillery","geo:57.691583,-4.260639?z=16");
        mapMap.put("tobermory_distillery","geo:56.62056,-6.07056?z=16");
        mapMap.put("tomatin_distillery","geo:57.33889,-4.00917?z=16");
        mapMap.put("tomintoul_distillery","geo:57.311644,-3.41486?z=16");
        mapMap.put("tormore_single_malt","geo:57.397500,-3.408833?z=16");
        mapMap.put("tullibardine_distillery","geo:56.25778,-3.78556?z=16");
        mapMap.put("wolfburn","geo:58.59528,-3.55139?z=16");
        mapMap.put("cameronbridge","geo:56.189583,-3.056139?z=16");
        mapMap.put("north_british_distillery","geo:55.9401278,-3.2356028?z=16");
        mapMap.put("strathclyde_grain_distillery","geo:55.8488,-4.241?z=16");
        mapMap.put("invergordon","geo:57.68792,-4.15704?z=16");
        mapMap.put("girvan_distillery","geo:55.2618,-4.8335?z=16");
        mapMap.put("loch_lomond_distillery","geo:55.9942944,-4.5772889?z=16");
        mapMap.put("ballechin","geo:56.6622,-3.7397?z=16");
        mapMap.put("banff_distillery","geo:57.66722,-2.55944?z=16");
        mapMap.put("ben_wyvis_distillery","geo:57.693889,-4.156889?z=16");
        mapMap.put("clynelish","geo:58.024583,-3.868194?z=16");
        mapMap.put("caperdonich_distillery","geo:57.53083,-3.20694?z=16");
        mapMap.put("dallas_dhu_distillery","geo:57.5896417,-3.614417?z=16");
        mapMap.put("glenflagler","geo:55.86306,-3.92667?z=16");
        mapMap.put("glenugie_distillery","geo:57.487889,-1.793194?z=16");
        mapMap.put("glenury_whisky_distillery","geo:56.972361,-2.214583?z=16");
        mapMap.put("imperial_distillery","geo:57.455194,-3.30139?z=16");
        mapMap.put("kinclaith","geo:55.84833,-4.24083?z=16");
        mapMap.put("ladyburn_distillery","geo:55.260139,-4.831250?z=16");
        mapMap.put("littlemill_whisky_distillery","geo:55.931167,-4.496306?z=16");
        mapMap.put("lochside_distillery","geo:56.721944,-2.467028?z=16");
        mapMap.put("millburn_distillery","geo:57.482417,-4.205778?z=16");
        mapMap.put("north_port_distillery","geo:56.73556,-2.66028?z=16");
        mapMap.put("parkmore_distillery","geo:57.45472,-3.11917?z=16");
        mapMap.put("pittyvaich_distillery","geo:57.43639,-3.13111?z=16");
        mapMap.put("port_charlotte_distillery","geo:55.73972,-6.37833?z=16");
        mapMap.put("port_ellen_distillery","geo:55.6334000,-6.1969000?z=16");
        mapMap.put("rosebank_distillery","geo:56.002417,-3.803611?z=16");
        mapMap.put("st_magdalene_distillery","geo:55.97639,-3.59139?z=16");
        mapMap.put("cambus_clackmannanshire","geo:56.123685,-3.844224?z=16");
        mapMap.put("dumbarton","geo:55.95,-4.566667?z=16");
        mapMap.put("port_dundas","geo:55.8732972,-4.2530472?z=16");
        mapMap.put("auchinblae","geo:56.8969444444,-2.44972222222?z=16");
        mapMap.put("caledonian","geo:56.9469444444,-3.58305555556?z=16");
        mapMap.put("carsebridge","geo:56.113967,-3.792253?z=16");
        mapMap.put("coleburn","geo:57.583888,-3.272222?z=16");
        mapMap.put("finnieston_distillery","geo:55.856961,-4.272493?z=16");
        mapMap.put("gartbreck_distillery","geo:55.740629,-6.331647?z=16");
        mapMap.put("glen_albyn","geo:57.5122222222,-4.45555555556?z=16");
        mapMap.put("glencraig","geo:57.6219444444,-3.5175?z=16");
        mapMap.put("glen_deveron_distillery","geo:57.6578806,-2.5127500?z=16");
        mapMap.put("glenesk","geo:56.7438888889,-2.46583333333?z=16");
        mapMap.put("glenlochy","geo:56.822678,-5.106952?z=16");
        mapMap.put("glen_mhor","geo:57.4813888889,-4.24305555556?z=16");
        mapMap.put("glen_turner","geo:55.890331,-3.580001?z=16");
        mapMap.put("hazelburn_distillery","geo:55.4255555556,-5.60861111111?z=16");
        mapMap.put("inverleven","geo:55.9422222222,-4.56722222222?z=16");
        mapMap.put("killyloch","geo:55.8613888889,-3.92527777778?z=16");
        mapMap.put("lochindaal","geo:55.738479,-6.378563?z=16");
        mapMap.put("miltonduff","geo:57.623611111,-3.36861111111?z=16");
        mapMap.put("roseisle","geo:57.64981,-3.318582?z=16");
        mapMap.put("strathearn","geo:56.395973,-3.620728?z=16");
        mapMap.put("towiemore","geo:57.6236111111,-3.36861111111?z=16");
        setContentView(R.layout.activity_scottishwhiskydistilleries);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        //final String[] owners = {"Adelphi Whisky", "Angus Dundee Distiller", "Annandale Distillery Company Limited", "Bacardi", "Beam Suntory", "BenRiach Distillery Company", "Berry Brothers & Rudd", "Burn Stewart Distillers", "CL Financial", "Campari", "Diageo", "Diageo/The Edrington Group", "Edrington", "Emperador Inc", "Emperador Inc.", "Gartbreck Distilling Company", "Gordon & MacPhail", "Highland Distillers", "Ian MacLeod Distillers", "Ian Macleod Distillers", "Independent", "Inver House Distillers", "Isle of Arran Distillers Ltd", "J. & G. Grant", "LVMH", "La Martiniquaise", "Loch Lomond Distillers", "Loch Lomond Distillery Company", "Loch Lomond Group", "Mitchells Glengyle Ltd", "Morrison Bowmore", "Morrison Bowmore Distillers", "Nikka Whisky Distilling", "Pernod Ricard", "Picard Vins & Spiritueux", "Raymond and Colin Armstrong", "Rémy Cointreau", "Scottish Grain Distillers", "Signatory Vintage Scotch Whisky Company", "Speyside Distillery Co. Ltd.", "Takara Shuzo Corp.", "ThaiBev", "United Breweries Group", "Whyte & Mackay", "William Grant & Sons"};
        //owners = getResources().getStringArray(R.array.owners);
//        s1 = (Spinner) findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, owners);
//        s1.setAdapter(adapter);
//        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                int index = arg0.getSelectedItemPosition();
//                String ownerParam = owners[index];
//                if (ownerParam.equals("Adelphi Whisky")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("ardnamurchan_distillery");
//                } else if (ownerParam.equals("Angus Dundee Distiller")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glencadam_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("tomintoul_distillery");
//                } else if (ownerParam.equals("Annandale Distillery Company Limited")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("annandale_distillery");
//                } else if (ownerParam.equals("Bacardi")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("aberfeldy_whisky_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("aultmore_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("benrinnes");
//                    Scottishwhiskydistilleries.distillerySearchList.add("royal_brackla_single_malt");
//                    Scottishwhiskydistilleries.distillerySearchList.add("craigellachie_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_deveron_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("macduff_distillery");
//                } else if (ownerParam.equals("Beam Suntory")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("ardmore_single_malt");
//                    Scottishwhiskydistilleries.distillerySearchList.add("bowmore_single_malt");
//                    Scottishwhiskydistilleries.distillerySearchList.add("laphroaig");
//                } else if (ownerParam.equals("BenRiach Distillery Company")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("benriach");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glendronach_distillery");
//                } else if (ownerParam.equals("Berry Brothers & Rudd")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenrothes_distillery");
//                } else if (ownerParam.equals("Burn Stewart Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("tobermory_distillery");
//                } else if (ownerParam.equals("CL Financial")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("bunnahabhain_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("deanston_distillery");
//                } else if (ownerParam.equals("Campari")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_grant_distillery");
//                } else if (ownerParam.equals("Diageo")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("auchroisk");
//                    Scottishwhiskydistilleries.distillerySearchList.add("blair_athol_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("caol_ila");
//                    Scottishwhiskydistilleries.distillerySearchList.add("cardhu");
//                    Scottishwhiskydistilleries.distillerySearchList.add("clynelish_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("cragganmore");
//                    Scottishwhiskydistilleries.distillerySearchList.add("dailuaine");
//                    Scottishwhiskydistilleries.distillerySearchList.add("dalwhinnie_single_malt");
//                    Scottishwhiskydistilleries.distillerySearchList.add("dufftown_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glendullan_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_elgin_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenkinchie");
//                    Scottishwhiskydistilleries.distillerySearchList.add("mannochmore");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_ord_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_spey_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("inchgower_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("knockando");
//                    Scottishwhiskydistilleries.distillerySearchList.add("lagavulin_single_malt");
//                    Scottishwhiskydistilleries.distillerySearchList.add("linkwood_whisky_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("royal_lochnagar_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("mannochmore");
//                    Scottishwhiskydistilleries.distillerySearchList.add("mortlach_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("oban_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("roseisle");
//                    Scottishwhiskydistilleries.distillerySearchList.add("strathmill");
//                    Scottishwhiskydistilleries.distillerySearchList.add("talisker");
//                    Scottishwhiskydistilleries.distillerySearchList.add("teaninich_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("cameronbridge");
//                    Scottishwhiskydistilleries.distillerySearchList.add("caledonian");
//                    Scottishwhiskydistilleries.distillerySearchList.add("cambus_clackmannanshire");
//                    Scottishwhiskydistilleries.distillerySearchList.add("port_dundas");
//                } else if (ownerParam.equals("Diageo/The Edrington Group")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("north_british_distillery");
//                } else if (ownerParam.equals("Edrington")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("highland_park_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("the_macallan");
//                } else if (ownerParam.equals("Emperador Inc")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("dalmore_single_malt");
//                    Scottishwhiskydistilleries.distillerySearchList.add("fettercairn_whisky_distillery");
//                } else if (ownerParam.equals("Emperador Inc.")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("invergordon");
//                } else if (ownerParam.equals("Gartbreck Distilling Company")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("gartbreck_distillery");
//                } else if (ownerParam.equals("Gordon & MacPhail")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("benromach");
//                } else if (ownerParam.equals("Highland Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenturret_distillery");
//                } else if (ownerParam.equals("Ian MacLeod Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("tamdhu");
//                } else if (ownerParam.equals("Ian Macleod Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glengoyne_single_malt");
//                } else if (ownerParam.equals("Independent")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("abhainn_dearg");
//                    Scottishwhiskydistilleries.distillerySearchList.add("daftmill_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenglassaugh_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("kilchoman_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("springbank_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("strathearn");
//                    Scottishwhiskydistilleries.distillerySearchList.add("wolfburn");
//                } else if (ownerParam.equals("Inver House Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("ancnoc");
//                } else if (ownerParam.equals("Isle of Arran Distillers Ltd")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("arran_single_malt");
//                } else if (ownerParam.equals("J. & G. Grant")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenfarclas_single_malt");
//                } else if (ownerParam.equals("LVMH")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("ardbeg");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenmorangie");
//                } else if (ownerParam.equals("La Martiniquaise")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_moray");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_turner");
//                } else if (ownerParam.equals("Loch Lomond Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("loch_lomond_distillery");
//                } else if (ownerParam.equals("Loch Lomond Distillery Company")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("loch_lomond_distillery");
//                } else if (ownerParam.equals("Loch Lomond Group")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_scotia");
//                } else if (ownerParam.equals("Mitchells Glengyle Ltd")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glengyle");
//                } else if (ownerParam.equals("Morrison Bowmore")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("auchentoshan");
//                } else if (ownerParam.equals("Morrison Bowmore Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_garioch_distillery");
//                } else if (ownerParam.equals("Nikka Whisky Distilling")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("ben_nevis_distillery");
//                } else if (ownerParam.equals("Pernod Ricard")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("aberlour_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("allt_a_bhainne");
//                    Scottishwhiskydistilleries.distillerySearchList.add("braeval_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenallachie");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenburgie");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glen_keith");
//                    Scottishwhiskydistilleries.distillerySearchList.add("the_glenlivet");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glentauchers_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("longmorn_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("miltonduff");
//                    Scottishwhiskydistilleries.distillerySearchList.add("scapa");
//                    Scottishwhiskydistilleries.distillerySearchList.add("strathisla_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("tormore_single_malt");
//                    Scottishwhiskydistilleries.distillerySearchList.add("strathclyde_grain_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("dumbarton");
//                } else if (ownerParam.equals("Picard Vins & Spiritueux")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("tullibardine_distillery");
//                } else if (ownerParam.equals("Raymond and Colin Armstrong")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("bladnoch_distillery");
//                } else if (ownerParam.equals("Rémy Cointreau")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("bruichladdich");
//                } else if (ownerParam.equals("Scottish Grain Distillers")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("carsebridge");
//                } else if (ownerParam.equals("Signatory Vintage Scotch Whisky Company")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("edradour");
//                } else if (ownerParam.equals("Speyside Distillery Co. Ltd.")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("the_speyside_distillery");
//                } else if (ownerParam.equals("Takara Shuzo Corp.")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("tomatin_distillery");
//                } else if (ownerParam.equals("ThaiBev")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("balblair_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("balmenach");
//                    Scottishwhiskydistilleries.distillerySearchList.add("knockdhu_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("old_pulteney");
//                    Scottishwhiskydistilleries.distillerySearchList.add("speyburn");
//                } else if (ownerParam.equals("United Breweries Group")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("isle_of_jura_single_malt");
//                } else if (ownerParam.equals("Whyte & Mackay")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("tamnavulin_whisky_distillery");
//                } else if (ownerParam.equals("William Grant & Sons")) {
//                    Scottishwhiskydistilleries.distillerySearchList.add("ailsa_bay");
//                    Scottishwhiskydistilleries.distillerySearchList.add("balvenie");
//                    Scottishwhiskydistilleries.distillerySearchList.add("glenfiddich");
//                    Scottishwhiskydistilleries.distillerySearchList.add("kininvie_distillery");
//                    Scottishwhiskydistilleries.distillerySearchList.add("girvan_distillery");
//                } else {
//                    Scottishwhiskydistilleries.distillerySearchList.add("zero_results");
//                }
//                Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
//                startActivityForResult(iDistillery, 0);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//            }
//        });

    }




    public void CopyDB(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        // copy 1024 bytes of file at a time
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
    public void onClickMap(View view) {
        //WORKS, opens web browser:
        // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/?q=57.351,-2.745"));
        //startActivity(browserIntent);
        Uri geo;
        //NOT WORKING NOT FOUND IN GOOGLE MAPS APP
        // geo = Uri.parse("geo:57.351,-2.745(Distillery)");
        String location = mapMap.get(Scottishwhiskydistilleries.distilleryChoice);
        if(location !=null) {
            Toast.makeText(this, "Loading  map for "+Scottishwhiskydistilleries.distilleryChoice, Toast.LENGTH_LONG).show();
            geo = Uri.parse(location);
        } else {
            Toast.makeText(this, "Exact location not found for "+Scottishwhiskydistilleries.distilleryChoice, Toast.LENGTH_LONG).show();
            geo = Uri.parse("geo:57.351,-2.745?z=8");
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geo);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Log.w(TAG, "In Scottishwhiskydistilleries.onClickMap(), about to start intent, not browserIntent");
            startActivity(intent);
        } else {
            Log.w(TAG, "In Scottishwhiskydistilleries.onClickMap(), about to start browserIntent, not intent");
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/?q=57.351,-2.745"));
            startActivity(browserIntent);
        }
    }
    public void onClickOwner(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "owner";
        Intent iOwner = new Intent("com.jimsuplee.scottishwhiskydistilleries.Owner");
        startActivityForResult(iOwner,1);
    }

    public void onClickAll(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "all";
        Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
        startActivityForResult(iDistillery,0);
    }
    public void onClickMalt(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "malt";
        Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
        startActivityForResult(iDistillery,0);
    }
    public void onClickOpen(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "open";
        Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
        startActivityForResult(iDistillery,0);
    }

    public void onClickRegion(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "region";
        Intent iRegion = new Intent("com.jimsuplee.scottishwhiskydistilleries.Region");
        startActivityForResult(iRegion,2);
    }
    public void onClickClosed(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "closed";
        Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
        startActivityForResult(iDistillery, 0);
    }
    public void onClickGrain(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "grain";
        Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
        startActivityForResult(iDistillery, 0);
    }
    public void onClickLocation(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        Scottishwhiskydistilleries.ownerregionlocationclosedgrain = "location";
        Intent iLocation = new Intent("com.jimsuplee.scottishwhiskydistilleries.Location");
        startActivityForResult(iLocation,3);
    }
    public void onClickSearch(View view) {
        Scottishwhiskydistilleries.distillerySearchList.clear();
        EditText txt_distillerysearch = (EditText) findViewById(R.id.txt_distillerysearch);
        String distillerydataParam = txt_distillerysearch.getText().toString();
        distillerydataParam ="%"+distillerydataParam+"%";
        db.open();
        Cursor c;
        c = db.getByDistillerydata(distillerydataParam);
        if (c != null) {
            if (c.moveToFirst()) {
                Log.w(TAG, "In Scottishwhiskydistilleries.onClickSearch(), c.moveToFirst() returned TRUE");
                Log.w(TAG, "In Scottishwhiskydistilleries.onClickSearch(), about to loop through c");
                do {
                    Scottishwhiskydistilleries.distillerySearchList.add(c.getString(0));
                } while (c.moveToNext());
            } else {
                Log.w(TAG, "In Scottishwhiskydistilleries.onClickSearch(), c.moveToFirst() returned NOT TRUE");
            }

        }
        db.close();
        Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
        startActivityForResult(iDistillery, 0);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // ---check if the request code is 0 1 2 3 4 5---
        Log.w(TAG, "In Scottishdistilleries.onActivityResult(), checking reqCod");
        if (requestCode == 0) {
            Log.w(TAG, "In Scottishdistilleries.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
            if (resultCode == RESULT_OK) {
                String distillery = data.getData().toString();
                TextView tvname = (TextView) findViewById(R.id.txt_Distilleryname);
                Toast.makeText(this, "Loading "+distillery, Toast.LENGTH_LONG).show();
                tvname.setText(distillery);
                TextView tv = (TextView) findViewById(R.id.txt_Distillerysdata);
                Integer distilleryTextId = distilleryMap.get(distillery);
                if(distilleryTextId != null) {
                    tv.setText(distilleryTextId);
                } else {
                    tv.setText(R.string.zero_results);
                }
                ImageView iv = (ImageView) findViewById(R.id.imagedetail);
                Integer photoId = photoMap.get(distillery);
                if(photoId != null) {
                    iv.setImageResource(photoMap.get(distillery));
                } else {
                    iv.setImageResource(R.drawable.zero_results);
                }
            }
        } else if (requestCode == 1) {
            Log.w(TAG, "In Scottishwhiskydistilleries.onAcvityResult(int-reqCode=1,int-resCode,Intent-data)");
            if (resultCode == RESULT_OK) {
                String owner = data.getData().toString();
                Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
                iDistillery.putExtra("owner", owner);
                startActivityForResult(iDistillery,0);
            }
        } else if (requestCode == 2) {
            Log.w(TAG, "In Scottishwhiskydistilleries.onAcvityResult(int-reqCode=2,int-resCode,Intent-data)");
            if (resultCode == RESULT_OK) {
                String region = data.getData().toString();
                Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
                iDistillery.putExtra("region", region);
                startActivityForResult(iDistillery,0);
            }
        } else if (requestCode == 3) {
            Log.w(TAG, "In Scottishwhiskydistilleries.onAcvityResult(int-reqCode=3,int-resCode,Intent-data)");
            if (resultCode == RESULT_OK) {
                String location = data.getData().toString();
                Intent iDistillery = new Intent("com.jimsuplee.scottishwhiskydistilleries.Distillery");
                iDistillery.putExtra("location", location);
                startActivityForResult(iDistillery,0);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scottishwhiskydistilleries, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_scottishwhiskydistilleries, container, false);
            return rootView;
        }
    }
}
