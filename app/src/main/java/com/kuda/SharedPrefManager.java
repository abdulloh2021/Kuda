package com.kuda;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    public static final String SP_KUDA_APP = "spKudaApp";
    public static final String SP_Nama = "spNama";
    public static final String SP_Email = "spNama";
    public static final String SP_Token = "spToken";
    public static final String SP_LoggedIn = "spLoggedIn";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context) {
        sp = context.getSharedPreferences(SP_KUDA_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value) {
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPToken(String keySP, String value) {
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value) {
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_Nama, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_Email, "");
    }

    public String getSP_Token(String SP_Token){
        return sp.getString(SharedPrefManager.SP_Token, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_LoggedIn, false);
    }

}
