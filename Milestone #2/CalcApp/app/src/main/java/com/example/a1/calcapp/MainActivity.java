package com.example.a1.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {


    Button b0, b1, b2, b3, b4, b5, b6,
            b7, b8, b9, bAdd, bSub, bDiv,
            bMul,  bC, bEq,bDec;
    EditText edittext;

    float n1,n2;

    boolean Addition, Subtract, Multiplication, Division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        b0 = (Button) findViewById(R.id.but0);
                b1 = (Button) findViewById(R.id.but1);
                b2 = (Button) findViewById(R.id.but2);
                b3 = (Button) findViewById(R.id.but3);
                b4 = (Button) findViewById(R.id.but4);
                b5 = (Button) findViewById(R.id.but5);
                b6 = (Button) findViewById(R.id.but6);
                b7 = (Button) findViewById(R.id.but7);
                b8 = (Button) findViewById(R.id.but8);
                b9 = (Button) findViewById(R.id.but9);
                bAdd = (Button) findViewById(R.id.add);
                bSub = (Button) findViewById(R.id.sub);
                bMul = (Button) findViewById(R.id.mul);
                bDiv = (Button) findViewById(R.id.div);
                bC = (Button) findViewById(R.id.butC);
                bEq = (Button) findViewById(R.id.eq);
                bDec= (Button) findViewById(R.id.dec);
                edittext = (EditText) findViewById(R.id.edit);


                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edittext.setText(edittext.getText() + "1");
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edittext.setText(edittext.getText() + "2");
                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edittext.setText(edittext.getText() + "3");
                    }
                });

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edittext.setText(edittext.getText() + "4");
                    }
                });

                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       edittext.setText(edittext.getText() + "5");
                    }
                });

                b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      edittext.setText(edittext.getText() + "6");
                    }
                });

                b7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edittext.setText(edittext.getText() + "7");
                    }
                });

                b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       edittext.setText(edittext.getText() + "8");
                    }
                });

                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       edittext.setText(edittext.getText() + "9");
                    }
                });

                b0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       edittext.setText(edittext.getText() + "0");
                    }
                });

                bAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                            n1 = Float.parseFloat(edittext.getText() + "");
                            Addition = true;
                            edittext.setText(null);
                        
                    }
                });

                bSub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        n1 = Float.parseFloat(edittext.getText() + "");
                        Subtract = true;
                       edittext.setText(null);
                    }
                });

                bMul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        n1 = Float.parseFloat(edittext.getText()+"");
                        Multiplication = true;
                       edittext.setText(null);
                    }
                });

                bDiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       n1 = Float.parseFloat(edittext.getText() + "");
                        Division = true;
                        edittext.setText(null);
                    }
                });

                bEq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       n2 = Float.parseFloat(edittext.getText() + "");

                        if (Addition == true) {
                            edittext.setText(n1 + n2 + "");
                            Addition = false;
                        }

                        if (Subtract == true) {
                           edittext.setText(n1 - n2 + "" );
                            Subtract = false;
                        }

                        if (Multiplication == true) {
                            edittext.setText(n1 * n2+ "" );
                           Multiplication = false;
                        }

                        if (Division == true) {
                            edittext.setText(n1 / n2 + "");
                            Division = false;
                        }
                    }
                });

                bC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       edittext.setText("");
                    }
                });

                bDec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edittext.setText(edittext.getText() + ".");
                    }
                });
            }
        }

