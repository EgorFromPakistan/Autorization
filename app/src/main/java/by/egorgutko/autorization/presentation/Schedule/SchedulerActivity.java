package by.egorgutko.autorization.presentation.Schedule;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import by.egorgutko.autorization.R;

public class SchedulerActivity extends AppCompatActivity {

    NumberPicker numberPickerHour;
    NumberPicker numberPickerMinuute;
    NumberPicker numberPickerPart;
    NumberPicker numberPickerTemp1;
    NumberPicker numberPickerTemp2;
    NumberPicker numberPickerTemp3;


    RadioGroup radioGroup;

    TextView textViewUpper;
    TextView textViewLower;
    TextView textViewTemperature;

    Group groupTwo;
    Group groupOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        groupTwo = findViewById(R.id.twoGroup);
        groupOne = findViewById(R.id.oneGroup);

        radioGroup = findViewById(R.id.myRadioGroup);

        textViewUpper = findViewById(R.id.textviewTempereture2);
        textViewLower = findViewById(R.id.textviewTempereture1);
        textViewTemperature = findViewById(R.id.textviewTempereture3);


        numberPickerHour = findViewById(R.id.numberPickerHour);
        numberPickerHour.setMinValue(0);
        numberPickerHour.setMaxValue(11);


        numberPickerMinuute = findViewById(R.id.numberPickerMinutes);
        numberPickerMinuute.setMinValue(0);
        numberPickerMinuute.setMaxValue(59);


        final String[] myValue = {"PM", "AM", "PM", "AM"};
        numberPickerPart = findViewById(R.id.numberPickerAmPm);
        numberPickerPart.setMinValue(0);
        numberPickerPart.setMaxValue(myValue.length - 1);
        numberPickerPart.setDisplayedValues(myValue);

        numberPickerTemp1 = findViewById(R.id.numberPickerTemperature1);
        numberPickerTemp1.setMinValue(0);
        numberPickerTemp1.setMaxValue(100);

        numberPickerTemp2 = findViewById(R.id.numberPickerTemperature2);
        numberPickerTemp2.setMinValue(0);
        numberPickerTemp2.setMaxValue(100);

        numberPickerTemp3 = findViewById(R.id.numberPickerTemperature3);
        numberPickerTemp3.setMinValue(0);
        numberPickerTemp3.setMaxValue(100);


        groupOne.setVisibility(View.GONE);


        radioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_auto:
                    groupOne.setVisibility(View.GONE);
                    groupTwo.setVisibility(View.VISIBLE);
                    break;
                case R.id.radio_heat:
                    groupOne.setVisibility(View.VISIBLE);
                    groupTwo.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        });


    }
}
