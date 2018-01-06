package com.example.user.mission4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_CHAR = 80;

    private TextView currentChar;
    private TextView maxChar;
    private AppCompatEditText editText;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxChar = (TextView) this.findViewById(R.id.max_char);
        maxChar.setText(String.valueOf(MAX_CHAR));

        currentChar = (TextView) this.findViewById(R.id.current_char);
        editText = (AppCompatEditText) this.findViewById(R.id.editText);
        editText.setFilters(new InputFilter[]{
                new InputFilter.LengthFilter(MAX_CHAR)
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentChar.setText(String.valueOf(editText.getText().toString().length()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        submit = (Button) this.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
