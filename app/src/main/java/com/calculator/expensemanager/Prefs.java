package com.calculator.expensemanager;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public Prefs(Context context) {
        sharedPreferences = context.getSharedPreferences("ExpenseManager",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


//    public void setInt(String key, int value) {
//        editor.putInt(key, value);
//        editor.apply();
//
//    }
//
//
//
//
//
//    public void setString(String key, String value) {
//        editor.putString(key, value);
//        editor.apply();
//    }
//
//
//
//
//    public void setPremium(int value){
//        editor.putInt("Premium", value);
//        editor.apply();
//    }
//
//    public void setBoolean(String key, Boolean value){
//
//        editor.putBoolean(key, value);
//        editor.apply();
//
//    }
//
//
//    public boolean getBoolean(String key, boolean def){
//        return sharedPreferences.getBoolean(key, def);
//    }
//
//
//    public int getInt(String key, int def){
//        return sharedPreferences.getInt(key, def);
//    }
//
//
//    public String getString(String key, String def){
//        return sharedPreferences.getString(key,def);
//    }
//
//    public int getPremium(){
//        return sharedPreferences.getInt("Premium", 0);
//    }


    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean("isLogin", false);
    }

    public void setIsLogin(boolean value){
        editor.putBoolean("isLogin", value);
        editor.apply();
    }




}
