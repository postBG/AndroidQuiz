package com.example.user.mission6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText idEditText;
    private AppCompatEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = (AppCompatEditText) findViewById(R.id.id_edit_text);
        passwordEditText = (AppCompatEditText) findViewById(R.id.password_edit_text);
    }

    public void onClickLogin(View view) {
        if (!isInputsAllValid()) {
            Toast.makeText(getApplicationContext(), "아이디/비밀번호를 입력해주세요", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("id", idEditText.getText().toString());
        intent.putExtra("password", passwordEditText.getText().toString());

        startActivityForResult(intent, RequestCode.getCodeFromClass(MenuActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), data.getExtras().getString("statement"), Toast.LENGTH_LONG).show();
        }
    }

    private boolean isInputsAllValid() {
        String inputId = idEditText.getText().toString();
        String inputPassword = passwordEditText.getText().toString();

        return !inputId.isEmpty() && !inputPassword.isEmpty();
    }
}
