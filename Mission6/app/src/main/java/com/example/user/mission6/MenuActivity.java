package com.example.user.mission6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickManageCustomer(View view) {
        startActivityForResult(createIntent(ManageCustomerActivity.class), RequestCode.getCodeFromClass(ManageCustomerActivity.class));
    }

    public void onClickManageIncome(View view) {
        startActivityForResult(createIntent(ManageIncomeActivity.class), RequestCode.getCodeFromClass(ManageIncomeActivity.class));
    }

    public void onClickManageItem(View view) {
        startActivityForResult(createIntent(ManageItemActivity.class), RequestCode.getCodeFromClass(ManageItemActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Toast.makeText(getApplicationContext(), data.getExtras().getString("statement"), Toast.LENGTH_LONG).show();
        }
    }

    private Intent createIntent(Class<? extends AppCompatActivity> activityClass) {
        Intent intent = new Intent(getApplicationContext(), activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        return intent;
    }

}
