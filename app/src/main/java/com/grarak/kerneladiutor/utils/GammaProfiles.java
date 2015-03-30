package com.grarak.kerneladiutor.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by willi on 30.03.15.
 */
public class GammaProfiles {

    private JSONObject JSON;
    private KGammaProfiles kgammaProfiles;
    private GammaControlProfiles gammaControlProfiles;
    private DsiPanelProfiles dsiPanelProfiles;

    public GammaProfiles(Context context) {
        try {
            String json = Utils.readAssetFile(context, "gamma_profiles.json");
            JSON = new JSONObject(json);
        } catch (JSONException e) {
            Log.e(Constants.TAG, "Failed to read gamma profiles");
        }
    }

    public KGammaProfiles getKGamma() {
        try {
            if (kgammaProfiles == null && JSON != null)
                kgammaProfiles = new KGammaProfiles(JSON.getJSONArray("k_gamma"));
            return kgammaProfiles;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public GammaControlProfiles getGammaControl() {
        try {
            if (gammaControlProfiles == null && JSON != null)
                gammaControlProfiles = new GammaControlProfiles(JSON.getJSONArray("gammacontrol"));
            return gammaControlProfiles;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DsiPanelProfiles getDsiPanelProfiles() {
        try {
            if (dsiPanelProfiles == null && JSON != null)
                dsiPanelProfiles = new DsiPanelProfiles(JSON.getJSONArray("dsi_panel"));
            return dsiPanelProfiles;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class KGammaProfiles {

        private final JSONArray JSON;

        public KGammaProfiles(JSONArray kgammaArray) {
            JSON = kgammaArray;
        }

        public String getGammaRed(int position) {
            return getString("gamma_r", position);
        }

        public String getGammaGreen(int position) {
            return getString("gamma_g", position);
        }

        public String getGammaBlue(int position) {
            return getString("gamma_b", position);
        }

        public String getKCAL(int position) {
            return getString("kcal", position);
        }

        public String getName(int position) {
            return getString("name", position);
        }

        private String getString(String name, int position) {
            try {
                return JSON.getJSONObject(position).getString(name);
            } catch (JSONException e) {
                return null;
            }
        }

        public int length() {
            return JSON.length();
        }

    }

    public static class GammaControlProfiles {

        private final JSONArray JSON;

        public GammaControlProfiles(JSONArray gammacontrolArray) {
            JSON = gammacontrolArray;
        }

        public String getSaturation(int position) {
            return getString("saturation", position);
        }

        public String getBrightness(int position) {
            return getString("brightness", position);
        }

        public String getContrast(int position) {
            return getString("contrast", position);
        }

        public String getBlueWhites(int position) {
            return getString("blue_whites", position);
        }

        public String getBlueBlacks(int position) {
            return getString("blue_blacks", position);
        }

        public String getBlueMids(int position) {
            return getString("blue_mids", position);
        }

        public String getBlueGreys(int position) {
            return getString("blue_greys", position);
        }

        public String getGreenWhites(int position) {
            return getString("green_whites", position);
        }

        public String getGreenBlacks(int position) {
            return getString("green_blacks", position);
        }

        public String getGreenMids(int position) {
            return getString("green_mids", position);
        }

        public String getGreenGreys(int position) {
            return getString("green_greys", position);
        }

        public String getRedWhites(int position) {
            return getString("red_whites", position);
        }

        public String getRedBlacks(int position) {
            return getString("red_blacks", position);
        }

        public String getRedMids(int position) {
            return getString("red_mids", position);
        }

        public String getRedGreys(int position) {
            return getString("red_greys", position);
        }

        public String getKCAL(int position) {
            return getString("kcal", position);
        }

        public String getName(int position) {
            return getString("name", position);
        }

        private String getString(String name, int position) {
            try {
                return JSON.getJSONObject(position).getString(name);
            } catch (JSONException e) {
                return null;
            }
        }

        public int length() {
            return JSON.length();
        }

    }

    public static class DsiPanelProfiles {

        private final JSONArray JSON;

        public DsiPanelProfiles(JSONArray dsiPanelArray) {
            JSON = dsiPanelArray;
        }

        public String getWhitePoint(int position) {
            return getString("white_point", position);
        }

        public String getBlueNegative(int position) {
            return getString("blue_negative", position);
        }

        public String getBluePositive(int position) {
            return getString("blue_positive", position);
        }

        public String getGreenNegative(int position) {
            return getString("green_negative", position);
        }

        public String getGreenPositive(int position) {
            return getString("green_positive", position);
        }

        public String getRedNegative(int position) {
            return getString("red_negative", position);
        }

        public String getRedPositive(int position) {
            return getString("red_positive", position);
        }

        public String getName(int position) {
            return getString("name", position);
        }

        private String getString(String name, int position) {
            try {
                return JSON.getJSONObject(position).getString(name);
            } catch (JSONException e) {
                return null;
            }
        }

        public int length() {
            return JSON.length();
        }

    }

}
