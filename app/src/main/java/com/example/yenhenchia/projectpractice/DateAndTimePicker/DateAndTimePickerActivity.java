package com.example.yenhenchia.projectpractice.DateAndTimePicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import com.example.yenhenchia.projectpractice.R;

public class DateAndTimePickerActivity extends AppCompatActivity {

    private Button btnDatePicker, btnTimePicker;
    private TextView txtPickerResult;
    private DatePicker datePicker;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_picker);

        this.txtPickerResult = (TextView)findViewById(R.id.txtPickerResult);

        this.btnDatePicker = (Button)findViewById(R.id.btnDatePicker);
        this.btnDatePicker.setOnClickListener(dateOnClickListener);

        this.btnTimePicker = (Button)findViewById(R.id.btnTimePicker);
        this.btnTimePicker.setOnClickListener(timeOnClickListener);

        this.datePicker = (DatePicker)findViewById(R.id.datePicker);

        this.timePicker = (TimePicker)findViewById(R.id.timePicker);
//        this.timePicker.setOnTimeChangedListener();
    }



    private DatePicker.OnDateChangedListener datePickerOnClickListener = new DatePicker.OnDateChangedListener() {

        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            Log.d("datePickerOkListener", "datePickerOnListener");
        }
    };

    private Button.OnClickListener dateOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Calendar now = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    DateAndTimePickerActivity.this,
                    onDateSetListener,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH));

            datePickerDialog.setTitle("選擇日期");
            datePickerDialog.setMessage("請選擇日期");
            datePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
            datePickerDialog.setCancelable(false);

            datePickerDialog.show();
        }
    };

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            String str = getString(R.string.timePicker);

            txtPickerResult.setText(str + String.valueOf(year) + ":" + String.valueOf(month + 1) + ":" + String.valueOf(dayOfMonth));
        }
    };

    private Button.OnClickListener timeOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Calendar now = Calendar.getInstance();

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    DateAndTimePickerActivity.this,
                    onTimeSetListener,
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    true);

            timePickerDialog.setTitle("選擇時間");
            timePickerDialog.setMessage("請選擇時間");
            timePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
            timePickerDialog.setCancelable(false);

            timePickerDialog.show();
        }
    };

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            String str = getString(R.string.timePicker);

            txtPickerResult.setText(str + String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
        }
    };
}
