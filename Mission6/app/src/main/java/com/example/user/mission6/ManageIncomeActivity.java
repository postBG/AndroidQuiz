package com.example.user.mission6;

import android.os.Bundle;

public class ManageIncomeActivity extends AbstractManageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_income);
    }

    @Override
    protected String getStatement() {
        return "매출 관리 화면";
    }
}
