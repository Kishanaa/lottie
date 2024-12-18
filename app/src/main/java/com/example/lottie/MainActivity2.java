package com.example.lottie;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity2 extends AppCompatActivity {

    boolean isSwitchOn=true;
    LottieAnimationView switchAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        switchAnimation=findViewById(R.id.switcher);

        switchAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSwitchOn){
                    switchAnimation.setMinAndMaxProgress(0.5f,1.0f);
                    switchAnimation.playAnimation();
                    isSwitchOn=false;
                }else {
                    switchAnimation.setMinAndMaxProgress(0.0f,0.5f);
                    switchAnimation.playAnimation();
                    isSwitchOn=true;
                }
            }
        });

    }
}