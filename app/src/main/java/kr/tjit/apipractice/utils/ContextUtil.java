package kr.tjit.apipractice.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ContextUtil {

//    메모가 저장될 파일의 이름
    private static final String prefName = "PracticePref";

//    저장하고 싶은 메모의 항목명들
    private static final String TOKEN = "TOKEN";

//    저장할 항목들을 저장 / 불러오는 기능 (setter / getter)
    public static void setToken(Context context, String serverToken) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putString(TOKEN, serverToken).apply();

    }
    public static String getToken(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        return pref.getString(TOKEN, "");
    }

}
