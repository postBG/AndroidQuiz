package com.example.user.mission5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickMenu(View view) {
        Intent intent = new Intent();
        intent.putExtra("selectedMenu", ((Button)view).getText());

        setResult(RESULT_OK, intent);
        finish();
    }
}
