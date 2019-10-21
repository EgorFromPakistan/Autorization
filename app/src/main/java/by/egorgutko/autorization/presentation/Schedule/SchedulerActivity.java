package by.egorgutko.autorization.presentation.Schedule;

import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import by.egorgutko.autorization.R;

public class SchedulerActivity extends AppCompatActivity {

    NumberPicker numberPickerHour;
    NumberPicker numberPickerMinuute;
    NumberPicker numberPickerPart;
    NumberPicker numberPickerTemp1;
    NumberPicker numberPickerTemp2;
    NumberPicker numberPickerTemp3;

    RadioButton radioButtonHeat;
    RadioButton radioButtonAuto;

    TextView textViewUpper;
    TextView textViewLower;
    TextView textViewTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

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


        textViewTemperature.setVisibility(View.GONE);
        numberPickerTemp3.setVisibility(View.GONE);

        radioButtonHeat = findViewById(R.id.radio_heat);
        radioButtonHeat.setOnClickListener(view -> {
            textViewUpper.setVisibility(View.GONE);
            numberPickerTemp2.setVisibility(View.GONE);
            textViewLower.setVisibility(View.GONE);
            numberPickerTemp1.setVisibility(View.GONE);
            textViewTemperature.setVisibility(View.VISIBLE);
            numberPickerTemp3.setVisibility(View.VISIBLE);
        });


        radioButtonAuto = findViewById(R.id.radio_auto);
        radioButtonAuto.setChecked(true);
        radioButtonAuto.setOnClickListener(view -> {
            textViewUpper.setVisibility(View.VISIBLE);
            numberPickerTemp2.setVisibility(View.VISIBLE);
            textViewLower.setVisibility(View.VISIBLE);
            numberPickerTemp1.setVisibility(View.VISIBLE);
            textViewTemperature.setVisibility(View.GONE);
            numberPickerTemp3.setVisibility(View.GONE);
        });



    }
}
