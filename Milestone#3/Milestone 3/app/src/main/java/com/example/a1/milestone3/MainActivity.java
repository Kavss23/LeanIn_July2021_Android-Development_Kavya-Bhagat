package com.example.a1.milestone3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

 CardView FoodCard,SportCard,RetailCard,EntertainmentCard,TravelCard;
     Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodCard = (CardView) findViewById(R.id.food);
        SportCard = (CardView) findViewById(R.id.sport);
        RetailCard = (CardView) findViewById(R.id.retail);
        EntertainmentCard = (CardView) findViewById(R.id.entertainment);
        TravelCard = (CardView) findViewById(R.id.travel);

        next =  findViewById(R.id.move);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
            }
        });

        FoodCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FoodCard.setBackgroundResource(R.drawable.gradient);
            }
        });

        RetailCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetailCard.setBackgroundResource(R.drawable.gradient);
            }
        });
        SportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportCard.setBackgroundResource(R.drawable.gradient);
            }
        });
        TravelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TravelCard.setBackgroundResource(R.drawable.gradient);
            }
        });
        EntertainmentCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EntertainmentCard.setBackgroundResource(R.drawable.gradient);
            }
        });


    }


    }




