package com.example.user.mission7;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("YYYY년 MM월 dd일");

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            DateTime selectedDateTime = new DateTime(year, monthOfYear, dayOfMonth, 0, 0, 0, 0);
            birthButton.setText(dateTimeToFormatString(selectedDateTime));
        }
    };

    private EditText ageInput;
    private EditText nameInput;
    private Button birthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.name_input);
        ageInput = (EditText) findViewById(R.id.age_input);
        birthButton = (Button) findViewById(R.id.birth_button);

        birthButton.setText(dateTimeToFormatString(DateTime.now()));
    }

    public void onClickSaveButton(View view) {
        Toast.makeText(getApplicationContext(), createMessage(), Toast.LENGTH_LONG).show();
    }

    public void onClickBirthButton(View view) {
        DateTime today = DateTime.now();

        DatePickerDialog dialog = new DatePickerDialog(this, listener,
                today.getYear(), today.getMonthOfYear(), today.getDayOfMonth());
        dialog.show();
    }

    private String dateTimeToFormatString(DateTime dateTime) {
        return dateTime.toString(DATE_TIME_FORMATTER);
    }

    private String createMessage() {
        String name = nameInput.getText().toString();
        String age = ageInput.getText().toString();
        String birth = birthButton.getText().toString();

        return String.format("이름: %s\n나이: %s\n생년월일: %s", name, age, birth);
    }
}
