package com.calculator.expensemanager;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.addisonelliott.segmentedbutton.SegmentedButton;
import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputLayout;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Transaction extends AppCompatActivity {

    ImageButton btnImgCancelAddTrans;
    SegmentedButtonGroup segmentedButtonGroup;
    EditText editTextTransaction;
    LinearLayout textInputLayout;
    TextView textViewPrefixTransaction;
    ImageView imageViewCalculatorTransaction;
    BottomSheetDialog bottomSheetTransaction;
    BottomSheetBehavior<View> bottomSheetBehavior;
    View bottomSheetView;

//    private Button b1;
//    private Button b2;
//    private Button b3;
//    private Button b4;
//    private Button b5;
//    private Button b6;
//    private Button b7;
//    private Button b8;
//    private Button b9;
//    private Button b0;
//    private Button b_equal;
//    private Button b_multi;
//    private Button b_divide;
//    private Button b_add;
//    private Button b_sub;
//    private Button b_clear;
//    private Button b_dot;
//    private Button b_para1;
//    private Button b_para2;
//    private TextView t1;
//    private TextView t2;
//    private final char ADDITION = '+';
//    private final char SUBTRACTION = '-';
//    private final char MULTIPLICATION = '*';
//    private final char DIVISION = '/';
//    private final char EQU = '=';
//    private final char EXTRA = '@';
//    private final char MODULUS = '%';
//    private char ACTION;
//    private double val1 = Double.NaN;
//    private double val2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        btnImgCancelAddTrans = findViewById(R.id.btn_img_cancel_add_trans);
        segmentedButtonGroup = findViewById(R.id.buttonGroup_lordOfTheRings);
        editTextTransaction = findViewById(R.id.edit_text_transaction);
        textInputLayout = findViewById(R.id.edit_text_layout_transaction);
        textViewPrefixTransaction = findViewById(R.id.text_view_prefix_transaction);
        imageViewCalculatorTransaction = findViewById(R.id.image_view_calculator_transaction);
        bottomSheetTransaction = new BottomSheetDialog(Transaction.this);

        bottomSheetView = LayoutInflater.from(Transaction.this).inflate(R.layout.bottom_nav_sheet,null);







//        viewSetup();












        btnImgCancelAddTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.animation_stay, R.anim.slide_out_bottom);

            }
        });

        segmentedButtonGroup.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(final int position) {
                
                switch (position){
                    case 0:

                        Toast.makeText(Transaction.this, "Expense", Toast.LENGTH_SHORT).show();
                        break;
                        
                        
                    case 1:
                        Toast.makeText(Transaction.this, "Income", Toast.LENGTH_SHORT).show();
                        break;
                        
                    case 2:
                        Toast.makeText(Transaction.this, "Transfer", Toast.LENGTH_SHORT).show();
                        break;
                }
                
                
            }
        });

//        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Perform your action here
//
//                Toast.makeText(Transaction.this, "Calculator Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });



        editTextTransaction.setHint("₹ 0");// to be dynamic in future remember


// need to set hint when edit text is empty and is not focused in future remember vibhu;

        editTextTransaction.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {

                    textInputLayout.setBackgroundResource(R.drawable.rounded_layout_outline_focused);
                    textViewPrefixTransaction.setText("₹");
                    editTextTransaction.setHint("");

                } else {

                    textInputLayout.setBackgroundResource(R.drawable.rounded_layout_dark_background);
                    textViewPrefixTransaction.setText("");


                }
            }
        });

// Get current position
//        segmentedButtonGroup.getPosition();

        
        imageViewCalculatorTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


////        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_nav_sheet, null);
//
////        BottomSheetDialog bottomSheetTransaction = new BottomSheetDialog(Transaction.this);
////        BottomSheetBehavior<View> bottomSheetBehavior;
//                bottomSheetTransaction.setContentView(bottomSheetView);
//
//                bottomSheetTransaction.setCanceledOnTouchOutside(false);
//                bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
//                bottomSheetBehavior.setDraggable(false);
//                bottomSheetBehavior.setState(STATE_EXPANDED);
//
////                bottomSheetTransaction.setContentView(bottomSheetView);
//
//
//                // do not open it  sheet will open as per the requirement
////                CoordinatorLayout coordinatorLayout = bottomSheetView.findViewById(R.id.bottom_sheet_coordinator_layout);
////                assert coordinatorLayout != null;
////                coordinatorLayout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
//
//                bottomSheetTransaction.show();

                Intent intent = new Intent(Transaction.this, Temp.class);
                startActivity(intent);
            }
        });


//
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "1");
//            }
//        });
//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "2");
//            }
//        });
//
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "3");
//            }
//        });
//
//
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "4");
//            }
//        });
//
//        b5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "5");
//            }
//        });
//
//        b6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "6");
//            }
//        });
//
//        b7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "7");
//            }
//        });
//
//        b8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "8");
//            }
//        });
//a
//        b9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "9");
//            }
//        });
//
//        b0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "0");
//            }
//        });
//
//        b_dot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                exceedLength();
//                t1.setText(t1.getText().toString() + ".");
//            }
//        });
//
//
//        b_para1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (t1.getText().length() > 0) {
//                    ACTION = MODULUS;
//                    operation();
//                    if (!ifReallyDecimal()) {
//                        t2.setText(val1 + "%");
//                    } else {
//                        t2.setText((int) val1 + "%");
//                    }
//                    t1.setText(null);
//                } else {
//                    t2.setText("Error");
//                }
//            }
//        });
//
//        b_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (t1.getText().length() > 0) {
//                    ACTION = ADDITION;
//                    operation();
//                    if (!ifReallyDecimal()) {
//                        t2.setText(val1 + "+");
//                    } else {
//                        t2.setText((int) val1 + "+");
//                    }
//                    t1.setText(null);
//                } else {
//                    t2.setText("Error");
//                }
//            }
//        });
//
//
//        b_sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(Transaction.this, "i am clided", Toast.LENGTH_SHORT).show();
//                if (t1.getText().length() > 0) {
//                    ACTION = SUBTRACTION;
//                    operation();
//                    if (t1.getText().length() > 0)
//                        if (!ifReallyDecimal()) {
//                            t2.setText(val1 + "-");
//                        } else {
//                            t2.setText((int) val1 + "-");
//                        }
//                    t1.setText(null);
//                } else {
//                    t2.setText("Error");
//                }
//            }
//        });
//
//        b_multi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (t1.getText().length() > 0) {
//                    ACTION = MULTIPLICATION;
//                    operation();
//                    if (!ifReallyDecimal()) {
//                        t2.setText(val1 + "×");
//                    } else {
//                        t2.setText((int) val1 + "×");
//                    }
//                    t1.setText(null);
//                } else {
//                    t2.setText("Error");
//                }
//            }
//        });
//
//        b_divide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (t1.getText().length() > 0) {
//                    ACTION = DIVISION;
//                    operation();
//                    if (ifReallyDecimal()) {
//                        t2.setText((int) val1 + "/");
//                    } else {
//                        t2.setText(val1 + "/");
//                    }
//                    t1.setText(null);
//                } else {
//                    t2.setText("Error");
//                }
//            }
//        });
//
//        b_para2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!t2.getText().toString().isEmpty() || !t1.getText().toString().isEmpty()) {
//                    val1 = Double.parseDouble(t1.getText().toString());
//                    ACTION = EXTRA;
//                    t2.setText("-" + t1.getText().toString());
//                    t1.setText("");
//                } else {
//                    t2.setText("Error");
//                }
//            }
//        });
//
//        b_equal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (t1.getText().length() > 0) {
//                    operation();
//                    ACTION = EQU;
//                    if (!ifReallyDecimal()) {
//                        t2.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf(val1));
//                    } else {
//                        t2.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf((int) val1));
//                    }
//                    t1.setText(null);
//                } else {
//                    t2.setText("Error");
//                }
//            }
//        });
//
//
//
//        b_clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (t1.getText().length() > 0) {
//                    CharSequence name = t1.getText().toString();
//                    t1.setText(name.subSequence(0, name.length() - 1));
//                } else {
//                    val1 = Double.NaN;
//                    val2 = Double.NaN;
//                    t1.setText("");
//                    t2.setText("");
//                }
//            }
//        });
//
//        // Empty text views on long click.
//        b_clear.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                val1 = Double.NaN;
//                val2 = Double.NaN;
//                t1.setText("");
//                t2.setText("");
//                return true;
//            }
//        });
//








































    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Set the animation for the activity when it is closed
        overridePendingTransition(R.anim.animation_stay, R.anim.slide_out_bottom);



    }

//    private void exceedLength() {
//        if (t1.getText().toString().length() > 10) {
//            t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
//        }
//    }
//    private void noOperation() {
//        String inputExpression = t2.getText().toString();
//        if (!inputExpression.isEmpty() && !inputExpression.equals("Error")) {
//            if (inputExpression.contains("-")) {
//                inputExpression = inputExpression.replace("-", "");
//                t2.setText("");
//                val1 = Double.parseDouble(inputExpression);
//            }
//            if (inputExpression.contains("+")) {
//                inputExpression = inputExpression.replace("+", "");
//                t2.setText("");
//                val1 = Double.parseDouble(inputExpression);
//            }
//            if (inputExpression.contains("/")) {
//                inputExpression = inputExpression.replace("/", "");
//                t2.setText("");
//                val1 = Double.parseDouble(inputExpression);
//            }
//            if (inputExpression.contains("%")) {
//                inputExpression = inputExpression.replace("%", "");
//                t2.setText("");
//                val1 = Double.parseDouble(inputExpression);
//            }
//            if (inputExpression.contains("×")) {
//                inputExpression = inputExpression.replace("×", "");
//                t2.setText("");
//                val1 = Double.parseDouble(inputExpression);
//            }
//        }
//    }
//
//    // Whether value if a double or not
//    private boolean ifReallyDecimal() {
//        return val1 == (int) val1;
//    }
//
//    // Remove error message that is already written there.
//    private void ifErrorOnOutput() {
//        if (t2.getText().toString().equals("Error")) {
//            t2.setText("");
//        }
//    }
//
//    private void operation() {
//        if (!Double.isNaN(val1)) {
//
//
//            // Crash is here vibhu
////            if (value.isEmpty()) {
////                 Handle the empty string case here
////            } else {
////                char operator = value.charAt(0);
////                 Rest of your code that uses the operator
////            }
////
//
//            val2 = Double.parseDouble(t1.getText().toString());
//
//            switch (ACTION) {
//                case ADDITION:
//                    val1 = val1 + val2;
//                    break;
//                case SUBTRACTION:
//                    val1 = val1 - val2;
//                    break;
//                case MULTIPLICATION:
//                    val1 = val1 * val2;
//                    break;
//                case DIVISION:
//                    val1 = val1 / val2;
//                    break;
//                case EXTRA:
//                    val1 = (-1) * val1;
//                    break;
//                case MODULUS:
//                    val1 = val1 % val2;
//                    break;
//                case EQU:
//                    break;
//            }
//        } else {
//            val1 = Double.parseDouble(t1.getText().toString());
//        }
//    }

//    private void viewSetup() {
//
//
//        b1 = bottomSheetView.findViewById(R.id.button1);
//        b2 = bottomSheetView.findViewById(R.id.button2);
//        b3 = bottomSheetView.findViewById(R.id.button3);
//        b4 = bottomSheetView.findViewById(R.id.button4);
//        b5 = bottomSheetView.findViewById(R.id.button5);
//        b6 = bottomSheetView.findViewById(R.id.button6);
//        b7 = bottomSheetView.findViewById(R.id.button7);
//        b8 = bottomSheetView.findViewById(R.id.button8);
//        b9 = bottomSheetView.findViewById(R.id.button9);
//        b0 = bottomSheetView.findViewById(R.id.button0);
//        b_equal = bottomSheetView.findViewById(R.id.button_equal);
//        b_multi = bottomSheetView.findViewById(R.id.button_multi);
//        b_divide = bottomSheetView.findViewById(R.id.button_divide);
//        b_add = bottomSheetView.findViewById(R.id.button_add);
//        b_sub = bottomSheetView.findViewById(R.id.button_sub);
//        b_clear = bottomSheetView.findViewById(R.id.button_clear);
//        b_dot = bottomSheetView.findViewById(R.id.button_dot);
//        b_para1 = bottomSheetView.findViewById(R.id.button_para1);
//        b_para2 = bottomSheetView.findViewById(R.id.button_para2);
//        t1 = bottomSheetView.findViewById(R.id.input);
//        t2 = bottomSheetView.findViewById(R.id.output);
//    }



}





























// Calculator in double ok tested no bug
//package com.calculator.expensemanager;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//        import java.math.BigDecimal;
//
//public class Temp extends AppCompatActivity {
//
//    //    Button[] numericButtons;
//    Button btnClear, btnClearDisplay, btnNegative, btnDelete,
//            btnDivision, btnMultiplication, btnSubmission, btnSum, btnEqual, btnDot;
//
//    TextView tvDisplay, tvPhrase;
//
//    boolean isOperatorPressed = false;
//    boolean isEqualPressed = false;
//
//    double num1 = 0;
//    double num2 = 0;
//    char op = ' ';
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_temp);
//
//        findViews();
//        Button btn0 = findViewById(R.id.btn_0);
//        Button btn1 = findViewById(R.id.btn_1);
//        Button btn2 = findViewById(R.id.btn_2);
//        Button btn3 = findViewById(R.id.btn_3);
//        Button btn4 = findViewById(R.id.btn_4);
//        Button btn5 = findViewById(R.id.btn_5);
//        Button btn6 = findViewById(R.id.btn_6);
//        Button btn7 = findViewById(R.id.btn_7);
//        Button btn8 = findViewById(R.id.btn_8);
//        Button btn9 = findViewById(R.id.btn_9);
//
//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("0");
//            }
//        });
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("1");
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("2");
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("3");
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("4");
//            }
//        });
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("5");
//            }
//        });
//
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("6");
//            }
//        });
//
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("7");
//            }
//        });
//
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("8");
//            }
//        });
//
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("9");
//            }
//        });
//
//
//
//
//        btnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
//                num1 = 0;
//                num2 = 0;
//                op = ' ';
//                tvPhrase.setText("");
//                tvDisplay.setText("0");
//                isEqualPressed = false;
//                isOperatorPressed = false;
//            }
//        });
//
//        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvDisplay.setText("0");
//                isEqualPressed = false;
//                isOperatorPressed = false;
//            }
//        });
//
//        btnNegative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.contains("-")) {
//                    tvDisplayText = tvDisplayText.substring(1);
//                } else {
//                    tvDisplayText = "-" + tvDisplayText;
//                }
//                tvDisplay.setText(tvDisplayText);
//            }
//        });
//
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.length() > 0) {
//                    tvDisplayText = tvDisplayText.substring(0, tvDisplayText.length() - 1);
//                    if (tvDisplayText.length() == 0) {
//                        tvDisplayText = "0";
//                        isEqualPressed = false;
//                        isOperatorPressed = false;
//                    }
//                    tvDisplay.setText(tvDisplayText);
//                }
//            }
//        });
//
//        btnDivision.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//                if (op != '÷') {
//                    num1 = Double.parseDouble(tvDisplayText);
//                    String temp = tvDisplayText + " ÷ ";
//                    tvPhrase.setText(temp);
//                    op = '÷';
//                } else {
//                    num2 = Double.parseDouble(tvDisplayText);
//                    if (num1 == 0 || num2 == 0)
//                        return;
//                    num1 = calculate(num1, num2, op);
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
//                    } else {
//                        strNum1 = String.valueOf(num1);
//                    }
//
//                    String temp = strNum1 + " ÷ ";
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//
//            }
//        });
//
//        btnMultiplication.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//                if (op != 'x') {
//                    num1 = Double.parseDouble(tvDisplayText);
//                    String temp = tvDisplayText + " x ";
//                    tvPhrase.setText(temp);
//                    op = 'x';
//                } else {
//                    num2 = Double.parseDouble(tvDisplayText);
//                    num1 = calculate(num1, num2, op);
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
//                    } else {
//                        strNum1 = String.valueOf(num1);
//                    }
//
//                    String temp = strNum1 + " x ";
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//            }
//        });
//
//
//
//
//        btnSubmission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//
//
//                if (op != '-') {
//
//                    num1 = Double.parseDouble(tvDisplayText);
//                    String temp = tvDisplayText + " - ";
//                    tvPhrase.setText(temp);
//                    op = '-';
//
//
//                } else {
//
//                    num2 = Double.parseDouble(tvDisplayText);
//                    num1 = calculate(num1, num2, op);
//
//
//
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//
//
//                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
//
//                    } else {
//                        strNum1 = String.valueOf(num1);
//                    }
//
//
//
//                    String temp = strNum1 + " - ";
//
//
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//            }
//        });
//
//        btnSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//
//                if (op != '+') {
//                    num1 = Double.parseDouble(tvDisplayText);
//                    String temp = tvDisplayText + " + ";
//                    tvPhrase.setText(temp);
//                    op = '+';
//                } else {
//                    num2 = Double.parseDouble(tvDisplayText);
//                    num1 = calculate(num1, num2, op);
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
//                    } else {
//                        strNum1 = String.valueOf(num1);
//                    }
//
//                    String temp = strNum1 + " + ";
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//
//            }
//
//        });
//
//        btnEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (op != ' ') {
//                    isEqualPressed = true;
//                    isOperatorPressed = false;
//                    num2 = Double.parseDouble(tvDisplayText);
//
//
//                    double res = calculate(num1, num2, op);
//
////                    String strNum1 = "";
////                    if (isInteger(num1)) {
////                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
////                    } else {
////                        strNum1 = String.valueOf(num1);
////                    }
//
//                    String strNum1;
//                    if (Double.isInfinite(num1)) {
//                        strNum1 = "Infinity";
//                    } else {
//                        if (isInteger(num1)) {
//                            strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
//                        } else {
//                            strNum1 = String.valueOf(num1);
//                        }
//                    }
//
//
////                    String strNum2 = "";
////                    if (isInteger(num2)) {
////                        strNum2 = String.valueOf(num2).substring(0, String.valueOf(num2).indexOf("."));
////                    } else {
////                        strNum2 = String.valueOf(num2);
////                    }
//                    String strNum2;
//                    if (Double.isInfinite(num2)) {
//                        strNum2 = "Infinity";
//                    } else {
//                        if (isInteger(num2)) {
//                            strNum2 = String.valueOf(num2).substring(0, String.valueOf(num2).indexOf("."));
//                        } else {
//                            strNum2 = String.valueOf(num2);
//                        }
//                    }
//
//
////                    String strRes = "";
////                    if (isInteger(res)) {
////                        strRes = String.valueOf(res).substring(0, String.valueOf(res).indexOf("."));
////                    } else {
////                        strRes = String.valueOf(res);
////                    }
//
//                    String strRes = "";
//                    if (Double.isInfinite(res)) {
//                        strRes = "Infinity";
//                    } else if (Double.isNaN(res)) {
//                        strRes = "NaN";
//                    } else {
//                        if (isInteger(res)) {
//                            strRes = String.valueOf(res).substring(0, String.valueOf(res).indexOf("."));
//                        } else {
//                            strRes = String.valueOf(res);
//                        }
//                    }
//
//
//                    tvDisplay.setText(strRes);
//                    String temp = strNum1 + " " + op + " " + strNum2 + " = ";
//                    tvPhrase.setText(temp);
//                    op = ' ';
//                    num1 = 0;
//                    num2 = 0;
//                }
//
//            }
//        });
//
//        btnDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//
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
//
//    }
//
//    private boolean isInteger(double num) {
//        return Math.ceil(num) == Math.floor(num);
//    }
//
//    private double calculate(double num1, double num2, char op) {
//        switch (op) {
//            case '+':
//                return num1 + num2;
//            case '-':
//                return num1 - num2;
//            case 'x':
//                return num1 * num2;
//            case '÷':
//                return num1 / num2;
//            default:
//                return 0;
//        }
//    }
//
//    private void findViews() {
//        btnClear = findViewById(R.id.btn_clear);
//        btnClearDisplay = findViewById(R.id.btn_clear_display);
//        btnNegative = findViewById(R.id.btn_negative);
//        btnDelete = findViewById(R.id.btn_delete);
//        btnDivision = findViewById(R.id.btn_division);
//        btnMultiplication = findViewById(R.id.btn_multiplication);
//        btnSubmission = findViewById(R.id.btn_submission);
//        btnSum = findViewById(R.id.btn_sum);
//        btnEqual = findViewById(R.id.btn_equal);
//        btnDot = findViewById(R.id.btn_dot);
//        tvDisplay = findViewById(R.id.tv_display);
//        tvPhrase = findViewById(R.id.tv_phrase);
//    }
//
//
//
//
//
//    // Function to handle the click event for numeric buttons
//    private void handleNumericButtonClick(String value) {
//        if (isOperatorPressed) {
//
//
//            if( !tvDisplay.getText().toString().equals("0.")){
//                tvDisplay.setText("");
//
//            }
//
//
//            isOperatorPressed = false;
//        }
//
//        if (isEqualPressed) {
//
//
//            if(!tvDisplay.getText().toString().equals("0.")){
//
//                Toast.makeText(this, "i did", Toast.LENGTH_SHORT).show();
//                tvDisplay.setText("");
//            }
//
//            tvPhrase.setText("");
//            isEqualPressed = false;
//        }
//
//        String tvDisplayText = tvDisplay.getText().toString();
//
//        if (tvDisplayText.equals("0")) {
//            tvDisplayText = "";
//
//        }
//
//        tvDisplayText += value;
//        tvDisplay.setText(tvDisplayText);
//    }
//
//
//}// end of MainActivity class












































//
//
//package com.calculator.expensemanager;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//        import java.math.BigDecimal;
//        import java.math.RoundingMode;
//        import java.util.Objects;
//
//public class Temp extends AppCompatActivity {
//
//    //    Button[] numericButtons;
//    Button btnClear, btnClearDisplay, btnNegative, btnDelete,
//            btnDivision, btnMultiplication, btnSubmission, btnSum, btnEqual, btnDot;
//
//    TextView tvDisplay, tvPhrase;
//
//    boolean isOperatorPressed = false;
//    boolean isEqualPressed = false;
//
//    //    double num1 = 0;
//    BigDecimal num1 = BigDecimal.ZERO;
//    //    double num2 = 0;
//    BigDecimal num2 = BigDecimal.ZERO;
//    char op = ' ';
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_temp);
//
//        findViews();
//        Button btn0 = findViewById(R.id.btn_0);
//        Button btn1 = findViewById(R.id.btn_1);
//        Button btn2 = findViewById(R.id.btn_2);
//        Button btn3 = findViewById(R.id.btn_3);
//        Button btn4 = findViewById(R.id.btn_4);
//        Button btn5 = findViewById(R.id.btn_5);
//        Button btn6 = findViewById(R.id.btn_6);
//        Button btn7 = findViewById(R.id.btn_7);
//        Button btn8 = findViewById(R.id.btn_8);
//        Button btn9 = findViewById(R.id.btn_9);
//
//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("0");
//            }
//        });
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("1");
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("2");
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("3");
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("4");
//            }
//        });
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("5");
//            }
//        });
//
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("6");
//            }
//        });
//
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("7");
//            }
//        });
//
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("8");
//            }
//        });
//
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("9");
//            }
//        });
//
//
//
//
//        btnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
////                num1 = 0;
////                num2 = 0;
//                num1 = BigDecimal.ZERO;
//                num2 = BigDecimal.ZERO;
//                op = ' ';
//                tvPhrase.setText("");
//                tvDisplay.setText("0");
//                isEqualPressed = false;
//                isOperatorPressed = false;
//            }
//        });
//
//        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvDisplay.setText("0");
//                isEqualPressed = false;
//                isOperatorPressed = false;
//            }
//        });
//
//        btnNegative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.contains("-")) {
//                    tvDisplayText = tvDisplayText.substring(1);
//                } else {
//                    tvDisplayText = "-" + tvDisplayText;
//                }
//                tvDisplay.setText(tvDisplayText);
//            }
//        });
//
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.length() > 0) {
//                    tvDisplayText = tvDisplayText.substring(0, tvDisplayText.length() - 1);
//                    if (tvDisplayText.length() == 0) {
//                        tvDisplayText = "0";
//                        isEqualPressed = false;
//                        isOperatorPressed = false;
//                    }
//                    tvDisplay.setText(tvDisplayText);
//                }
//            }
//        });
//
//        btnDivision.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//                if (op != '÷') {
////                    num1 = Double.parseDouble(tvDisplayText);
//                    num1 = new BigDecimal(tvDisplayText);
//                    String temp = tvDisplayText + " ÷ ";
//                    tvPhrase.setText(temp);
//                    op = '÷';
//                } else {
////                    num2 = Double.parseDouble(tvDisplayText);
//                    num2 = new BigDecimal(tvDisplayText);
//                    if (Objects.equals(num1, BigDecimal.ZERO) || num2.equals(BigDecimal.ZERO))
//                        return;
//                    num1 = calculate(num1, num2, op);
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = num1.toBigInteger().toString();
//                    } else {
//                        strNum1 = num1.toPlainString();
//                    }
//
//                    String temp = strNum1 + " ÷ ";
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//
//            }
//        });
//
//        btnMultiplication.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//                if (op != 'x') {
////                    num1 = Double.parseDouble(tvDisplayText);
//                    num1 = new BigDecimal(tvDisplayText);
//                    String temp = tvDisplayText + " x ";
//                    tvPhrase.setText(temp);
//                    op = 'x';
//                } else {
////                    num2 = Double.parseDouble(tvDisplayText);
//                    num2 = new BigDecimal(tvDisplayText);
//                    num1 = calculate(num1, num2, op);
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = num1.toBigInteger().toString();
//                    } else {
//                        strNum1 = num1.toPlainString();
//                    }
//
//
//                    String temp = strNum1 + " x ";
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//            }
//        });
//
//
//
//
//        btnSubmission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//
//
//                if (op != '-') {
//
////                    num1 = Double.parseDouble(tvDisplayText);
////                    num1 = new BigDecimal(tvDisplayText);
////                    String temp = tvDisplayText + " - ";
////                    tvPhrase.setText(temp);
////                    op = '-';
//
//
//                    try {
//                        num1 = new BigDecimal(tvDisplayText);
//                        String temp = tvDisplayText + " - ";
//                        tvPhrase.setText(temp);
//                        op = '-';
//                    } catch (NumberFormatException e) {
//                        // Handle the case where tvDisplayText is not a valid number
//                        // Display an error message or perform appropriate error handling
//                        e.printStackTrace();
//                    }
//
//
//
//                } else {
//
////                    num2 = Double.parseDouble(tvDisplayText);
//                    try {
//                        num2 = new BigDecimal(tvDisplayText);
//                        num1 = calculate(num1, num2, op);
//                    } catch (NumberFormatException e) {
//                        // Handle the case where tvDisplayText is not a valid number
//                        // Display an error message or perform appropriate error handling
//                        e.printStackTrace();
////                        Toast.makeText(Temp.this, "i am crashed", Toast.LENGTH_SHORT).show();
//                    }
//
//
//
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = num1.toBigInteger().toString();
//                    } else {
//                        strNum1 = num1.toPlainString();
//                    }
//
//
//
//
//                    String temp = strNum1 + " - ";
//
//
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//            }
//        });
//
//        btnSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = true;
//                String tvDisplayText = tvDisplay.getText().toString();
//
//                if (isEqualPressed) {
//                    tvPhrase.setText("");
//                    isEqualPressed = false;
//                }
//
//
//                if (op != '+') {
////                    num1 = Double.parseDouble(tvDisplayText);
//                    num1 = new BigDecimal(tvDisplayText);
//                    String temp = tvDisplayText + " + ";
//                    tvPhrase.setText(temp);
//                    op = '+';
//                } else {
////                    num2 = Double.parseDouble(tvDisplayText);
//                    num2 = new BigDecimal(tvDisplayText);
//                    num1 = calculate(num1, num2, op);
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = num1.toBigInteger().toString();
//                    } else {
//                        strNum1 = num1.toPlainString();
//                    }
//
//
//                    String temp = strNum1 + " + ";
//                    tvPhrase.setText(temp);
//
//                    tvDisplay.setText(strNum1);
//                }
//
//            }
//
//        });
//
//        btnEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (op != ' ') {
//                    isEqualPressed = true;
//                    isOperatorPressed = false;
////                    num2 = Double.parseDouble(tvDisplayText);
//                    num2 = new BigDecimal(tvDisplayText);
//
//
////                    double res = calculate(num1, num2, op);
//                    BigDecimal res = calculate(num1,num2,op);
//
//                    String strNum1 = "";
//                    if (isInteger(num1)) {
//                        strNum1 = num1.toBigInteger().toString();
//                    } else {
//                        strNum1 = num1.toPlainString();
//                    }
//
//
////                    String strNum1;
////                    if (Double.isInfinite(num1)) {
////                        strNum1 = "Infinity";
////                    } else {
////                        if (isInteger(num1)) {
////                            strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
////                        } else {
////                            strNum1 = String.valueOf(num1);
////                        }
////                    }
//
//
//                    String strNum2 = "";
//                    if (isInteger(num2)) {
//                        strNum2 = num2.toBigInteger().toString();
//                    } else {
//                        strNum2 = num2.toPlainString();
//                    }
//
////                    String strNum2;
////                    if (Double.isInfinite(num2)) {
////                        strNum2 = "Infinity";
////                    } else {
////                        if (isInteger(num2)) {
////                            strNum2 = String.valueOf(num2).substring(0, String.valueOf(num2).indexOf("."));
////                        } else {
////                            strNum2 = String.valueOf(num2);
////                        }
////                    }
//
//
//                    String strRes = "";
//                    if (isInteger(res)) {
//                        strRes = res.toBigInteger().toString();
//                    } else {
//                        strRes = res.toPlainString();
//                    }
//
//
////                    String strRes = "";
////                    if (Double.isInfinite(res)) {
////                        strRes = "Infinity";
////                    } else if (Double.isNaN(res)) {
////                        strRes = "NaN";
////                    } else {
////                        if (isInteger(res)) {
////                            strRes = String.valueOf(res).substring(0, String.valueOf(res).indexOf("."));
////                        } else {
////                            strRes = String.valueOf(res);
////                        }
////                    }
//
//
//                    tvDisplay.setText(strRes);
//                    String temp = strNum1 + " " + op + " " + strNum2 + " = ";
//                    tvPhrase.setText(temp);
//                    op = ' ';
////                    num1 = 0;
//                    num1 = BigDecimal.ZERO;
////                    num2 = 0;
//                    num2 = BigDecimal.ZERO;
//                }
//
//            }
//        });
//
//        btnDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//
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
//
//    }
//
//    private boolean isInteger(BigDecimal num) {
//        return num.stripTrailingZeros().scale() <= 0;
//    }
//
//
//    private BigDecimal calculate(BigDecimal num1, BigDecimal num2, char op) {
//        switch (op) {
//            case '+':
//                return num1.add(num2);
//            case '-':
//                return num1.subtract(num2);
//            case 'x':
//                return num1.multiply(num2);
//            case '÷':
//                if (num2.compareTo(BigDecimal.ZERO) != 0) {
//                    return num1.divide(num2, 2, RoundingMode.HALF_UP);
//                } else {
//                    return BigDecimal.ZERO;
//                }
//            default:
//                return BigDecimal.ZERO;
//        }
//    }
//
//
//    private void findViews() {
//        btnClear = findViewById(R.id.btn_clear);
//        btnClearDisplay = findViewById(R.id.btn_clear_display);
//        btnNegative = findViewById(R.id.btn_negative);
//        btnDelete = findViewById(R.id.btn_delete);
//        btnDivision = findViewById(R.id.btn_division);
//        btnMultiplication = findViewById(R.id.btn_multiplication);
//        btnSubmission = findViewById(R.id.btn_submission);
//        btnSum = findViewById(R.id.btn_sum);
//        btnEqual = findViewById(R.id.btn_equal);
//        btnDot = findViewById(R.id.btn_dot);
//        tvDisplay = findViewById(R.id.tv_display);
//        tvPhrase = findViewById(R.id.tv_phrase);
//    }
//
//
//
//
//
//    // Function to handle the click event for numeric buttons
//    private void handleNumericButtonClick(String value) {
//        if (isOperatorPressed) {
//
//
//            if( !tvDisplay.getText().toString().equals("0.")){
//                tvDisplay.setText("");
//
//            }
//
//
//            isOperatorPressed = false;
//        }
//
//        if (isEqualPressed) {
//
//
//            if(!tvDisplay.getText().toString().equals("0.")){
//
//                tvDisplay.setText("");
//            }
//
//            tvPhrase.setText("");
//            isEqualPressed = false;
//        }
//
//        String tvDisplayText = tvDisplay.getText().toString();
//
//        if (tvDisplayText.equals("0")) {
//            tvDisplayText = "";
//
//        }
//
//        tvDisplayText += value;
//        tvDisplay.setText(tvDisplayText);
//    }
//
//
//}











































//
//
//
//
//
//package com.calculator.expensemanager;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.os.Bundle;
//        import android.os.Handler;
//        import android.text.TextUtils;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//        import java.math.BigDecimal;
//        import java.math.RoundingMode;
//
//public class Temp extends AppCompatActivity {
//
//    //    Button[] numericButtons;
//    Button btnClear, btnClearDisplay, btnNegative, btnDelete,
//            btnDivision, btnMultiplication, btnSubmission, btnSum, btnEqual, btnDot;
//    String tempNew = "";
//
//    boolean isBtn0Pressed = false;
//    BigDecimal tempNumber;
////    BigDecimal tempNumberDivide;
//
//    //    BigDecimal tempResult = BigDecimal.ZERO;
//    TextView tvDisplay, tvPhrase;
//
//    boolean isOperatorPressed = false;
//
//    boolean isAdditionPressed = false;
//    boolean isSubtractionPressed = false;
//    boolean isMultiplicationPressed = false;
//    boolean isDivisionPressed = false;
//    boolean isEqualPressed = false;
//
//    //    double num1 = 0;
//    BigDecimal num1 = BigDecimal.ZERO;
//    //    double num2 = 0;
//    BigDecimal num2 = BigDecimal.ZERO;
//    char op = ' ';
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_temp);
//
//        findViews();
//        Button btn0 = findViewById(R.id.btn_0);
//        Button btn1 = findViewById(R.id.btn_1);
//        Button btn2 = findViewById(R.id.btn_2);
//        Button btn3 = findViewById(R.id.btn_3);
//        Button btn4 = findViewById(R.id.btn_4);
//        Button btn5 = findViewById(R.id.btn_5);
//        Button btn6 = findViewById(R.id.btn_6);
//        Button btn7 = findViewById(R.id.btn_7);
//        Button btn8 = findViewById(R.id.btn_8);
//        Button btn9 = findViewById(R.id.btn_9);
//
//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("0");
//                isBtn0Pressed = true;
//            }
//        });
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("1");
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("2");
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("3");
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("4");
//            }
//        });
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("5");
//            }
//        });
//
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("6");
//            }
//        });
//
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("7");
//            }
//        });
//
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("8");
//            }
//        });
//
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("9");
//            }
//        });
//
//
//
//
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
////        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                tvDisplay.setText("0");
////
////                String tvPhraseText = tvPhrase.getText().toString();
////                boolean containsOperator = false;
////                if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
////                    // tvPhrase contains an operator
////                    // Perform your desired action here
////                    containsOperator = true;
////                }
////
////
////
////
////                if(isEqualPressed || !containsOperator){
////
////
////                    btnClear.performClick();
////                    return;
////
////                }
////
////
////
////                isEqualPressed = false;
////                isOperatorPressed = false;
////
//////                String tvPhraseText = tvPhrase.getText().toString();
////
////                // Example value of tvPhrase
////                String newNumber = " 0";  // New number to replace the last number
////
////                // Find the index of the last operator
////                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
////
////                if (lastOperatorIndex != -1) {
////                    // Get the substring after the last operator
////                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1);
////
////                    // Replace the last number with the new number
////                    tvPhraseText = tvPhraseText.replace(lastNumber, newNumber);
////                }
////
////                // Assuming you have a TextView or any other view to display the tvPhrase
////                tvPhrase.setText(tvPhraseText);
////            }
////        });
//
//        //
////        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                tvDisplay.setText("0");
////
////                String tvPhraseText = tvPhrase.getText().toString();
////                 Find the index of the last operator
////                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
////
////                if (lastOperatorIndex != -1) {
////                     Get the substring after the last operator
////                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1).trim();
////
////                    Toast.makeText(Temp.this, lastNumber, Toast.LENGTH_SHORT).show();
////
////
////                    tvPhraseText = tvPhraseText.replace(lastNumber,"0");
////                    tvPhrase.setText(tvPhraseText);
////
////                     Use the lastNumber as needed
////                }
////
////
////
////                isEqualPressed = false;
////                isOperatorPressed = false;
////            }
////        });
////
//        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvDisplay.setText("0");
//
//                String tvPhraseText = tvPhrase.getText().toString();
//                boolean containsOperator = false;
//
//                if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
//                    // tvPhrase contains an operator
//                    // Perform your desired action here
//                    containsOperator = true;
//                }
//
//                if (isEqualPressed || !containsOperator) {
//                    btnClear.performClick();
//                    return;
//                }
//
//                isEqualPressed = false;
//                isOperatorPressed = false;
//
//                // Example value of tvPhrase
//                String newNumber = " 0";  // New number to replace the last number
//
//                // Find the index of the last operator
//                int lastOperatorIndex = Math.max(Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-")),
//                        Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷")));
//
//                if (lastOperatorIndex != -1) {
//                    // Get the substring after the last operator
//                    String afterOperator = tvPhraseText.substring(lastOperatorIndex + 1).trim();
//
//                    // Check if the substring is a number or starts with "0."
//                    if (!afterOperator.isEmpty() && (afterOperator.matches("-?\\d+(\\.\\d+)?") || afterOperator.startsWith("0."))) {
//                        // Replace the last number with the new number
//                        tvPhraseText = tvPhraseText.substring(0, lastOperatorIndex + 1) + newNumber;
//                    }
//                }
//
//                // Assuming you have a TextView or any other view to display the tvPhrase
//                tvPhrase.setText(tvPhraseText);
//            }
//        });
//
//        btnNegative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.contains("-")) {
//                    tvDisplayText = tvDisplayText.substring(1);
//                } else {
//                    tvDisplayText = "-" + tvDisplayText;
//                }
//                tvDisplay.setText(tvDisplayText);
//            }
//        });
//
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.length() > 0) {
//                    tvDisplayText = tvDisplayText.substring(0, tvDisplayText.length() - 1);
//                    if (tvDisplayText.length() == 0) {
//                        tvDisplayText = "0";
//                        isEqualPressed = false;
//                        isOperatorPressed = false;
//                    }
//                    tvDisplay.setText(tvDisplayText);
//                }
//            }
//        });
//
//        btnDivision.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isDivisionPressed){
////                    return;
////                }
////
////                isDivisionPressed = true;
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " ÷ ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//                    op = '÷';
//                    tempNew += tvDisplayText + " ÷ ";
//                    tvPhrase.setText(tempNew);
//                    tvDisplay.setText("");
//
//                }
//
//                op = '÷';
//            }
//        });
//
//        btnMultiplication.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " x ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//
//
////                    if (isMultiplicationPressed) {
////                        return;
////                    }
////
////                    isMultiplicationPressed = true;
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//
//                    tempNew += tvDisplayText + " x ";
//                    tvPhrase.setText(tempNew);
//                    tvDisplay.setText("");
//
//
//
//                }
//                op = 'x';
//            }
//        });
//
//
//
//
//        btnSubmission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isSubtractionPressed){
////                    return;
////                }
////                isSubtractionPressed = true;
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " - ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//
//                    tempNew += tvDisplayText + " - ";
//                    tvPhrase.setText(tempNew);
//                    tvDisplay.setText("");
//
//                }
//
//                op = '-';
//
//            }
//        });
//
//        btnSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isAdditionPressed){
////                    return;
////                }
////
////                isAdditionPressed = true;
//
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " + ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//                    op = '+';
//                    tempNew += tvDisplayText + " + ";
//                    tvPhrase.setText(tempNew);
//                    tvDisplay.setText("");
//
//                }
//
//
//                op = '+';
//
//
//            }
//        });
//
//        btnEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (!tvDisplayText.isEmpty() && op != ' ') {
//                    isEqualPressed = true;
//                    isOperatorPressed = false;
//
//                    isAdditionPressed = false;
//                    isSubtractionPressed = false;
//                    isDivisionPressed = false;
//                    isMultiplicationPressed = false;
//                    num2 = new BigDecimal(tvDisplayText);
//
//                    BigDecimal res = calculate(num1, num2, op);
//
//                    String strRes;
//                    if (res.scale() > 0) {
//                        strRes = res.stripTrailingZeros().toPlainString();
//                    } else {
//                        strRes = res.toBigInteger().toString();
//                    }
//
//                    tvDisplay.setText(strRes);
//                    String temp = tvPhrase.getText().toString() + " = ";
//                    tvPhrase.setText(temp);
//                    op = ' ';
//                    num1 = BigDecimal.ZERO;
//                    num2 = BigDecimal.ZERO;
//                    tempNew = "";
//                    tempNumber = BigDecimal.ZERO;
//                }
//            }
//        });
//
////        btnDot.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                String tvDisplayText = tvDisplay.getText().toString();
////                if (tvDisplayText.isEmpty() || tvDisplayText.contains(".")) {
////
////
////                    if(isEqualPressed || isOperatorPressed){
////
////                        tvDisplayText = "0.";
////                        tvDisplay.setText(tvDisplayText);
////
////                    }
////
////                    return;
////                }
////
////
////                if(isEqualPressed || isOperatorPressed){
////
////                    tvDisplayText = "0.";
////                    tvDisplay.setText(tvDisplayText);
////
////                } else {
////                    tvDisplayText += '.';
////                    tvDisplay.setText(tvDisplayText);
////
////                }
////
////                if(isEqualPressed){
////                    tvPhrase.setText("");
////                    isEqualPressed =false;
////                }
////
////            }
////        });
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
//
//                if(tvDisplayText.equals("0") || tvDisplayText.isEmpty() || isEqualPressed){
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
//                        // Code to be executed after the delay
//                        // Place your desired logic or actions here
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
//                }, 10); // 10000 milliseconds = 10 seconds
//
//
//
//
//            }
//        });
//
//    }
//
//    private boolean isInteger(BigDecimal num) {
//        return num.stripTrailingZeros().scale() <= 0;
//    }
//
//
//    private BigDecimal calculate(BigDecimal num1, BigDecimal num2, char op) {
//        switch (op) {
//            case '+':
//                return num1.add(num2);
//            case '-':
//                return num1.subtract(num2);
//            case 'x':
//                return num1.multiply(num2);
//            case '÷':
//                if (num2.compareTo(BigDecimal.ZERO) != 0) {
//                    return num1.divide(num2, 2, RoundingMode.HALF_UP);
//                } else {
//                    return BigDecimal.ZERO;
//                }
//            default:
//                return BigDecimal.ZERO;
//        }
//    }
//
//
//    private void findViews() {
//        btnClear = findViewById(R.id.btn_clear);
//        btnClearDisplay = findViewById(R.id.btn_clear_display);
//        btnNegative = findViewById(R.id.btn_negative);
//        btnDelete = findViewById(R.id.btn_delete);
//        btnDivision = findViewById(R.id.btn_division);
//        btnMultiplication = findViewById(R.id.btn_multiplication);
//        btnSubmission = findViewById(R.id.btn_submission);
//        btnSum = findViewById(R.id.btn_sum);
//        btnEqual = findViewById(R.id.btn_equal);
//        btnDot = findViewById(R.id.btn_dot);
//        tvDisplay = findViewById(R.id.tv_display);
//        tvPhrase = findViewById(R.id.tv_phrase);
//    }
//
//
//
//
//
//    // Function to handle the click event for numeric buttons
//    private void handleNumericButtonClick(String value) {
//
//
//        if (isEqualPressed) {
//
//
////            if(!tvDisplay.getText().toString().equals("0.")){
//
//            tvDisplay.setText("");
////            }
//
//
//
//            if(!isOperatorPressed){
//                tvPhrase.setText("");
//                Toast.makeText(this, "equal was pressed", Toast.LENGTH_SHORT).show();
//
//            }
//
//
//
//            isEqualPressed = false;
//        }
//
//
//        if (isOperatorPressed) {
//
//
////            if( !tvDisplay.getText().toString().equals("0.")){
//            tvDisplay.setText("");
//
////            }
//
//
//            isOperatorPressed = false;
//        }
//
//        String tvDisplayText = tvDisplay.getText().toString();
//        String tvPhraseText = tvPhrase.getText().toString();
//
//        if (tvDisplayText.equals("0")) {
//            tvDisplayText = "";
//
//        }
//
//        tvDisplayText += value;
//        tvDisplay.setText(tvDisplayText);
//        tvPhraseText += value;
//        tvPhrase.setText(tvPhraseText);
//        isBtn0Pressed = false;
//    }
//
//
//}



































































































//package com.calculator.expensemanager;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
////import net.objecthunter.exp4j.Expression;
////import net.objecthunter.exp4j.ExpressionBuilder;
////import net.objecthunter.exp4j.ValidationResult;
//
//import net.objecthunter.exp4j.Expression;
//import net.objecthunter.exp4j.ExpressionBuilder;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.List;
//import java.util.Stack;
//
////import javax.el.Expression;
////import javax.script.ScriptEngine;
////import javax.script.ScriptEngineManager;
////import javax.script.ScriptException;
//
//public class Temp extends AppCompatActivity {
//
//    //    Button[] numericButtons;
//    Button btnClear, btnClearDisplay, btnNegative, btnDelete,
//            btnDivision, btnMultiplication, btnSubmission, btnSum, btnEqual, btnDot;
//    String tempNew = "";
//
//    boolean isBtn0Pressed = false;
//    BigDecimal tempNumber;
//    boolean cPressed = false;
////    BigDecimal tempNumberDivide;
//
//    //    BigDecimal tempResult = BigDecimal.ZERO;
//    TextView tvDisplay, tvPhrase;
//
//    boolean isOperatorPressed = false;
//
//    boolean isAdditionPressed = false;
//    boolean isSubtractionPressed = false;
//    boolean isMultiplicationPressed = false;
//    boolean isDivisionPressed = false;
//    boolean isEqualPressed = false;
//
//    //    double num1 = 0;
//    BigDecimal num1 = BigDecimal.ZERO;
//    //    double num2 = 0;
//    BigDecimal num2 = BigDecimal.ZERO;
//    char op = ' ';
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_temp);
//
//        findViews();
//        Button btn0 = findViewById(R.id.btn_0);
//        Button btn1 = findViewById(R.id.btn_1);
//        Button btn2 = findViewById(R.id.btn_2);
//        Button btn3 = findViewById(R.id.btn_3);
//        Button btn4 = findViewById(R.id.btn_4);
//        Button btn5 = findViewById(R.id.btn_5);
//        Button btn6 = findViewById(R.id.btn_6);
//        Button btn7 = findViewById(R.id.btn_7);
//        Button btn8 = findViewById(R.id.btn_8);
//        Button btn9 = findViewById(R.id.btn_9);
//
//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("0");
//                isBtn0Pressed = true;
//            }
//        });
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("1");
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("2");
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("3");
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("4");
//            }
//        });
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("5");
//            }
//        });
//
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("6");
//            }
//        });
//
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("7");
//            }
//        });
//
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("8");
//            }
//        });
//
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("9");
//            }
//        });
//
//
//
//
////        btnClear.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                isOperatorPressed = false;
//////                num1 = 0;
//////                num2 = 0;
////                num1 = BigDecimal.ZERO;
////                num2 = BigDecimal.ZERO;
//////                tempNumberDivide = BigDecimal.ZERO;
////                tempNumber = BigDecimal.ZERO;
////                tempNew = "";
////                op = ' ';
////                tvPhrase.setText("");
////                tvDisplay.setText("0");
////                isEqualPressed = false;
////                isOperatorPressed = false;
////                isAdditionPressed = false;
////                isSubtractionPressed = false;
////                isDivisionPressed = false;
////                isMultiplicationPressed = false;
////                isBtn0Pressed = false;
////            }
////        });
//////
////        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                tvDisplay.setText("0");
////
////                String tvPhraseText = tvPhrase.getText().toString();
////                boolean containsOperator = false;
////                if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
////                    // tvPhrase contains an operator
////                    // Perform your desired action here
////                    containsOperator = true;
////                }
////
////
////
////
////                if(isEqualPressed || !containsOperator){
////
////
////                    btnClear.performClick();
////                    return;
////
////                }
////
////
////
////                isEqualPressed = false;
////                isOperatorPressed = false;
////
//////                String tvPhraseText = tvPhrase.getText().toString();
////
////                // Example value of tvPhrase
////                String newNumber = " 0";  // New number to replace the last number
////
////                // Find the index of the last operator
////                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
////
////                if (lastOperatorIndex != -1) {
////                    // Get the substring after the last operator
////                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1);
////
////                    // Replace the last number with the new number
////                    tvPhraseText = tvPhraseText.replace(lastNumber, newNumber);
////                }
////
////                // Assuming you have a TextView or any other view to display the tvPhrase
////                tvPhrase.setText(tvPhraseText);
////            }
////        });
//
//        //
////        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                tvDisplay.setText("0");
////
////                String tvPhraseText = tvPhrase.getText().toString();
////                 Find the index of the last operator
////                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
////
////                if (lastOperatorIndex != -1) {
////                     Get the substring after the last operator
////                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1).trim();
////
////                    Toast.makeText(Temp.this, lastNumber, Toast.LENGTH_SHORT).show();
////
////
////                    tvPhraseText = tvPhraseText.replace(lastNumber,"0");
////                    tvPhrase.setText(tvPhraseText);
////
////                     Use the lastNumber as needed
////                }
////
////
////
////                isEqualPressed = false;
////                isOperatorPressed = false;
////            }
////        });
////
//        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvDisplay.setText("0");
//
//                btnClearDisplay.setText("AC");
//
//
//
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//                boolean containsOperator = tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷");
//
//                // tvPhrase contains an operator
//                // Perform your desired action here
//
//
//
//
//                if (isEqualPressed || !containsOperator) {
//                        clearScreen();
//                        return;
//
//                }
//
//
//                if(cPressed){
//
//
//                    clearScreen();
//                    return;
//
//
//                }
//
//
//
//
////                isOperatorPressed = false;
//
//                // Example value of tvPhrase
//                String newNumber = " ";  // New number to replace the last number
//
//                // Find the index of the last operator
//                int lastOperatorIndex = Math.max(Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-")),
//                        Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷")));
//
//                if (lastOperatorIndex != -1) {
//                    // Get the substring after the last operator
//                    String afterOperator = tvPhraseText.substring(lastOperatorIndex + 1).trim();
//
//                    // Check if the substring is a number or starts with "0."
//                    if (!afterOperator.isEmpty() && (afterOperator.matches("-?\\d+(\\.\\d+)?") || afterOperator.startsWith("0."))) {
//                        // Replace the last number with the new number
//                        tvPhraseText = tvPhraseText.substring(0, lastOperatorIndex + 1) + newNumber;
//                    }
//                    cPressed = true;
//                }
//
//                // Assuming you have a TextView or any other view to display the tvPhrase
//                tvPhrase.setText(tvPhraseText);
//            }
//        });
//
////        btnNegative.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String tvDisplayText = tvDisplay.getText().toString();
////                if (tvDisplayText.contains("-")) {
////                    tvDisplayText = tvDisplayText.substring(1);
////                } else {
////                    tvDisplayText = "-" + tvDisplayText;
////                }
////                tvDisplay.setText(tvDisplayText);
////            }
////        });
//
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.length() > 0) {
//                    tvDisplayText = tvDisplayText.substring(0, tvDisplayText.length() - 1);
//                    if (tvDisplayText.length() == 0) {
//                        tvDisplayText = "0";
//                        isEqualPressed = false;
//                        isOperatorPressed = false;
//                    }
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
//                }
//            }
//        });
//
//        btnDivision.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isDivisionPressed){
////                    return;
////                }
////
////                isDivisionPressed = true;
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " ÷ ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//                    op = '÷';
//                    tempNew += tvDisplayText + " ÷ ";
//                    tvPhrase.setText(tempNew);
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
//
//                }
//
//                op = '÷';
//            }
//        });
//
//        btnMultiplication.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " x ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//
//
////                    if (isMultiplicationPressed) {
////                        return;
////                    }
////
////                    isMultiplicationPressed = true;
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//
//                    tempNew += tvDisplayText + " x ";
//                    tvPhrase.setText(tempNew);
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
//
//
//                }
//                op = 'x';
//            }
//        });
//
//
//
//
//        btnSubmission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isSubtractionPressed){
////                    return;
////                }
////                isSubtractionPressed = true;
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " - ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//
//                    tempNew += tvDisplayText + " - ";
//                    tvPhrase.setText(tempNew);
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
//
//                }
//
//                op = '-';
//
//            }
//        });
//
//        btnSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isAdditionPressed){
////                    return;
////                }
////
////                isAdditionPressed = true;
//
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " + ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        num2 = new BigDecimal(tvDisplayText);
//                        tempNumber = calculate(tempNumber, num2, op);
//                        num1 = tempNumber;
//                    } else {
//                        num1 = new BigDecimal(tvDisplayText);
//                        tempNumber = num1;
//                    }
//
//                    op = '+';
//                    tempNew += tvDisplayText + " + ";
//                    tvPhrase.setText(tempNew);
////                    tvDisplay.setText(String.valueOf(tempNumber));
//
//
//
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
//
//
//
//                }
//
//
//                op = '+';
//
//
//            }
//        });
//
//        btnEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (!isOperatorPressed && op != ' ') {
//
//
//                    btnClearDisplay.setText("AC");
//
//                    isAdditionPressed = false;
//
//                    isSubtractionPressed = false;
//
//                    isDivisionPressed = false;
//
//                    isMultiplicationPressed = false;
//
//                    num2 = new BigDecimal(tvDisplayText);
//
//                    isOperatorPressed = false;
//                    isEqualPressed = true;
//
//                    try {
//                        double result = eval(tvPhrase.getText().toString().replaceAll("x", "*").replaceAll("÷", "/"));
//                        BigDecimal decimalResult = BigDecimal.valueOf(result);
//
//                        // Round the result to 2 decimal places
//                        BigDecimal roundedResult = decimalResult.setScale(2, RoundingMode.HALF_UP);
//
//                        // Check if the rounded result is a whole number
//                        if (roundedResult.stripTrailingZeros().scale() <= 0) {
//                            String strRes = roundedResult.stripTrailingZeros().toPlainString();
//                            tvDisplay.setText(strRes);
//
//                        } else {
//                            String strRes = roundedResult.toPlainString();
//                            tvDisplay.setText(strRes);
//                        }
//
//
//                        String temp = tvPhrase.getText().toString() + " = ";
//                        tvPhrase.setText(temp);
//                        op = ' ';
//                        num1 = BigDecimal.ZERO;
//                        num2 = BigDecimal.ZERO;
//                        tempNew = "";
//                        tempNumber = BigDecimal.ZERO;
//                    } catch (RuntimeException e) {
//                        // Handle expression evaluation error
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//
////        btnDot.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////
////
////                String tvDisplayText = tvDisplay.getText().toString();
////                String tvPhraseText = tvPhrase.getText().toString();
////
//////                Toast.makeText(Temp.this, "1" + tvDisplayText + "1", Toast.LENGTH_SHORT).show();
////
////
////                if(tvDisplayText.contains(".")){
////                    return;
////                }
////
////
////
////
////                // attention need to replace tvDiplayText.isEmpty() with isOperatorPressed
////
////
////
////                if( isOperatorPressed || isEqualPressed){
////
////
//////                    if (tvPhraseText.equals("0")) {
//////                        tvPhrase.setText("");
//////
//////                    }
////
////                    if(!isBtn0Pressed){
////                        btn0.performClick();
////                    }
////
////                }
////
////
////                Handler handler = new Handler();
////                handler.postDelayed(new Runnable() {
////                    @Override
////                    public void run() {
////
////                        String tvDisplayText = tvDisplay.getText().toString();
////                        String tvPhraseText = tvPhrase.getText().toString();
////
////
////                        tvDisplayText = tvDisplayText + ".";
////
////                        tvPhraseText = tvPhraseText + ".";
////
////
////                        tvDisplay.setText(tvDisplayText);
////                        tvPhrase.setText(tvPhraseText);
////
////                    }
////                }, 10);
////
////
////
////
////            }
////        });
//
////        Button btnDot = findViewById(R.id.btnDot);
////        Button btnDot = findViewById(R.id.btnDot);
////        Button btnDot = findViewById(R.id.btnDot);
////        Button btnDot = findViewById(R.id.btnDot);
////        btnDot.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                String tvDisplayText = tvDisplay.getText().toString();
////                if (tvDisplayText.isEmpty() || tvDisplayText.contains(".")) {
////
////
////                    if(isEqualPressed || isOperatorPressed){
////
////                        tvDisplayText = "0.";
////                        tvDisplay.setText(tvDisplayText);
////
////                    }
////
////                    return;
////                }
////
////
////                if(isEqualPressed || isOperatorPressed){
////
////                    tvDisplayText = "0.";
////                    tvDisplay.setText(tvDisplayText);
////
////                } else {
////                    tvDisplayText += '.';
////                    tvDisplay.setText(tvDisplayText);
////
////                }
////
////                if(isEqualPressed){
////                    tvPhrase.setText("");
////                    isEqualPressed =false;
////                }
////
////            }
////        });
//        btnDot.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick (View v){
//
//                    isBtn0Pressed = false;
//
//                String tvDisplayText = tvDisplay.getText().toString();
//                String tvPhraseText = tvPhrase.getText().toString();
//
////                Toast.makeText(Temp.this, "1" + tvDisplayText + "1", Toast.LENGTH_SHORT).show();
//
//
////                if (tvDisplayText.contains(".")) {
////                    return;
////                }
//
//
////                    String tvPhraseText = tvPhrase.getText().toString();
//                    boolean iContainOperator = false;
//                    String lastNumber = "";
//
//// Check if the tvPhraseText contains an operator
//                    if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
//                        // Split the tvPhraseText into an array of strings based on the operators
//
////                         iContainOperator = true;
//
//                        String[] numbers = tvPhraseText.split("\\+|-|x|÷");
//
//                        // Get the last number from the array (which will be the number after the last operator)
//                        if (numbers.length > 0) {
//                            lastNumber = numbers[numbers.length - 1].trim();
//                        }
//                    }
//
//
////                            Toast.makeText(Temp.this, String.valueOf(isOperatorPressed), Toast.LENGTH_SHORT).show();
//
//
//                    if((lastNumber.contains(".") || tvDisplayText.contains(".")) && (!isEqualPressed && !isOperatorPressed)){
////                        Toast.makeText(Temp.this, "truereturn", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//// Use the lastNumber as needed
//
//
//
////                    Toast.makeText(Temp.this, String.valueOf(isEqualPressed), Toast.LENGTH_SHORT).show();
//                if ( isOperatorPressed || isEqualPressed || tvPhraseText.isEmpty()) {
//
//
////                    if (tvPhraseText.equals("0")) {
////                        tvPhrase.setText("");
////
////                    }
//
////                    Toast.makeText(Temp.this, String.valueOf(isBtn0Pressed), Toast.LENGTH_SHORT).show();
//
//                    if (!isBtn0Pressed) {
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
//                        // Code to be executed after the delay
//                        // Place your desired logic or actions here
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
//
//                    }
//                }, 10); // 10000 milliseconds = 10 seconds
//
//
//            }
//
//            });
//
//        }
//
//
//
//
//
//    private BigDecimal calculate(BigDecimal num1, BigDecimal num2, char op) {
//        switch (op) {
//            case '+':
//                return num1.add(num2);
//            case '-':
//                return num1.subtract(num2);
//            case 'x':
//                return num1.multiply(num2);
//            case '÷':
//                if (num2.compareTo(BigDecimal.ZERO) != 0) {
//                    return num1.divide(num2, 2, RoundingMode.HALF_UP);
//                } else {
//                    return BigDecimal.ZERO;
//                }
//            default:
//                return BigDecimal.ZERO;
//        }
//    }
//
//
//    private void findViews() {
//        btnClear = findViewById(R.id.btn_clear);
//        btnClearDisplay = findViewById(R.id.btn_clear_display);
//        btnNegative = findViewById(R.id.btn_negative);
//        btnDelete = findViewById(R.id.btn_delete);
//        btnDivision = findViewById(R.id.btn_division);
//        btnMultiplication = findViewById(R.id.btn_multiplication);
//        btnSubmission = findViewById(R.id.btn_submission);
//        btnSum = findViewById(R.id.btn_sum);
//        btnEqual = findViewById(R.id.btn_equal);
//        btnDot = findViewById(R.id.btn_dot);
//        tvDisplay = findViewById(R.id.tv_display);
//        tvPhrase = findViewById(R.id.tv_phrase);
//    }
//
//
//
//
//
//    // Function to handle the click event for numeric buttons
//    private void handleNumericButtonClick(String value) {
//
//
//        if (isEqualPressed) {
//
//
////            if(!tvDisplay.getText().toString().equals("0.")){
//
//            tvDisplay.setText("");
////            }
//
//
//
//            if(!isOperatorPressed){
//                tvPhrase.setText("");
////                Toast.makeText(this, "equal was pressed", Toast.LENGTH_SHORT).show();
//
//            }
//
//
//
//            isEqualPressed = false;
//        }
//
//
//        if (isOperatorPressed) {
//
//
////            if( !tvDisplay.getText().toString().equals("0.")){
//            tvDisplay.setText("");
//
////            }
//
//
//            isOperatorPressed = false;
//        }
//
//        String tvDisplayText = tvDisplay.getText().toString();
//        String tvPhraseText = tvPhrase.getText().toString();
//
//        if (tvDisplayText.equals("0")) {
//            tvDisplayText = "";
//
//        }
//
//        tvDisplayText += value;
//        tvDisplay.setText(tvDisplayText);
//        tvPhraseText += value;
//        tvPhrase.setText(tvPhraseText);
//        isBtn0Pressed = false;
//        btnClearDisplay.setText("C");
//        cPressed = false;
//    }
//
//
//    public static double eval(final String str) {
//        try {
//            Expression expression = new ExpressionBuilder(str)
//                    .build();
//            return expression.evaluate();
//        } catch (Exception e) {
//            // Handle any evaluation or parsing errors
//            e.printStackTrace();
//            return Double.NaN;
//        }
//    }
//
//
//    private void clearScreen(){
//        isOperatorPressed = false;
////                num1 = 0;
////                num2 = 0;
//        num1 = BigDecimal.ZERO;
//        num2 = BigDecimal.ZERO;
////                tempNumberDivide = BigDecimal.ZERO;
//        tempNumber = BigDecimal.ZERO;
//        tempNew = "";
//        op = ' ';
//        tvPhrase.setText("");
//        tvDisplay.setText("0");
//        isEqualPressed = false;
//        isOperatorPressed = false;
//        isAdditionPressed = false;
//        isSubtractionPressed = false;
//        isDivisionPressed = false;
//        isMultiplicationPressed = false;
//        isBtn0Pressed = false;
//
//        tvDisplay.setText("0");
//        tvPhrase.setText("");
//    }
//
//
//}








































//
//
//
//package com.calculator.expensemanager;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.os.Bundle;
//        import android.os.Handler;
//        import android.text.TextUtils;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
////import net.objecthunter.exp4j.Expression;
////import net.objecthunter.exp4j.ExpressionBuilder;
////import net.objecthunter.exp4j.ValidationResult;
//
//        import net.objecthunter.exp4j.Expression;
//        import net.objecthunter.exp4j.ExpressionBuilder;
//
//        import java.math.BigDecimal;
//        import java.math.RoundingMode;
//        import java.util.List;
//        import java.util.Stack;
//
////import javax.el.Expression;
////import javax.script.ScriptEngine;
////import javax.script.ScriptEngineManager;
////import javax.script.ScriptException;
//
//public class Temp extends AppCompatActivity {
//
//    //    Button[] numericButtons;
//    Button btnClear, btnClearDisplay, btnNegative, btnDelete,
//            btnDivision, btnMultiplication, btnSubmission, btnSum, btnEqual, btnDot;
//    String tempNew = "";
//
//    boolean isBtn0Pressed = false;
//    BigDecimal tempNumber;
//    boolean cPressed = false;
////    BigDecimal tempNumberDivide;
//
//    //    BigDecimal tempResult = BigDecimal.ZERO;
//    TextView tvDisplay, tvPhrase;
//
//    boolean isOperatorPressed = false;
//
//    //    boolean isAdditionPressed = false;
////    boolean isSubtractionPressed = false;
////    boolean isMultiplicationPressed = false;
////    boolean isDivisionPressed = false;
//    boolean isEqualPressed = false;
//
//    //    double num1 = 0;
//    BigDecimal num1 = BigDecimal.ZERO;
//    //    double num2 = 0;
//    BigDecimal num2 = BigDecimal.ZERO;
//    char op = ' ';
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_temp);
//
//        findViews();
//        Button btn0 = findViewById(R.id.btn_0);
//        Button btn1 = findViewById(R.id.btn_1);
//        Button btn2 = findViewById(R.id.btn_2);
//        Button btn3 = findViewById(R.id.btn_3);
//        Button btn4 = findViewById(R.id.btn_4);
//        Button btn5 = findViewById(R.id.btn_5);
//        Button btn6 = findViewById(R.id.btn_6);
//        Button btn7 = findViewById(R.id.btn_7);
//        Button btn8 = findViewById(R.id.btn_8);
//        Button btn9 = findViewById(R.id.btn_9);
//
//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("0");
//                isBtn0Pressed = true;
//            }
//        });
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("1");
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("2");
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("3");
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("4");
//            }
//        });
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("5");
//            }
//        });
//
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("6");
//            }
//        });
//
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("7");
//            }
//        });
//
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("8");
//            }
//        });
//
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleNumericButtonClick("9");
//            }
//        });
//
//
//
//
////        btnClear.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                isOperatorPressed = false;
//////                num1 = 0;
//////                num2 = 0;
////                num1 = BigDecimal.ZERO;
////                num2 = BigDecimal.ZERO;
//////                tempNumberDivide = BigDecimal.ZERO;
////                tempNumber = BigDecimal.ZERO;
////                tempNew = "";
////                op = ' ';
////                tvPhrase.setText("");
////                tvDisplay.setText("0");
////                isEqualPressed = false;
////                isOperatorPressed = false;
////                isAdditionPressed = false;
////                isSubtractionPressed = false;
////                isDivisionPressed = false;
////                isMultiplicationPressed = false;
////                isBtn0Pressed = false;
////            }
////        });
//////
////        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                tvDisplay.setText("0");
////
////                String tvPhraseText = tvPhrase.getText().toString();
////                boolean containsOperator = false;
////                if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
////                    // tvPhrase contains an operator
////                    // Perform your desired action here
////                    containsOperator = true;
////                }
////
////
////
////
////                if(isEqualPressed || !containsOperator){
////
////
////                    btnClear.performClick();
////                    return;
////
////                }
////
////
////
////                isEqualPressed = false;
////                isOperatorPressed = false;
////
//////                String tvPhraseText = tvPhrase.getText().toString();
////
////                // Example value of tvPhrase
////                String newNumber = " 0";  // New number to replace the last number
////
////                // Find the index of the last operator
////                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
////
////                if (lastOperatorIndex != -1) {
////                    // Get the substring after the last operator
////                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1);
////
////                    // Replace the last number with the new number
////                    tvPhraseText = tvPhraseText.replace(lastNumber, newNumber);
////                }
////
////                // Assuming you have a TextView or any other view to display the tvPhrase
////                tvPhrase.setText(tvPhraseText);
////            }
////        });
//
//        //
////        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                tvDisplay.setText("0");
////
////                String tvPhraseText = tvPhrase.getText().toString();
////                 Find the index of the last operator
////                int lastOperatorIndex = Math.max(tvPhraseText.lastIndexOf("+"), Math.max(tvPhraseText.lastIndexOf("-"), Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷"))));
////
////                if (lastOperatorIndex != -1) {
////                     Get the substring after the last operator
////                    String lastNumber = tvPhraseText.substring(lastOperatorIndex + 1).trim();
////
////                    Toast.makeText(Temp.this, lastNumber, Toast.LENGTH_SHORT).show();
////
////
////                    tvPhraseText = tvPhraseText.replace(lastNumber,"0");
////                    tvPhrase.setText(tvPhraseText);
////
////                     Use the lastNumber as needed
////                }
////
////
////
////                isEqualPressed = false;
////                isOperatorPressed = false;
////            }
////        });
////
//        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvDisplay.setText("0");
//
//                btnClearDisplay.setText("AC");
//
//
//
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//                boolean containsOperator = tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷") || tvPhraseText.endsWith(" % ");
//
//                // tvPhrase contains an operator
//                // Perform your desired action here
//
//
//
//
//                if (isEqualPressed || !containsOperator) {
//                    clearScreen();
//                    return;
//
//                }
//
//
//                if(cPressed){
//
//
//                    clearScreen();
//                    return;
//
//
//                }
//
//
//
//
////                isOperatorPressed = false;
//
//                // Example value of tvPhrase
//                String newNumber = "0";  // New number to replace the last number
//
//                // Find the index of the last operator
//                int lastOperatorIndex = Math.max(Math.max(tvPhraseText.lastIndexOf("+"), tvPhraseText.lastIndexOf("-")),
//                        Math.max(tvPhraseText.lastIndexOf("x"), tvPhraseText.lastIndexOf("÷")));
//
//                if (lastOperatorIndex != -1) {
//                    // Get the substring after the last operator
//                    String afterOperator = tvPhraseText.substring(lastOperatorIndex + 1).trim();
//
//                    // Check if the substring is a number or starts with "0."
//                    if (!afterOperator.isEmpty() && afterOperator.matches("-?\\d+(\\.\\d*)?")) {
//                        // Replace the last number with the new number
//                        tvPhraseText = tvPhraseText.substring(0, lastOperatorIndex + 2) + newNumber;
//                    }
//                    cPressed = true;
//                }
//
//
//                // Assuming you have a TextView or any other view to display the tvPhrase
//                tvPhrase.setText(tvPhraseText);
//            }
//        });
//
//
//
//
//        btnNegative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvPhraseText = tvPhrase.getText().toString();
//
//                // Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ") || tvPhraseText.endsWith(" % ")) {
//                    // Replace the last operator with '%'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " % ";
//
//                    tvPhrase.setText(modifiedText);
//                } else {
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if (op != ' ') {
//                        calculateViaLibrary(tvPhraseText);
//                    }
//
//                    BigDecimal num = new BigDecimal(tvDisplayText);
//                    BigDecimal percentage = num.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
//                    tempNumber = calculate(tempNumber, percentage, op);
//                    tempNew += percentage.toPlainString() + " ";
//                    tvPhrase.setText(tempNew);
//
//                    String resultText = tempNumber.stripTrailingZeros().toPlainString();
//                    tvDisplay.setText(resultText);
//                }
//
//                op = '%';
//            }
//        });
//
//
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isOperatorPressed = false;
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (tvDisplayText.length() > 0) {
//                    tvDisplayText = tvDisplayText.substring(0, tvDisplayText.length() - 1);
//                    if (tvDisplayText.length() == 0) {
//                        tvDisplayText = "0";
//                        isEqualPressed = false;
//                        isOperatorPressed = false;
//                    }
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
//                }
//            }
//        });
//
//        btnDivision.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isDivisionPressed){
////                    return;
////                }
////
////                isDivisionPressed = true;
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " ÷ ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
////
////                    if (op != ' ') {
////                        num2 = new BigDecimal(tvDisplayText);
////                        tempNumber = calculate(tempNumber, num2, op);
////                        num1 = tempNumber;
////                    } else {
////                        num1 = new BigDecimal(tvDisplayText);
////                        tempNumber = num1;
////                    }
//
//                    if(op != ' '){
//                        calculateViaLibrary(tvPhraseText);
//                    }
//
//                    op = '÷';
//                    tempNew += tvDisplayText + " ÷ ";
//                    tvPhrase.setText(tempNew);
//
////                    BigDecimal roundedResult = tempNumber.setScale(2, RoundingMode.HALF_UP);
////                    // Check if the rounded result is a whole number
////                    if (roundedResult.stripTrailingZeros().scale() <= 0) {
////                        String strTempRes = roundedResult.stripTrailingZeros().toPlainString();
////                        tvDisplay.setText(strTempRes);
////
////                    } else {
////                        String strTempRes = roundedResult.toPlainString();
////                        tvDisplay.setText(strTempRes);
////                    }
//
//                }
//
//                op = '÷';
//            }
//        });
//
//        btnMultiplication.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " x ";
//
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
//                    if(op != ' '){
//                        calculateViaLibrary(tvPhraseText);
//                    }
//
//                    tempNew += tvDisplayText + " x ";
//                    tvPhrase.setText(tempNew);
//
//
//                }
//                op = 'x';
//            }
//        });
//
//
//
//
//        btnSubmission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isSubtractionPressed){
////                    return;
////                }
////                isSubtractionPressed = true;
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " - ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
////                    if (op != ' ') {
////                        num2 = new BigDecimal(tvDisplayText);
////                        tempNumber = calculate(tempNumber, num2, op);
////                        num1 = tempNumber;
////                    } else {
////                        num1 = new BigDecimal(tvDisplayText);
////                        tempNumber = num1;
////                    }
//
//                    if(op != ' '){
//                        calculateViaLibrary(tvPhraseText);
//                    }
//
//
//                    tempNew += tvDisplayText + " - ";
//                    tvPhrase.setText(tempNew);
////                    BigDecimal roundedResult = tempNumber.setScale(2, RoundingMode.HALF_UP);
//
//                    // Check if the rounded result is a whole number
////                    if (roundedResult.stripTrailingZeros().scale() <= 0) {
////                        String strTempRes = roundedResult.stripTrailingZeros().toPlainString();
////                        tvDisplay.setText(strTempRes);
////
////                    } else {
////                        String strTempRes = roundedResult.toPlainString();
////                        tvDisplay.setText(strTempRes);
////                    }
//
//                }
//
//                op = '-';
//
//            }
//        });
//
//        btnSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                if(isAdditionPressed){
////                    return;
////                }
////
////                isAdditionPressed = true;
//
//
//
//                String tvPhraseText = tvPhrase.getText().toString();
//
//// Check if the string ends with an operator
//                if (tvPhraseText.endsWith(" + ") || tvPhraseText.endsWith(" - ") || tvPhraseText.endsWith(" x ") || tvPhraseText.endsWith(" ÷ ")) {
//                    // Replace the last operator with 'x'
//                    String modifiedText = tvPhraseText.substring(0, tvPhraseText.length() - 3) + " + ";
//
//
//                    // Set the modified text back to the TextView
//                    tvPhrase.setText(modifiedText);
//                } else {
//
//                    isOperatorPressed = true;
//                    String tvDisplayText = tvDisplay.getText().toString();
//
////                    if (op != ' ') {
////                        num2 = new BigDecimal(tvDisplayText);
////                        tempNumber = calculate(tempNumber, num2, op);
////                        num1 = tempNumber;
////                    } else {
////                        num1 = new BigDecimal(tvDisplayText);
////                        tempNumber = num1;
////                    }
//
//                    if(op != ' '){
//                        calculateViaLibrary(tvPhraseText);
//                    }
//
//                    op = '+';
//                    tempNew += tvDisplayText + " + ";
//                    tvPhrase.setText(tempNew);
////                    tvDisplay.setText(String.valueOf(tempNumber));
//
//
//
////                    BigDecimal roundedResult = tempNumber.setScale(2, RoundingMode.HALF_UP);
////                    // Check if the rounded result is a whole number
////                    if (roundedResult.stripTrailingZeros().scale() <= 0) {
////                        String strTempRes = roundedResult.stripTrailingZeros().toPlainString();
////                        tvDisplay.setText(strTempRes);
////
////                    } else {
////                        String strTempRes = roundedResult.toPlainString();
////                        tvDisplay.setText(strTempRes);
////                    }
//
//
//
//                }
//
//
//                op = '+';
//
//
//            }
//        });
//
//        btnEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String tvDisplayText = tvDisplay.getText().toString();
//                if (!isOperatorPressed && op != ' ') {
//
//
//                    btnClearDisplay.setText("AC");
//
////                    isAdditionPressed = false;
////
////                    isSubtractionPressed = false;
////
////                    isDivisionPressed = false;
////
////                    isMultiplicationPressed = false;
//
//                    num2 = new BigDecimal(tvDisplayText);
//
//                    isOperatorPressed = false;
//                    isEqualPressed = true;
//
//                    calculateViaLibrary(tvPhrase.getText().toString());
//
//
//                    String temp = tvPhrase.getText().toString() + " = ";
//                    tvPhrase.setText(temp);
//                    op = ' ';
//                    num1 = BigDecimal.ZERO;
//                    num2 = BigDecimal.ZERO;
//                    tempNew = "";
//                    tempNumber = BigDecimal.ZERO;
//
//                }
//            }
//        });
//
//
////        btnDot.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////
////
////                String tvDisplayText = tvDisplay.getText().toString();
////                String tvPhraseText = tvPhrase.getText().toString();
////
//////                Toast.makeText(Temp.this, "1" + tvDisplayText + "1", Toast.LENGTH_SHORT).show();
////
////
////                if(tvDisplayText.contains(".")){
////                    return;
////                }
////
////
////
////
////                // attention need to replace tvDiplayText.isEmpty() with isOperatorPressed
////
////
////
////                if( isOperatorPressed || isEqualPressed){
////
////
//////                    if (tvPhraseText.equals("0")) {
//////                        tvPhrase.setText("");
//////
//////                    }
////
////                    if(!isBtn0Pressed){
////                        btn0.performClick();
////                    }
////
////                }
////
////
////                Handler handler = new Handler();
////                handler.postDelayed(new Runnable() {
////                    @Override
////                    public void run() {
////
////                        String tvDisplayText = tvDisplay.getText().toString();
////                        String tvPhraseText = tvPhrase.getText().toString();
////
////
////                        tvDisplayText = tvDisplayText + ".";
////
////                        tvPhraseText = tvPhraseText + ".";
////
////
////                        tvDisplay.setText(tvDisplayText);
////                        tvPhrase.setText(tvPhraseText);
////
////                    }
////                }, 10);
////
////
////
////
////            }
////        });
//
////        Button btnDot = findViewById(R.id.btnDot);
////        Button btnDot = findViewById(R.id.btnDot);
////        Button btnDot = findViewById(R.id.btnDot);
////        Button btnDot = findViewById(R.id.btnDot);
////        btnDot.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                String tvDisplayText = tvDisplay.getText().toString();
////                if (tvDisplayText.isEmpty() || tvDisplayText.contains(".")) {
////
////
////                    if(isEqualPressed || isOperatorPressed){
////
////                        tvDisplayText = "0.";
////                        tvDisplay.setText(tvDisplayText);
////
////                    }
////
////                    return;
////                }
////
////
////                if(isEqualPressed || isOperatorPressed){
////
////                    tvDisplayText = "0.";
////                    tvDisplay.setText(tvDisplayText);
////
////                } else {
////                    tvDisplayText += '.';
////                    tvDisplay.setText(tvDisplayText);
////
////                }
////
////                if(isEqualPressed){
////                    tvPhrase.setText("");
////                    isEqualPressed =false;
////                }
////
////            }
////        });
//        btnDot.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick (View v){
//
//                isBtn0Pressed = false;
////                    cPressed = false;
//
//                String tvDisplayText = tvDisplay.getText().toString();
//                String tvPhraseText = tvPhrase.getText().toString();
//
////                Toast.makeText(Temp.this, "1" + tvDisplayText + "1", Toast.LENGTH_SHORT).show();
//
//
////                if (tvDisplayText.contains(".")) {
////                    return;
////                }
//
//
////                    String tvPhraseText = tvPhrase.getText().toString();
//                boolean iContainOperator = false;
//                String lastNumber = "";
//
//// Check if the tvPhraseText contains an operator
//                if (tvPhraseText.contains("+") || tvPhraseText.contains("-") || tvPhraseText.contains("x") || tvPhraseText.contains("÷")) {
//                    // Split the tvPhraseText into an array of strings based on the operators
//
////                         iContainOperator = true;
//
//                    String[] numbers = tvPhraseText.split("\\+|-|x|÷");
//
//                    // Get the last number from the array (which will be the number after the last operator)
//                    if (numbers.length > 0) {
//                        lastNumber = numbers[numbers.length - 1].trim();
//                    }
//                }
//
//
////                            Toast.makeText(Temp.this, String.valueOf(isOperatorPressed), Toast.LENGTH_SHORT).show();
//
//
//                if((lastNumber.contains(".") || tvDisplayText.contains(".")) && (!isEqualPressed && !isOperatorPressed)){
////                        Toast.makeText(Temp.this, "truereturn", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//// Use the lastNumber as needed
//
//
//
////                    Toast.makeText(Temp.this, String.valueOf(isEqualPressed), Toast.LENGTH_SHORT).show();
//                if ( isOperatorPressed || isEqualPressed || tvPhraseText.isEmpty()) {
//
//
////                    if (tvPhraseText.equals("0")) {
////                        tvPhrase.setText("");
////
////                    }
//
////                    Toast.makeText(Temp.this, String.valueOf(isBtn0Pressed), Toast.LENGTH_SHORT).show();
//
//                    if (!isBtn0Pressed) {
//                        btn0.performClick();
////                        Toast.makeText(Temp.this, "i am called", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//
//
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        // Code to be executed after the delay
//                        // Place your desired logic or actions here
//                        String tvDisplayText = tvDisplay.getText().toString();
//                        String tvPhraseText = tvPhrase.getText().toString();
//
//
//                        tvDisplayText = tvDisplayText + ".";
//
//                        tvPhraseText = tvPhraseText + ".";
//                        cPressed = false;
//
//                        tvDisplay.setText(tvDisplayText);
//                        tvPhrase.setText(tvPhraseText);
//
//
//                    }
//                }, 10); // 10000 milliseconds = 10 seconds
//
//
//            }
//
//        });
//
//
//    }
//
//
//
//
//
//    private BigDecimal calculate(BigDecimal num1, BigDecimal num2, char op) {
//        switch (op) {
//            case '+':
//                return num1.add(num2);
//            case '-':
//                return num1.subtract(num2);
//            case 'x':
//                return num1.multiply(num2);
//            case '÷':
//                if (num2.compareTo(BigDecimal.ZERO) != 0) {
//                    return num1.divide(num2, 2, RoundingMode.HALF_UP);
//                } else {
//                    return BigDecimal.ZERO;
//                }
//            default:
//                return BigDecimal.ZERO;
//        }
//    }
//
//
//    private void findViews() {
//        btnClear = findViewById(R.id.btn_clear);
//        btnClearDisplay = findViewById(R.id.btn_clear_display);
//        btnNegative = findViewById(R.id.btn_negative);
//        btnDelete = findViewById(R.id.btn_delete);
//        btnDivision = findViewById(R.id.btn_division);
//        btnMultiplication = findViewById(R.id.btn_multiplication);
//        btnSubmission = findViewById(R.id.btn_submission);
//        btnSum = findViewById(R.id.btn_sum);
//        btnEqual = findViewById(R.id.btn_equal);
//        btnDot = findViewById(R.id.btn_dot);
//        tvDisplay = findViewById(R.id.tv_display);
//        tvPhrase = findViewById(R.id.tv_phrase);
//    }
//
//
//
//
//
//    // Function to handle the click event for numeric buttons
//    private void handleNumericButtonClick(String value) {
//
//
//
//
//
//
//
//
//        if (isEqualPressed) {
//
//
////            if(!tvDisplay.getText().toString().equals("0.")){
//
//            tvDisplay.setText("");
////            }
//
//
//
//            if(!isOperatorPressed){
//                tvPhrase.setText("");
////                Toast.makeText(this, "equal was pressed", Toast.LENGTH_SHORT).show();
//
//            }
//
//
//
//            isEqualPressed = false;
//        }
//
//
//        if (isOperatorPressed) {
//
//
////            if( !tvDisplay.getText().toString().equals("0.")){
//            tvDisplay.setText("");
//
////            }
//
//
//            isOperatorPressed = false;
//        }
//
//        String tvDisplayText = tvDisplay.getText().toString();
//        String tvPhraseText = tvPhrase.getText().toString();
//
//        if (tvDisplayText.equals("0")) {
//            tvDisplayText = "";
//
//        }
//
//
//
//        if (tvPhraseText.endsWith("0")) {
//            // Remove the last character from tvPhrase
//            tvPhraseText = tvPhraseText.substring(0, tvPhraseText.length() - 1);
//
//        }
//
//        tvDisplayText += value;
//        tvDisplay.setText(tvDisplayText);
//        tvPhraseText += value;
//        tvPhrase.setText(tvPhraseText);
//        isBtn0Pressed = false;
//        btnClearDisplay.setText("C");
//        cPressed = false;
//    }
//
//
//    public static double eval(final String str) {
//        try {
//            Expression expression = new ExpressionBuilder(str)
//                    .build();
//            return expression.evaluate();
//        } catch (Exception e) {
//            // Handle any evaluation or parsing errors
//            e.printStackTrace();
//            return Double.NaN;
//        }
//    }
//
//
//    private void clearScreen(){
//        isOperatorPressed = false;
////                num1 = 0;
////                num2 = 0;
//        num1 = BigDecimal.ZERO;
//        num2 = BigDecimal.ZERO;
////                tempNumberDivide = BigDecimal.ZERO;
//        tempNumber = BigDecimal.ZERO;
//        tempNew = "";
//        op = ' ';
//        tvPhrase.setText("");
//        tvDisplay.setText("0");
//        isEqualPressed = false;
//        isOperatorPressed = false;
////        isAdditionPressed = false;
////        isSubtractionPressed = false;
////        isDivisionPressed = false;
////        isMultiplicationPressed = false;
//        isBtn0Pressed = false;
//
//        tvDisplay.setText("0");
////        tvPhrase.setText("");
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    private String calculateViaLibrary(String expression){
//        String tvDisplayText = tvDisplay.getText().toString();
////        if (!isOperatorPressed && op != ' ') {
//
//
////            btnClearDisplay.setText("AC");
//
////                    isAdditionPressed = false;
////
////                    isSubtractionPressed = false;
////
////                    isDivisionPressed = false;
////
////                    isMultiplicationPressed = false;
//
////            num2 = new BigDecimal(tvDisplayText);
//
////            isOperatorPressed = false;
////            isEqualPressed = true;
//
//        try {
//            double result = eval(expression.replaceAll("x", "*").replaceAll("÷", "/"));
//            BigDecimal decimalResult = BigDecimal.valueOf(result);
//
//            // Round the result to 2 decimal places
//            BigDecimal roundedResult = decimalResult.setScale(2, RoundingMode.HALF_UP);
//
//            // Check if the rounded result is a whole number
//            if (roundedResult.stripTrailingZeros().scale() <= 0) {
//                tvDisplay.setText( roundedResult.stripTrailingZeros().toPlainString());
//
//                String temp = tvPhrase.getText().toString();
//                tvPhrase.setText(temp);
////                    op = ' ';
////                    num1 = BigDecimal.ZERO;
////                    num2 = BigDecimal.ZERO;
////                    tempNew = "";
////                    tempNumber = BigDecimal.ZERO;
//
//                return roundedResult.stripTrailingZeros().toPlainString();
//
//            } else {
//                tvDisplay.setText(roundedResult.toPlainString());
//
//                String temp = tvPhrase.getText().toString();
//                tvPhrase.setText(temp);
////                    op = ' ';
////                    num1 = BigDecimal.ZERO;
////                    num2 = BigDecimal.ZERO;
////                    tempNew = "";
////                    tempNumber = BigDecimal.ZERO;
//                return roundedResult.toPlainString();
//            }
//
//
//        } catch (RuntimeException e) {
//            // Handle expression evaluation error
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//
////    }
//
//
//
//
//}