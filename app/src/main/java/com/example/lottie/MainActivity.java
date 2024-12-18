package com.example.lottie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {


    public final static int TIMER=1000;
    RelativeLayout button;
    TextView textView;
    LottieAnimationView lottieAnimationView;

    Toast toastAnimation;
    TextView toastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        lottieAnimationView=findViewById(R.id.lottie);

        toastAnimation=new Toast(this);
//        Convert the layout into View
        View view=getLayoutInflater().inflate(R.layout.toast_view,findViewById(R.id.toastView));
        toastAnimation.setView(view);
//        set the text in toast
        toastText=view.findViewById(R.id.toast_text);
        toastText.setText("Moving to next Activity");
//        set Toast duration
        toastAnimation.setDuration(Toast.LENGTH_SHORT);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                make lottie animation visible
                lottieAnimationView.setVisibility(View.VISIBLE);
                lottieAnimationView.playAnimation();

//                make textView gone
                textView.setVisibility(View.GONE);
//                Handler
                new Handler().postDelayed(this::resetButton,TIMER);
                //                Show the toast
                toastAnimation.show();
            }

            private void resetButton() {
//                make lottie animation gone
                lottieAnimationView.pauseAnimation();
                lottieAnimationView.setVisibility(View.GONE);
//                make Text visible
                textView.setVisibility(View.VISIBLE);

//                start new activity
                startActivity(new Intent(MainActivity.this,MainActivity2.class));

            }
        });

    }
}