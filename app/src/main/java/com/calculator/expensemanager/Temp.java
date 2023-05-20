package com.calculator.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import net.objecthunter.exp4j.Expression;
//import net.objecthunter.exp4j.ExpressionBuilder;
//import net.objecthunter.exp4j.ValidationResult;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

//import javax.el.Expression;
//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptException;

public class Temp extends AppCompatActivity {

    //    Button[] numericButtons;
    Button btnClear, btnClearDisplay, btnNegative, btnDelete,
            btnDivision, btnMultiplication, btnSubmission, btnSum, btnEqual, btnDot;
    String tempNew = "";

    boolean isBtn0Pressed = false;
    BigDecimal tempNumber;
    boolean cPressed = false;
//    BigDecimal tempNumberDivide;

    //    BigDecimal tempResult = BigDecimal.ZERO;
    TextView tvDisplay, tvPhrase;

    boolean isOperatorPressed = false;

//    boolean isAdditionPressed = false;
//    boolean isSubtractionPressed = false;
//    boolean isMultiplicationPressed = false;
//    boolean isDivisionPressed = false;
    boolean isEqualPressed = false;

    //    double num1 = 0;
    BigDecimal num1 = BigDecimal.ZERO;
    //    double num2 = 0;
    BigDecimal num2 = BigDecimal.ZERO;
    char op = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        findViews();
        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("0");
                isBtn0Pressed = true;
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumericButtonClick("9");
            }
        });




//        btnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
////                num1 = 0;
////                num2 = 0;
//                num1 = BigDecimal.ZERO;
//                num2 = BigDecimal.ZERO;
////                tempNumberDivide = BigDecimal.ZERO;
//                tempNumber = BigDecimal.ZERO;
//                tempNew = "";
//                op = ' ';
//                tvPhrase.setText("");
//                tvDisplay.setText("0");
//                isEqualPressed = false;
//                isOperatorPressed = false;
//                isAdditionPressed = false;
//                isSubtractionPressed = false;
//                isDivisionPressed = false;
//                isMultiplicationPressed = false;
//                isBtn0Pressed = false;
//            }
//        });
////
//        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvDisplay.setText("0");
//
//                String tvPhraseText = tvPhrase.getText().toString();
//                boolean containsOperator = false;
//                if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
//                    // tvPhrase contains an operator
//                    // Perform your desired action here
//                    containsOperator = true;
//                }
//
//
//
//
//                if(isEqualPressed || !containsOperator){
//
//
//                    btnClear.performClick();
//                    return;
//
//                }
//
//
//
//                isEqualPressed = false;
//                isOperatorPressed = false;
//
////                String tvPhraseText = tvPhrase.getText().toString();
//
//                // Example value of tvPhrase
//                String newNumber = " 0";  // New number to replace the last number
//
//                // Find the index of the last operator
//                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
//
//                if (lastOperatorIndex != -1) {
//                    // Get the substring after the last operator
//                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1);
//
//                    // Replace the last number with the new number
//                    tvPhraseText = tvPhraseText.replace(lastNumber, newNumber);
//                }
//
//                // Assuming you have a TextView or any other view to display the tvPhrase
//                tvPhrase.setText(tvPhraseText);
//            }
//        });

        //
//        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvDisplay.setText("0");
//
//                String tvPhraseText = tvPhrase.getText().toString();
//                 Find the index of the last operator
//                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
//
//                if (lastOperatorIndex != -1) {
//                     Get the substring after the last operator
//                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1).trim();
//
//                    Toast.makeText(Temp.this, lastNumber, Toast.LENGTH_SHORT).show();
//
//
//                    tvPhraseText = tvPhraseText.replace(lastNumber,"0");
//                    tvPhrase.setText(tvPhraseText);
//
//                     Use the lastNumber as needed
//                }
//
//
//
//                isEqualPressed = false;
//                isOperatorPressed = false;
//            }
//        });
//
        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText("0");

                btnClearDisplay.setText("AC");





                String tvPhraseText = tvPhrase.getText().toString();
                boolean containsOperator = tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷");

                // tvPhrase contains an operator
                // Perform your desired action here




                if (isEqualPressed || !containsOperator) {
                        clearScreen();
                        return;

                }


                if(cPressed){


                    clearScreen();
                    return;


                }




//                isOperatorPressed = false;

                // Example value of tvPhrase
                String newNumber = "0";  // New number to replace the last number

                // Find the index of the last operator
                int lastOperatorIndex = Math.max(Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-")),
                        Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷")));

                if (lastOperatorIndex != -1) {
                    // Get the substring after the last operator
                    String afterOperator = tvPhraseText.substring(lastOperatorIndex + 1).trim();

                    // Check if the substring is a number or starts with "0."
                    if (!afterOperator.isEmpty() && afterOperator.matches("-?\\d+(\\.\\d*)?")) {
                        // Replace the last number with the new number
                        tvPhraseText = tvPhraseText.substring(0, lastOperatorIndex + 2) + newNumber;
                    }
                    cPressed = true;
                }


                // Assuming you have a TextView or any other view to display the tvPhrase
                tvPhrase.setText(tvPhraseText);
            }
        });



        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvPhraseText = tvPhrase.getText().toString();
                double previousValue = 0;






                // Find the last operator index
                int lastOperatorIndex = Math.max(Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-")),
                        Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷")));

                // Check if there are no operators in the tvPhraseText string





//                String tvPhraseText = "45 + 10 - 5"; // Example tvPhraseText
//
//                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-"));

                String numberBeforeOperator = "";

                if (lastOperatorIndex != -1) {
                    previousValue = Double.parseDouble(String.valueOf(tvPhraseText.substring(0, lastOperatorIndex).trim()));





                    char lastOperator = tvPhraseText.charAt(lastOperatorIndex);

                    // Check if the last operator is "+" or "-"
                    if (lastOperator == '+' || lastOperator == '-') {





                        if (lastOperatorIndex == tvPhraseText.length() - 1) {
                            // Check if the tvPhraseText string is a number
                            if (tvPhraseText.matches("-?\\d+(\\.\\d+)?")) {
                                // Convert the tvPhraseText string to a double
                                double number = Double.parseDouble(tvPhraseText);

                                // Calculate the percentage value based on the previous number
                                double percentageValue = (number * previousValue) / 100;
                                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                                String roundedPercentageValue = decimalFormat.format(percentageValue);


                                // Convert the percentage value back to a string

                                // Replace the last number in the tvPhraseText string with the percentage value
                                tvPhraseText = tvPhraseText.substring(0, lastOperatorIndex + 1) + " " + roundedPercentageValue;
                            }
                        } else {
                            // Get the substring after the last operator
                            String afterOperator = tvPhraseText.substring(lastOperatorIndex + 1).trim();

                            // Check if the substring is a number
                            if (afterOperator.matches("-?\\d+(\\.\\d+)?")) {
                                // Convert the last number to a double
                                double lastNumber = Double.parseDouble(afterOperator);

                                // Calculate the percentage value based on the previous number
                                double percentageValue = (lastNumber * previousValue) / 100;

                                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                                String roundedPercentageValue = decimalFormat.format(percentageValue);


                                // Convert the percentage value back to a string

                                // Replace the last number in the tvPhraseText string with the percentage value
                                tvPhraseText = tvPhraseText.substring(0, lastOperatorIndex + 1) + " " + roundedPercentageValue;
                            }
                        }






                    } else {
















                        // Find the last operator index
//                        int lastOper??atorIndex = Math.max(Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-")),
//                                Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷")));

                        // Check if there are no operators in the tvPhraseText string
                        if (lastOperatorIndex == tvPhraseText.length() - 1) {
                            // Check if the tvPhraseText string is a number
                            if (tvPhraseText.matches("-?\\d+(\\.\\d+)?")) {
                                // Convert the tvPhraseText string to a double
                                double number = Double.parseDouble(tvPhraseText);

                                // Divide the number by 10
                                double updatedNumber = number / 100;

                                DecimalFormat decimalFormat = new DecimalFormat("#0.00");


                                // Convert the updated number back to a string

                                // Set the updated number as the new tvPhraseText
                                tvPhraseText = decimalFormat.format(updatedNumber);


                            }
                        } else {
                            // Get the substring after the last operator
                            String afterOperator = tvPhraseText.substring(lastOperatorIndex + 1).trim();

                            // Check if the substring is a number
                            if (afterOperator.matches("-?\\d+(\\.\\d+)?")) {
                                // Convert the last number to a double
                                double lastNumber = Double.parseDouble(afterOperator);

                                // Divide the last number by 10
                                double updatedNumber = lastNumber / 100;

                                DecimalFormat decimalFormat = new DecimalFormat("#0.00");


                                // Convert the updated number back to a string
                                String updatedNumberString = decimalFormat.format(updatedNumber);

                                // Replace the last number in the tvPhraseText string
                                tvPhraseText = tvPhraseText.substring(0, lastOperatorIndex + 1) + " " + updatedNumberString;
                            }
                        }

                    }

                } else {

//                    Toast.makeText(Temp.this, "only number", Toast.LENGTH_SHORT).show();

                    double number = Double.parseDouble(tvPhraseText) / 100;
                    
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    
                    // Convert the updated number back to a string
                    tvPhraseText = decimalFormat.format(number);
                    
                }

                // Set the modified tvPhraseText string back to the tvPhrase TextView


//                Toast.makeText(Temp.this, "i am pressed", Toast.LENGTH_SHORT).show();


                if(isEqualPressed){

                    double number = Double.parseDouble(tvDisplay.getText().toString()) / 100;

                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");

                    // Convert the updated number back to a string
                    tvPhraseText = decimalFormat.format(number);

                }

                tvPhrase.setText(tvPhraseText);
                calculateViaLibrary(tvPhraseText);



            }
        });









        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOperatorPressed = false;
                String tvDisplayText = tvDisplay.getText().toString();
                if (tvDisplayText.length() > 0) {
                    tvDisplayText = tvDisplayText.substring(0, tvDisplayText.length() - 1);
                    if (tvDisplayText.length() == 0) {
                        tvDisplayText = "0";
                        isEqualPressed = false;
                        isOperatorPressed = false;
                    }
                    BigDecimal roundedResult = tempNumber.setScale(2, RoundingMode.HALF_UP);
                    // Check if the rounded result is a whole number
                    if (roundedResult.stripTrailingZeros().scale() <= 0) {
                        String strTempRes = roundedResult.stripTrailingZeros().toPlainString();
                        tvDisplay.setText(strTempRes);

                    } else {
                        String strTempRes = roundedResult.toPlainString();
                        tvDisplay.setText(strTempRes);
                    }
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(isDivisionPressed){
//                    return;
//                }
//
//                isDivisionPressed = true;

                String tvPhraseText = tvPhrase.getText().toString();

// Check if the string ends with an operator
                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
                    // Replace the last operator with 'x'
                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " ÷ ";


                    // Set the modified text back to the TextView
                    tvPhrase.setText(modifiedText);
                } else {

                    isOperatorPressed = true;
                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }

                    if(op != ' '){
                        calculateViaLibrary(tvPhraseText);
                    }

                    op = '÷';
                    tempNew += tvDisplayText + " ÷ ";
                    tvPhrase.setText(tempNew);

//                    BigDecimal roundedResult = tempNumber.setScale(2, RoundingMode.HALF_UP);
//                    // Check if the rounded result is a whole number
//                    if (roundedResult.stripTrailingZeros().scale() <= 0) {
//                        String strTempRes = roundedResult.stripTrailingZeros().toPlainString();
//                        tvDisplay.setText(strTempRes);
//
//                    } else {
//                        String strTempRes = roundedResult.toPlainString();
//                        tvDisplay.setText(strTempRes);
//                    }

                }

                op = '÷';
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tvPhraseText = tvPhrase.getText().toString();

                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
                    // Replace the last operator with 'x'
                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " x ";

                    tvPhrase.setText(modifiedText);
                } else {

                    isOperatorPressed = true;
                    String tvDisplayText = tvDisplay.getText().toString();

                    if(op != ' '){
                        calculateViaLibrary(tvPhraseText);
                    }

                    tempNew += tvDisplayText + " x ";
                    tvPhrase.setText(tempNew);


                }
                op = 'x';
            }
        });




        btnSubmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(isSubtractionPressed){
//                    return;
//                }
//                isSubtractionPressed = true;


                String tvPhraseText = tvPhrase.getText().toString();

// Check if the string ends with an operator
                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
                    // Replace the last operator with 'x'
                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " - ";


                    // Set the modified text back to the TextView
                    tvPhrase.setText(modifiedText);
                } else {
                    isOperatorPressed = true;
                    String tvDisplayText = tvDisplay.getText().toString();

//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }

                    if(op != ' '){
                        calculateViaLibrary(tvPhraseText);
                    }


                    tempNew += tvDisplayText + " - ";
                    tvPhrase.setText(tempNew);
//                    BigDecimal roundedResult = tempNumber.setScale(2, RoundingMode.HALF_UP);

                    // Check if the rounded result is a whole number
//                    if (roundedResult.stripTrailingZeros().scale() <= 0) {
//                        String strTempRes = roundedResult.stripTrailingZeros().toPlainString();
//                        tvDisplay.setText(strTempRes);
//
//                    } else {
//                        String strTempRes = roundedResult.toPlainString();
//                        tvDisplay.setText(strTempRes);
//                    }

                }

                op = '-';

            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(isAdditionPressed){
//                    return;
//                }
//
//                isAdditionPressed = true;



                String tvPhraseText = tvPhrase.getText().toString();

// Check if the string ends with an operator
                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
                    // Replace the last operator with 'x'
                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " + ";


                    // Set the modified text back to the TextView
                    tvPhrase.setText(modifiedText);
                } else {

                    isOperatorPressed = true;
                    String tvDisplayText = tvDisplay.getText().toString();

//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }

                    if(op != ' '){
                        calculateViaLibrary(tvPhraseText);
                    }

                    op = '+';
                    tempNew += tvDisplayText + " + ";
                    tvPhrase.setText(tempNew);
//                    tvDisplay.setText(String.valueOf(tempNumber));



//                    BigDecimal roundedResult = tempNumber.setScale(2, RoundingMode.HALF_UP);
//                    // Check if the rounded result is a whole number
//                    if (roundedResult.stripTrailingZeros().scale() <= 0) {
//                        String strTempRes = roundedResult.stripTrailingZeros().toPlainString();
//                        tvDisplay.setText(strTempRes);
//
//                    } else {
//                        String strTempRes = roundedResult.toPlainString();
//                        tvDisplay.setText(strTempRes);
//                    }



                }


                op = '+';


            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvDisplayText = tvDisplay.getText().toString();
                if (!isOperatorPressed && op != ' ') {


                    btnClearDisplay.setText("AC");

//                    isAdditionPressed = false;
//
//                    isSubtractionPressed = false;
//
//                    isDivisionPressed = false;
//
//                    isMultiplicationPressed = false;

                    num2 = new BigDecimal(tvDisplayText);

                    isOperatorPressed = false;
                    isEqualPressed = true;

                        calculateViaLibrary(tvPhrase.getText().toString());


                        String temp = tvPhrase.getText().toString() + " = ";
                        tvPhrase.setText(temp);
                        op = ' ';
                        num1 = BigDecimal.ZERO;
                        num2 = BigDecimal.ZERO;
                        tempNew = "";
                        tempNumber = BigDecimal.ZERO;

                }
            }
        });


//        btnDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                String tvDisplayText = tvDisplay.getText().toString();
//                String tvPhraseText = tvPhrase.getText().toString();
//
////                Toast.makeText(Temp.this, "1" + tvDisplayText + "1", Toast.LENGTH_SHORT).show();
//
//
//                if(tvDisplayText.contains(".")){
//                    return;
//                }
//
//
//
//
//                // attention need to replace tvDiplayText.isEmpty() with isOperatorPressed
//
//
//
//                if( isOperatorPressed || isEqualPressed){
//
//
////                    if (tvPhraseText.equals("0")) {
////                        tvPhrase.setText("");
////
////                    }
//
//                    if(!isBtn0Pressed){
//                        btn0.performClick();
//                    }
//
//                }
//
//
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        String tvDisplayText = tvDisplay.getText().toString();
//                        String tvPhraseText = tvPhrase.getText().toString();
//
//
//                        tvDisplayText = tvDisplayText + ".";
//
//                        tvPhraseText = tvPhraseText + ".";
//
//
//                        tvDisplay.setText(tvDisplayText);
//                        tvPhrase.setText(tvPhraseText);
//
//                    }
//                }, 10);
//
//
//
//
//            }
//        });

//        Button btnDot = findViewById(R.id.btnDot);
//        Button btnDot = findViewById(R.id.btnDot);
//        Button btnDot = findViewById(R.id.btnDot);
//        Button btnDot = findViewById(R.id.btnDot);
//        btnDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.isEmpty() || tvDisplayText.contains(".")) {
//
//
//                    if(isEqualPressed || isOperatorPressed){
//
//                        tvDisplayText = "0.";
//                        tvDisplay.setText(tvDisplayText);
//
//                    }
//
//                    return;
//                }
//
//
//                if(isEqualPressed || isOperatorPressed){
//
//                    tvDisplayText = "0.";
//                    tvDisplay.setText(tvDisplayText);
//
//                } else {
//                    tvDisplayText += '.';
//                    tvDisplay.setText(tvDisplayText);
//
//                }
//
//                if(isEqualPressed){
//                    tvPhrase.setText("");
//                    isEqualPressed =false;
//                }
//
//            }
//        });
        btnDot.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){

                    isBtn0Pressed = false;
//                    cPressed = false;

                String tvDisplayText = tvDisplay.getText().toString();
                String tvPhraseText = tvPhrase.getText().toString();

//                Toast.makeText(Temp.this, "1" + tvDisplayText + "1", Toast.LENGTH_SHORT).show();


//                if (tvDisplayText.contains(".")) {
//                    return;
//                }


//                    String tvPhraseText = tvPhrase.getText().toString();
                    boolean iContainOperator = false;
                    String lastNumber = "";

// Check if the tvPhraseText contains an operator
                    if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
                        // Split the tvPhraseText into an array of strings based on the operators

//                         iContainOperator = true;

                        String[] numbers = tvPhraseText.split("\\+|-|x|÷");

                        // Get the last number from the array (which will be the number after the last operator)
                        if (numbers.length > 0) {
                            lastNumber = numbers[numbers.length - 1].trim();
                        }
                    }


//                            Toast.makeText(Temp.this, String.valueOf(isOperatorPressed), Toast.LENGTH_SHORT).show();


                    if((lastNumber.contains(".") || tvDisplayText.contains(".")) && (!isEqualPressed && !isOperatorPressed)){
//                        Toast.makeText(Temp.this, "truereturn", Toast.LENGTH_SHORT).show();
                        return;
                    }

// Use the lastNumber as needed



//                    Toast.makeText(Temp.this, String.valueOf(isEqualPressed), Toast.LENGTH_SHORT).show();
                if ( isOperatorPressed || isEqualPressed || tvPhraseText.isEmpty()) {


//                    if (tvPhraseText.equals("0")) {
//                        tvPhrase.setText("");
//
//                    }

//                    Toast.makeText(Temp.this, String.valueOf(isBtn0Pressed), Toast.LENGTH_SHORT).show();

                    if (!isBtn0Pressed) {
                        btn0.performClick();
//                        Toast.makeText(Temp.this, "i am called", Toast.LENGTH_SHORT).show();
                    }

                }


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Code to be executed after the delay
                        // Place your desired logic or actions here
                        String tvDisplayText = tvDisplay.getText().toString();
                        String tvPhraseText = tvPhrase.getText().toString();


                        tvDisplayText = tvDisplayText + ".";

                        tvPhraseText = tvPhraseText + ".";
                        cPressed = false;

                        tvDisplay.setText(tvDisplayText);
                        tvPhrase.setText(tvPhraseText);


                    }
                }, 10); // 10000 milliseconds = 10 seconds


            }

            });


        }





    private BigDecimal calculate(BigDecimal num1, BigDecimal num2, char op) {
        switch (op) {
            case '+':
                return num1.add(num2);
            case '-':
                return num1.subtract(num2);
            case 'x':
                return num1.multiply(num2);
            case '÷':
                if (num2.compareTo(BigDecimal.ZERO) != 0) {
                    return num1.divide(num2, 2, RoundingMode.HALF_UP);
                } else {
                    return BigDecimal.ZERO;
                }
            default:
                return BigDecimal.ZERO;
        }
    }


    private void findViews() {
        btnClear = findViewById(R.id.btn_clear);
        btnClearDisplay = findViewById(R.id.btn_clear_display);
        btnNegative = findViewById(R.id.btn_negative);
        btnDelete = findViewById(R.id.btn_delete);
        btnDivision = findViewById(R.id.btn_division);
        btnMultiplication = findViewById(R.id.btn_multiplication);
        btnSubmission = findViewById(R.id.btn_submission);
        btnSum = findViewById(R.id.btn_sum);
        btnEqual = findViewById(R.id.btn_equal);
        btnDot = findViewById(R.id.btn_dot);
        tvDisplay = findViewById(R.id.tv_display);
        tvPhrase = findViewById(R.id.tv_phrase);
    }





    // Function to handle the click event for numeric buttons
    private void handleNumericButtonClick(String value) {








        if (isEqualPressed) {


//            if(!tvDisplay.getText().toString().equals("0.")){

            tvDisplay.setText("");
//            }



            if(!isOperatorPressed){
                tvPhrase.setText("");
//                Toast.makeText(this, "equal was pressed", Toast.LENGTH_SHORT).show();

            }



            isEqualPressed = false;
        }


        if (isOperatorPressed) {


//            if( !tvDisplay.getText().toString().equals("0.")){
            tvDisplay.setText("");

//            }


            isOperatorPressed = false;
        }

        String tvDisplayText = tvDisplay.getText().toString();
        String tvPhraseText = tvPhrase.getText().toString();

        if (tvDisplayText.equals("0")) {
            tvDisplayText = "";

        }

//        if(tvPhraseText.equals("0")){
//            tvPhraseText = "";
//        }


        // do not use this it is conflicting
//        if (tvPhraseText.endsWith("0")) {
//            // Remove the last character from tvPhrase
//            tvPhraseText = tvPhraseText.substring(0, tvPhraseText.length() - 1);
//
//        }

        int lastOperatorIndex = Math.max(Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-")),
                Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷")));

        String lastDigit = tvPhraseText.substring(lastOperatorIndex + 1).trim();
        if (lastDigit.equals("0")) {
            tvPhraseText = tvPhraseText.substring(0, tvPhraseText.length() - 1);
        }






        tvDisplayText += value;
        tvDisplay.setText(tvDisplayText);

        tvPhraseText += value;
        tvPhrase.setText(tvPhraseText);
        isBtn0Pressed = false;
        btnClearDisplay.setText("C");
        cPressed = false;
    }


    public static double eval(final String str) {
        try {
            Expression expression = new ExpressionBuilder(str)
                    .build();
            return expression.evaluate();
        } catch (Exception e) {
            // Handle any evaluation or parsing errors
            e.printStackTrace();
            return Double.NaN;
        }
    }


    private void clearScreen(){
        isOperatorPressed = false;
//                num1 = 0;
//                num2 = 0;
        num1 = BigDecimal.ZERO;
        num2 = BigDecimal.ZERO;
//                tempNumberDivide = BigDecimal.ZERO;
        tempNumber = BigDecimal.ZERO;
        tempNew = "";
        op = ' ';
        tvPhrase.setText("");
        tvDisplay.setText("0");
        isEqualPressed = false;
        isOperatorPressed = false;
//        isAdditionPressed = false;
//        isSubtractionPressed = false;
//        isDivisionPressed = false;
//        isMultiplicationPressed = false;
        isBtn0Pressed = false;

        tvDisplay.setText("0");
//        tvPhrase.setText("");
    }
















    private void calculateViaLibrary(String expression){
        String tvDisplayText = tvDisplay.getText().toString();
//        if (!isOperatorPressed && op != ' ') {


//            btnClearDisplay.setText("AC");

//                    isAdditionPressed = false;
//
//                    isSubtractionPressed = false;
//
//                    isDivisionPressed = false;
//
//                    isMultiplicationPressed = false;

//            num2 = new BigDecimal(tvDisplayText);

//            isOperatorPressed = false;
//            isEqualPressed = true;

            try {
                double result = eval(expression.replaceAll("x", "*").replaceAll("÷", "/"));
                BigDecimal decimalResult = BigDecimal.valueOf(result);

                // Round the result to 2 decimal places
                BigDecimal roundedResult = decimalResult.setScale(2, RoundingMode.HALF_UP);

                // Check if the rounded result is a whole number
                if (roundedResult.stripTrailingZeros().scale() <= 0) {
                                        tvDisplay.setText( roundedResult.stripTrailingZeros().toPlainString());

                String temp = tvPhrase.getText().toString();
                tvPhrase.setText(temp);
//                    op = ' ';
//                    num1 = BigDecimal.ZERO;
//                    num2 = BigDecimal.ZERO;
//                    tempNew = "";
//                    tempNumber = BigDecimal.ZERO;

                    roundedResult.stripTrailingZeros().toPlainString();

                } else {
                                        tvDisplay.setText(roundedResult.toPlainString());

                String temp = tvPhrase.getText().toString();
                tvPhrase.setText(temp);
//                    op = ' ';
//                    num1 = BigDecimal.ZERO;
//                    num2 = BigDecimal.ZERO;
//                    tempNew = "";
//                    tempNumber = BigDecimal.ZERO;
                    roundedResult.toPlainString();
                }


            } catch (RuntimeException e) {
                // Handle expression evaluation error
                e.printStackTrace();
            }
    }


//    }




}