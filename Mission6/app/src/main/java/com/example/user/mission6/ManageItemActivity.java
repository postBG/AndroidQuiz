package com.example.user.mission6;

import android.os.Bundle;

public class ManageItemActivity extends AbstractManageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_item);
    }

    @Override
    protected String getStatement() {
        return "상품 관리 화면";
    }
}
