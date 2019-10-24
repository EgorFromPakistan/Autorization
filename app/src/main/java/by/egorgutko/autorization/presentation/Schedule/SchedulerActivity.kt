package by.egorgutko.autorization.presentation.Schedule

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import by.egorgutko.autorization.R

class SchedulerActivity : AppCompatActivity() {

    private lateinit var numberPickerHour: NumberPicker
    private lateinit var numberPickerMinuute: NumberPicker
    private lateinit var numberPickerPart: NumberPicker
    private lateinit var numberPickerTemp1: NumberPicker
    private lateinit var numberPickerTemp2: NumberPicker
    private lateinit var numberPickerTemp3: NumberPicker


    private lateinit var radioGroup: RadioGroup

    private lateinit var textViewUpper: TextView
    private lateinit var textViewLower: TextView
    private lateinit var textViewTemperature: TextView

    private lateinit var groupTwo: Group
    private lateinit var groupOne: Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scheduler)

        groupTwo = findViewById(R.id.twoGroup)
        groupOne = findViewById(R.id.oneGroup)

        radioGroup = findViewById(R.id.myRadioGroup)

        textViewUpper = findViewById(R.id.textviewTempereture2)
        textViewLower = findViewById(R.id.textviewTempereture1)
        textViewTemperature = findViewById(R.id.textviewTempereture3)


        numberPickerHour = findViewById(R.id.numberPickerHour)
        numberPickerHour.minValue = 0
        numberPickerHour.maxValue = 11


        numberPickerMinuute = findViewById(R.id.numberPickerMinutes)
        numberPickerMinuute.minValue = 0
        numberPickerMinuute.maxValue = 59


        val myValue = arrayOf("PM", "AM", "PM", "AM")
        numberPickerPart = findViewById(R.id.numberPickerAmPm)
        numberPickerPart.minValue = 0
        numberPickerPart.maxValue = myValue.size - 1
        numberPickerPart.displayedValues = myValue

        numberPickerTemp1 = findViewById(R.id.numberPickerTemperature1)
        numberPickerTemp1.minValue = 0
        numberPickerTemp1.maxValue = 100

        numberPickerTemp2 = findViewById(R.id.numberPickerTemperature2)
        numberPickerTemp2.minValue = 0
        numberPickerTemp2.maxValue = 100

        numberPickerTemp3 = findViewById(R.id.numberPickerTemperature3)
        numberPickerTemp3.minValue = 0
        numberPickerTemp3.maxValue = 100


        groupOne.visibility = View.GONE


        radioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.radio_auto -> {
                    groupOne.visibility = View.GONE
                    groupTwo.visibility = View.VISIBLE
                }
                R.id.radio_heat -> {
                    groupOne.visibility = View.VISIBLE
                    groupTwo.visibility = View.GONE
                }
                else -> {
                }
            }
        }


    }
}
