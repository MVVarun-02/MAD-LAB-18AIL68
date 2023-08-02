package com.example.rlab2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone, btntwo, btnthree, btnfour, btnfive, btnsix,btnseven,
            btneight, btnnine, btnzero;
    Button btnadd, btnsub, btndiv, btnmulti,btndot, btnclear, btnequal;
    EditText txtResult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnzero=(Button) findViewById(R.id.btn_0);
        btnzero.setOnClickListener(this);
        btnone=(Button) findViewById(R.id.btn_1);
        btnone.setOnClickListener(this);
        btntwo=(Button) findViewById(R.id.btn_2);
        btntwo.setOnClickListener(this);
        btnthree=(Button) findViewById(R.id.btn_3);
        btnthree.setOnClickListener(this);
        btnfour=(Button) findViewById(R.id.btn_4);
        btnfour.setOnClickListener(this);
        btnfive=(Button) findViewById(R.id.btn_5);
        btnfive.setOnClickListener(this);
        btnsix=(Button) findViewById(R.id.btn_6);
        btnsix.setOnClickListener(this);
        btnseven=(Button) findViewById(R.id.btn_7);
        btnseven.setOnClickListener(this);
        btneight=(Button) findViewById(R.id.btn_8);
        btneight.setOnClickListener(this);
        btnnine=(Button) findViewById(R.id.btn_9);
        btnnine.setOnClickListener(this);
        btnadd=(Button) findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);
        btnsub=(Button) findViewById(R.id.btn_sub);
        btnsub.setOnClickListener(this);
        btnmulti=(Button) findViewById(R.id.btn_mul);
        btnmulti.setOnClickListener(this);
        btndiv=(Button) findViewById(R.id.btn_div);
        btndiv.setOnClickListener(this);
        btndot=(Button) findViewById(R.id.btn_dot);
        btndot.setOnClickListener(this);
        btnequal=(Button) findViewById(R.id.btn_equals);
        btnequal.setOnClickListener(this);
        btnclear=(Button) findViewById(R.id.btn_clr);
        btnclear.setOnClickListener(this);
        txtResult=(EditText) findViewById(R.id.editTextTextPersonName);
        txtResult.setText("");
    }
    @Override
    public void onClick(View v) {
        if(v.equals(btnone))
            txtResult.append("1");
        if(v.equals(btntwo))
            txtResult.append("2");
        if(v.equals(btnthree))
            txtResult.append("3");
        if(v.equals(btnfour))
            txtResult.append("4");
        if(v.equals(btnfive))
            txtResult.append("5");
        if(v.equals(btnsix))
            txtResult.append("6");
        if(v.equals(btnseven))
            txtResult.append("7");
        if(v.equals(btneight))
            txtResult.append("8");
        if(v.equals(btnnine))
            txtResult.append("9");
        if(v.equals(btnzero))
            txtResult.append("0");
        if(v.equals(btnadd))
            txtResult.append("+");
        if(v.equals(btnsub))
            txtResult.append("-");
        if(v.equals(btndiv))
            txtResult.append("/");
        if(v.equals(btnmulti))
            txtResult.append("*");
        if(v.equals(btndot))
            txtResult.append(".");
        if(v.equals(btnclear))
            txtResult.setText("");
        if(v.equals(btnequal))
        {
            try{
                String data=txtResult.getText().toString();
                if(data.contains("/")){
                    divide(data);
                } else if(data.contains("*")){
                    Multi(data);
                } else if (data.contains("-")) {
                    Sub(data);
                } else if (data.contains("+")) {
                    Add(data);
                }
            }catch(Exception e){
                displayInvalidMessage("Invalid operation");
            }
        }
    }
    private void displayInvalidMessage(String msg) {
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
    }
    private void Add(String data) {
        String[] operands=data.split(Pattern.quote("+"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result = operand1+operand2;
            txtResult.setText(String.valueOf(result));
        }else {
            displayInvalidMessage("Invalid operation ");
        }
    }
    private void Sub(String data) {
        String[] operands=data.split(Pattern.quote("-"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result = operand1-operand2;
            txtResult.setText(String.valueOf(result));
        }else {
            displayInvalidMessage("Invalid operation");
        }
    }
    private void Multi(String data) {
        String[] operands=data.split(Pattern.quote("*"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);

            double operand2=Double.parseDouble(operands[1]);
            double result = operand1*operand2;
            txtResult.setText(String.valueOf(result));
        }else {
            displayInvalidMessage("Invalid operation");
        }
    }
    private void divide(String data) {
        String[] operands=data.split(Pattern.quote("/"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result = operand1/operand2;
            txtResult.setText(String.valueOf(result));
        }else {
            displayInvalidMessage("Invalid operation");
        }
    }
}