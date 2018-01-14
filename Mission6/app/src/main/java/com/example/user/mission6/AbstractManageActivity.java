package com.example.user.mission6;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class AbstractManageActivity extends AppCompatActivity {

    public void onClickToMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("statement", getStatement());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickToLogin(View view) {
        Intent intent = new Intent(getApplication(), MainActivity.class);
        intent.putExtra("statement", getStatement());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        setResult(RESULT_OK, intent);
        startActivity(intent);
        finish();
    }

    protected abstract String getStatement();

}
