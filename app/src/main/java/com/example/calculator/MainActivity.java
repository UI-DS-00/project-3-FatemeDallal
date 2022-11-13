package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.example.calculator.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    TextView resultTv, solutionTv;
    MaterialButton buttonC, buttonBracketOpen, buttonBracketClose, buttonDot;
    MaterialButton buttonDivide, buttonPlus, buttonMultiply, buttonMinus, buttonEquals, buttonPow;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        StringBuilder dataToCalculate = new StringBuilder();

        binding.button0.setOnClickListener(view -> {
            if (dataToCalculate.length() != 0){
                dataToCalculate.append("0");
                solutionTv.setText(dataToCalculate);
            }
        });
        binding.button1.setOnClickListener(view -> {
            dataToCalculate.append("1");
            solutionTv.setText(dataToCalculate);
        });
        binding.button2.setOnClickListener(view -> {
            dataToCalculate.append("2");
            solutionTv.setText(dataToCalculate);
        });
        binding.button3.setOnClickListener(view -> {
            dataToCalculate.append("3");
            solutionTv.setText(dataToCalculate);
        });
        binding.button4.setOnClickListener(view -> {
            dataToCalculate.append("4");
            solutionTv.setText(dataToCalculate);
        });
        binding.button5.setOnClickListener(view -> {
            dataToCalculate.append("5");
            solutionTv.setText(dataToCalculate);
        });
        binding.button6.setOnClickListener(view -> {
            dataToCalculate.append("6");
            solutionTv.setText(dataToCalculate);
        });
        binding.button7.setOnClickListener(view -> {
            dataToCalculate.append("7");
            solutionTv.setText(dataToCalculate);
        });
        binding.button8.setOnClickListener(view -> {
            dataToCalculate.append("8");
            solutionTv.setText(dataToCalculate);
        });
        binding.button9.setOnClickListener(view -> {
            dataToCalculate.append("9");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonOpenBracket.setOnClickListener(view -> {
            dataToCalculate.append("(");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonCloseBracket.setOnClickListener(view -> {
            dataToCalculate.append(")");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonPlus.setOnClickListener(view -> {
            if (dataToCalculate.charAt())
            dataToCalculate.append("+");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonMultiply.setOnClickListener(view -> {
            dataToCalculate.append("*");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonMinus.setOnClickListener(view -> {
            dataToCalculate.append("-");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonDivide.setOnClickListener(view -> {
            dataToCalculate.append("/");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonDot.setOnClickListener(view -> {
            dataToCalculate.append(".");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonPow.setOnClickListener(view -> {
            dataToCalculate.append("^");
            solutionTv.setText(dataToCalculate);
        });
        binding.buttonEquals.setOnClickListener(view -> {
            resultTv.setText(getResult(dataToCalculate.toString()));
            dataToCalculate.delete(0, dataToCalculate.length());
            solutionTv.setText("0");
        });
        binding.buttonC.setOnClickListener(view -> {
            solutionTv.setText(dataToCalculate.insert(dataToCalculate.length() - 1,""));
        });
    }

    String getResult(String data){
        return "0";
    }
}