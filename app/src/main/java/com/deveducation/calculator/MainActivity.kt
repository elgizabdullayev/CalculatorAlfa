package com.deveducation.calculator

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var displayOperations : TextView
    private lateinit var but7 : Button
    private lateinit var but8 : Button
    private lateinit var but9 : Button
    private lateinit var but4 : Button
    private lateinit var but5 : Button
    private lateinit var but6 : Button
    private lateinit var but1 : Button
    private lateinit var but2 : Button
    private lateinit var but3 : Button
    private lateinit var but0 : Button
    private lateinit var but00 : Button
    private lateinit var butClear : Button
    private lateinit var butDot : Button
    private lateinit var butDelete : Button
    private lateinit var butDivide : Button
    private lateinit var butMultiply : Button
    private lateinit var butPlus : Button
    private lateinit var butMinus : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    displayOperations = findViewById(R.id.displayOperations)
        but7 = findViewById(R.id.but7)
        but8 = findViewById(R.id.but8)
        but9 = findViewById(R.id.but9)
        but4 = findViewById(R.id.but4)
        but5 = findViewById(R.id.but5)
        but6 = findViewById(R.id.but6)
        but1 = findViewById(R.id.but1)
        but2 = findViewById(R.id.but2)
        but3 = findViewById(R.id.but3)
        but0 = findViewById(R.id.but0)
        but00 = findViewById(R.id.but00)
        butClear = findViewById(R.id.butClear)
        butDot = findViewById(R.id.butDot)
        butDelete = findViewById(R.id.butDelete)
        butDivide = findViewById(R.id.butDivide)
        butMultiply = findViewById(R.id.butMultiply)
        butPlus = findViewById(R.id.butPlus)
        butMinus = findViewById(R.id.butMinus)
    }
    var firstZero : Boolean = false
    var existingDot : Boolean = false
    var haveSign : Boolean = true
    fun numbers(view: View) {
        var butclick : String = displayOperations.text.toString()
        var buttonSelect : Button = view as Button

        when(buttonSelect.id){
            but7.id -> {if(firstZero==false){
                butclick += "7"
                haveSign = false
            displayOperations.text = butclick}
            }
            but8.id -> {if(firstZero==false){
                butclick += "8"
                haveSign = false
                displayOperations.text = butclick}
            }
            but9.id -> {if(firstZero==false){
                butclick += "9"
                haveSign = false
                displayOperations.text = butclick}
            }
            but4.id -> {if(firstZero==false){
                butclick += "4"
                haveSign = false
                displayOperations.text = butclick}
            }
            but5.id -> {if(firstZero==false){
                butclick += "5"
                haveSign = false
                displayOperations.text = butclick}
            }
            but6.id -> {if(firstZero==false){
                butclick += "6"
                haveSign = false
                displayOperations.text = butclick}
            }
            but1.id -> {if(firstZero==false){
                butclick += "1"
                haveSign = false
                displayOperations.text = butclick}
            }
            but2.id -> {if(firstZero==false){
                butclick += "2"
                haveSign = false
                displayOperations.text = butclick}
            }
            but3.id -> {if(firstZero==false){
                butclick += "3"
                haveSign = false
                displayOperations.text = butclick}
            }
            but0.id -> {if(firstZero==false){
                butclick += "0"

                if(existingDot == true){
                firstZero = false
                }
                else if (existingDot == false && displayOperations.text == "" || haveSign == true) {
                    firstZero = true
                    haveSign = false
                }
                displayOperations.text = butclick}
            }
            but00.id -> {if (displayOperations.text != "" && firstZero == false && haveSign == false) {
                butclick += "00"
                displayOperations.text = butclick}
            }
            butDot.id -> {if (existingDot == false && displayOperations.text != "" && haveSign == false) {butclick += "."
                existingDot = true
                firstZero = false
            displayOperations.text = butclick}
            }

        }
    }

    fun butClear(view: View) {
        var clean : String = ""
        var buttonSelect : Button = view as Button
        when(buttonSelect.id){
            butClear.id -> { displayOperations.text = clean
                existingDot = false
                firstZero = false}
        }

    }

    fun delete(view: View) {
        var buttonSelect : Button = view as Button
        var temp : String = displayOperations.text.toString()
        when(buttonSelect.id){
            butDelete.id -> {
                if (displayOperations.text != "") {
                    if(displayOperations.text.endsWith(".")) {
                     existingDot = false
                        displayOperations.text = temp.substring(0, temp.length - 1)
                    }
                    else{
                    displayOperations.text = temp.substring(0, temp.length - 1)
                    }
                if(displayOperations.text == "") {
                  firstZero = false
                    existingDot = false
                }
            }
            }
        }
    }

    fun mathOp(view: View) {
        var butclick: String = displayOperations.text.toString()
        var buttonSelect: Button = view as Button
        when (buttonSelect.id) {
            butDivide.id -> {
                if (displayOperations.text != "" && haveSign == false) {
                    butclick += "/"
                    displayOperations.text = butclick
                    haveSign = true
                }
            }
            butMultiply.id -> {
                if (displayOperations.text != "" && haveSign == false) {
                    butclick += "*"
                    displayOperations.text = butclick
                    haveSign = true
                }
            }
            butPlus.id -> {
                if (displayOperations.text != "" && haveSign == false) {
                    butclick += "+"
                    displayOperations.text = butclick
                    haveSign = true
                }
            }
            butMinus.id -> {
                if (displayOperations.text != "" && haveSign == false) {
                    butclick += "-"
                    displayOperations.text = butclick
                    haveSign = true
                }
            }
        }
    }
}