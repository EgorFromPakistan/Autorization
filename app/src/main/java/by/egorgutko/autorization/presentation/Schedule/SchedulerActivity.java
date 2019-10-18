package by.egorgutko.autorization.presentation.Schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;

import by.egorgutko.autorization.R;

public class SchedulerActivity extends AppCompatActivity {

    NumberPicker numberPickerHour;
    NumberPicker numberPickerMinuute;
    NumberPicker numberPickerPart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        numberPickerHour = findViewById(R.id.numberPickerHour);
        numberPickerHour.setMinValue(0);
        numberPickerHour.setMaxValue(11);


        numberPickerMinuute = findViewById(R.id.numberPickerMinutes);
        numberPickerMinuute.setMinValue(0);
        numberPickerMinuute.setMaxValue(59);


        final String[] myValue = {"PM", "AM", "PM","AM"};
        numberPickerPart = findViewById(R.id.numberPickerAmPm);
        numberPickerPart.setMinValue(0);
        numberPickerPart.setMaxValue(myValue.length-1);
        numberPickerPart.setDisplayedValues(myValue);
    }
}
