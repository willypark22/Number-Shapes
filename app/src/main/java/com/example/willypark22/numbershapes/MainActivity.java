package com.example.willypark22.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSqr() {
            double squareNum = Math.sqrt(number);

            if(squareNum == Math.floor(squareNum)) {
                return true;
            }
            else {
                return false;
            }
        }

        public boolean isTri() {
            int x = 1;
            int triNum = 1;

            while(triNum < number) {
                x++;
                triNum += x;
            }

            if(triNum == number) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void testFunction(View view) {

        EditText userNum = findViewById(R.id.userNum);
        String message = "";

        if(userNum.getText().toString().isEmpty()) {
            message = "Please enter a number.";
        }
        else {

            Number myNum = new Number();
            myNum.number = Integer.parseInt(userNum.getText().toString());

            if (myNum.isSqr()) {
                if (myNum.isTri()) {
                    message = myNum.number + " is both triangular and square.";
                } else {
                    message = myNum.number + " is a square, but not triangular.";
                }
            } else {
                if (myNum.isTri()) {
                    message = myNum.number + " is triangular, but not  square.";
                } else {
                    message = myNum.number + " is neither.";
                }
            }
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
