package com.test.themechange;

import android.app.Activity;

/**
 * Created by abc on 2016/9/12.
 */
public class ThemeChageUtil {
    public static boolean isChange = false;

    public static void changeTheme(Activity activity) {
        if(isChange){
            activity.setTheme(R.style.NightTheme);
        }
    }
}
