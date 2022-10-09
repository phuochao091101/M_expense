package com.comp1786.m_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.comp1786.m_expense.model.Trip;
import com.comp1786.m_expense.model.Type;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class IntroductionActivity extends AppCompatActivity {

    Button startBtn;
    ImageView appLogo;
    LottieAnimationView Shape;
    Timer timer;
    int totaltrip,totalexpense =0;
    float totalamount=0f;
    public ArrayList<Trip> trips=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        DatabaseHelper ob=new DatabaseHelper(this);
        totaltrip = ob.getListTrip().size();
        totalexpense = ob.getListExpense().size();
        totalamount = ob.getTotalExpenses();

        System.out.println("total"+totaltrip);
//        Type type=new Type(1,"none");
//        ob.addType(type);
//        Trip trip=new Trip(1,"none","none","2022/09/20","2022/09/20",1,"none",1);
//        ob.addTrip(trip);
        trips=ob.getListTrip();
        System.out.println(ob.getListTrip().toString());
        startBtn = findViewById(R.id.btnStart);
        appLogo = findViewById(R.id.appLogo);
        Shape = findViewById(R.id.lottieAnimationView);


        startBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){

                startBtn.animate().translationY(1600).setDuration(1000);
                appLogo.animate().translationY(-3600).setDuration(1000).setStartDelay(700);
                Shape.animate().translationY(1900).setDuration(1000).setStartDelay(500);
                timer= new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(IntroductionActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                },1300);

            }
        });
    }
}