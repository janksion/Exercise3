package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var PremiumTotal: Premium

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ArrayAdapter.createFromResource(
            this,
            R.array.ageRange,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerAge.adapter = adapter
        }

        PremiumTotal = ViewModelProviders.of(this).get(Premium::class.java)

        display()

        btnCalculate.setOnClickListener(){
            PremiumTotal.Result = getPremium()
            display()
        }

        btnReset.setOnClickListener() {
            spinnerAge.setSelection(0)
            radGroup.clearCheck()
            chkYes.setChecked(false)
            lblTotalResult.text = ""
            PremiumTotal.Result = 0
        }
    }

    fun display() {
        if (PremiumTotal.Result != 0) {
            lblTotalResult.text = "RM " + PremiumTotal.Result.toString()
        }
    }

    fun getPremium():Int {
        var premium: Int = 0;
        if (spinnerAge.selectedItemPosition == 0) {
            premium = 60
            return premium
        } else if (spinnerAge.selectedItemPosition == 1) {
            premium = 70

            if (chkYes.isChecked) {
                premium += 100
            }

            if (radMale.isChecked) {
                premium += 50
                return  premium
            } else if (radFemale.isChecked) {
                return premium
            }
        } else if (spinnerAge.selectedItemPosition == 2) {
            premium = 90

            if (chkYes.isChecked) {
                premium += 150
            }

            if (radMale.isChecked) {
                premium += 100
                return  premium
            } else if (radFemale.isChecked) {
                return  premium
            }
        } else if (spinnerAge.selectedItemPosition == 3) {
            premium = 120

            if (chkYes.isChecked) {
                premium += 200
            }

            if (radMale.isChecked) {
                premium += 150
                return  premium
            } else if (radFemale.isChecked) {
                return  premium
            }
        } else if (spinnerAge.selectedItemPosition == 4) {
            premium = 150

            if (chkYes.isChecked) {
                premium += 250
            }

            if (radMale.isChecked) {
                premium += 200
                return  premium
            } else if (radFemale.isChecked) {
                return  premium
            }
        } else if (spinnerAge.selectedItemPosition == 5) {
            premium = 150

            if (chkYes.isChecked) {
                premium += 300
            }

            if (radMale.isChecked) {
                premium += 200
                return  premium
            } else if (radFemale.isChecked) {
                return  premium
            }
        }
        return  premium
    }
}
