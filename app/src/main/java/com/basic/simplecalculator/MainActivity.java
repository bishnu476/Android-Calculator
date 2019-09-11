package com.basic.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    TextView textCalculation, textResult;

    //Instance  Variables

    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;
    private String calculationString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationsResult = 0;
        calculationString = "";

        textCalculation = (TextView) findViewById(R.id.textCalculation);
        textResult = (TextView) findViewById(R.id.textResult);

        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDIvide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnDIvide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationString += "/";

                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationString += "*";
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnMinus:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationString += "-";

                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationString += "+";
                break;

        }

        textCalculation.setText(calculationString);

    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        textResult.setText(currentNumber);
        calculationString = currentNumber;
        textCalculation.setText(calculationString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {
        if (currentOperator != null) {
            if (currentNumber != "") {
                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {
                    case PLUS:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);

                        break;
                    case DIVIDE:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationsResult);
                textResult.setText(stringNumberAtLeft);

                calculationString = stringNumberAtLeft;


            }

        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber
                    = "";
        }
        currentOperator = tappedOperator;
    }

    private void clearTapped() {
        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        currentNumber = "";
        calculationsResult = 0;
        textResult.setText("0");
        currentOperator = null;
        calculationString = "";

    }
}
