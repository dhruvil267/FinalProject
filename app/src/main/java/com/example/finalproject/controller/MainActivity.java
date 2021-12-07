package com.example.finalproject.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.model.QuestionRepo;
import com.example.finalproject.model.Questions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private QuestionRepo repository=new QuestionRepo();
    private int questionindex=0;
    private TextView questionview;
    private EditText editresult;
    private int correctans=0;
    private int incorrectans =0;
    private Button generate,equals;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnpoint,btnminus,btnclear,btnquit,btnShowAll;
    private String result="";


    private String value="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

       View.OnClickListener listener = new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Questions quest = repository.getListQuestions().get(questionindex);

               if(quest.getRightanswer().equals(editresult.getText().toString())){
                   result+=quest.getText()+" = "+editresult.getText().toString()+"\nYour Answer is Correct!!!\n---------------------------------\n";
                   correctans++;


               }else{
                   result+=quest.getText()+" = "+editresult.getText().toString()+"\nYour Answer is InCorrect!!!\n---------------------------------\n";
                   incorrectans++;



               }
               editresult.setText("");
               value="";
               questionindex++;
               questionview.setText(null);
           }
       };

        View.OnClickListener listnernextquestion=new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if(questionindex>=repository.getListQuestions().size()){
                    questionindex=0;
                }
                showquestion(questionindex);
            }
        };

        generate.setOnClickListener(listnernextquestion);
        equals.setOnClickListener(listener);



    }

    private void initialize() {
        questionview=findViewById(R.id.txtGenerate);

        editresult=findViewById(R.id.editResult);
        generate=findViewById(R.id.btnGenerate);
        equals=findViewById(R.id.btnFinish);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnclear=findViewById(R.id.btnClear);
        btnpoint=findViewById(R.id.btnpoint);
        btnminus=findViewById(R.id.btnMinus);
        btnquit=findViewById(R.id.btnQuit);
        btnShowAll=findViewById(R.id.btnShowAll);



        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnpoint.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnquit.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);

    }

    private void showquestion(int questionindex) {
        Questions quest = repository.getListQuestions().get(questionindex);
        questionview.setText(quest.getText());


    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btn0:
                editresult.setText(value+="0");
                break;
            case R.id.btn1:
                editresult.setText(value+="1");
                break;
            case R.id.btn2:
                editresult.setText(value+="2");
                break;
            case R.id.btn3:
                editresult.setText(value+="3");
                break;
            case R.id.btn4:
                editresult.setText(value+="4");
                break;
            case R.id.btn5:
                editresult.setText(value+="5");
                break;
            case R.id.btn6:
                editresult.setText(value+="6");
                break;
            case R.id.btn7:
                editresult.setText(value+="7");
                break;
            case R.id.btn8:
                editresult.setText(value+="8");
                break;
            case R.id.btn9:
                editresult.setText(value+="9");
                break;
            case R.id.btnpoint:
                editresult.setText(value+=".");
                break;
            case R.id.btnMinus:
                editresult.setText(value+="-");
                break;
            case R.id.btnClear:
                editresult.setText("");
                value="";
                break;
            case R.id.btnQuit:
                System.exit(0);
                break;
            case R.id.btnShowAll:
                goToSecondActivity();
                break;


        }
    }

    private void goToSecondActivity() {

        int total=correctans+incorrectans;
        correctans=correctans*100;
        incorrectans=incorrectans*100;
        int correctpercent=correctans/(total);
        int incorrectpercent=incorrectans/(total);
        result+="\n\n"+ correctpercent+"% Correct Answer\n"+ incorrectpercent +"% Incorrect Answer";;
        Intent intent = new Intent(this,infoClass.class);
        intent.putExtra("res",result);
        startActivity(intent);

    }
}