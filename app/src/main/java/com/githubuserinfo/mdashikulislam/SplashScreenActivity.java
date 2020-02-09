package com.githubuserinfo.mdashikulislam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {


    private Animation logoAnim, nameAnim;
    private ImageView logoImage;
    private  TextView nameText;

    public static int SPASH_SCREEN_TIMEOUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Load Animation from Animation layout
        logoAnim = AnimationUtils.loadAnimation(this,R.anim.logo_anim);
        nameAnim = AnimationUtils.loadAnimation(this,R.anim.name_anim);

        //Content Id attach
        logoImage = findViewById(R.id.splashLogo);
        nameText = findViewById(R.id.nameId);
        //Start Animation
        logoImage.setAnimation(logoAnim);
        nameText.setAnimation(nameAnim);

        //Splash Screen Function

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(home);
                finish();
            }
        },SPASH_SCREEN_TIMEOUT);
    }
}
