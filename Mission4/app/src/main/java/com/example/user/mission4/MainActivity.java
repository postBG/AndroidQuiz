package com.example.user.mission4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_CHAR = 80;

    private TextView currentChar;
    private TextView maxChar;
    private AppCompatEditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxChar = (TextView) this.findViewById(R.id.max_char);
        currentChar = (TextView) this.findViewById(R.id.current_char);
        editText = (AppCompatEditText) this.findViewById(R.id.editText);

        maxChar.setText(String.valueOf(MAX_CHAR));
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
    }
}
