package com.fongmi.bear.utils;

import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.fongmi.bear.App;

public class Prefers {

    private static SharedPreferences getPrefers() {
        return PreferenceManager.getDefaultSharedPreferences(App.get());
    }

    public static String getString(String key, String defaultValue) {
        return getPrefers().getString(key, defaultValue);
    }

    public static String getString(String key) {
        return getString(key, "");
    }

    public static int getInt(String key, int defaultValue) {
        return getPrefers().getInt(key, defaultValue);
    }

    public static int getInt(String key) {
        return getInt(key, 0);
    }

    public static void put(String key, Object obj) {
        if (obj == null) return;
        if (obj instanceof String) {
            getPrefers().edit().putString(key, (String) obj).apply();
        } else if (obj instanceof Boolean) {
            getPrefers().edit().putBoolean(key, (Boolean) obj).apply();
        } else if (obj instanceof Float) {
            getPrefers().edit().putFloat(key, (Float) obj).apply();
        } else if (obj instanceof Integer) {
            getPrefers().edit().putInt(key, (Integer) obj).apply();
        } else if (obj instanceof Long) {
            getPrefers().edit().putLong(key, (Long) obj).apply();
        }
    }

    public static String getUrl() {
        return Prefers.getString("url");
    }

    public static void putUrl(String url) {
        Prefers.put("url", url);
    }

    public static String getHome() {
        return Prefers.getString("home");
    }

    public static void putHome(String home) {
        Prefers.put("home", home);
    }

    public static int getScale() {
        return Prefers.getInt("scale");
    }

    public static void putScale(int scale) {
        Prefers.put("scale", scale);
    }

    public static int getThumbnail() {
        return Prefers.getInt("thumbnail", 1);
    }

    public static void putThumbnail(int thumbnail) {
        Prefers.put("thumbnail", thumbnail);
    }
}
