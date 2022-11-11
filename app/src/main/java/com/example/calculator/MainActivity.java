package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv, solutionTv;
    MaterialButton buttonC, buttonBracketOpen, buttonBracketClose;
    MaterialButton buttonDivide, buttonPlus, buttonMultiply, buttonMinus, buttonEquals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton buttonAC, buttonDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assignID(buttonC, R.id.bottom_C);
        assignID(buttonBracketOpen, R.id.bottom_open_bracket);
        assignID(buttonBracketClose, R.id.bottom_close_bracket);
        assignID(buttonDivide, R.id.bottom_divide);
        assignID(buttonPlus, R.id.bottom_plus);
        assignID(buttonMultiply, R.id.bottom_multiply);
        assignID(buttonMinus, R.id.bottom_minus);
        assignID(buttonEquals, R.id.bottom_equals);
        assignID(button0, R.id.bottom_0);
        assignID(button1, R.id.bottom_1);
        assignID(button2, R.id.bottom_2);
        assignID(button3, R.id.bottom_3);
        assignID(button4, R.id.bottom_4);
        assignID(button5, R.id.bottom_5);
        assignID(button6, R.id.bottom_6);
        assignID(button7, R.id.bottom_7);
        assignID(button8, R.id.bottom_8);
        assignID(button9, R.id.bottom_9);
        assignID(buttonAC, R.id.bottom_ac);
        assignID(buttonDot, R.id.bottom_dot);

    }

    void assignID(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if (buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if (buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }
        if (buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
        }else {
            dataToCalculate += buttonText;
        }
        solutionTv.setText(dataToCalculate);
        String finalResult = getResult(dataToCalculate);

        if (finalResult.equals("Error")){
            resultTv.setText(finalResult);
        }
    }

    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript",1, null).toString();
            if (finalResult.endsWith("0")){
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        }catch (Exception e){
            return "Error";
        }
    }
}