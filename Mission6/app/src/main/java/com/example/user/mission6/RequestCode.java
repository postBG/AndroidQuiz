package com.example.user.mission6;


import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

enum RequestCode {
    MENU_ACTIVITY(100, MenuActivity.class),
    MANAGE_CUSTOMER(101, ManageCustomerActivity.class),
    MANAGE_INCOME(102, ManageIncomeActivity.class),
    MANAGE_ITEM(103, ManageItemActivity.class);

    private final int code;
    private final Class<? extends AppCompatActivity> activityClass;

    private static final Map<Class<? extends AppCompatActivity>, Integer> classToCode = new HashMap<>();

    static {
        for (RequestCode requestCode : values()) {
            classToCode.put(requestCode.activityClass, requestCode.code);
        }
    }

    RequestCode(int requestCode, Class<? extends AppCompatActivity> activityClass) {
        this.code = requestCode;
        this.activityClass = activityClass;
    }

    public static int getCodeFromClass(Class<? extends AppCompatActivity> activityClass) {
        return classToCode.get(activityClass);
    }
}
