package com.example.user.mission6;

import android.os.Bundle;

public class ManageCustomerActivity extends AbstractManageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_customer);
    }

    @Override
    protected String getStatement() {
        return "고객 관리 화면";
    }
}
