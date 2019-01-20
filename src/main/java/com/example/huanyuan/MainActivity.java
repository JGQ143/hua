package com.example.huanyuan;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.myView);
        //属性动画
        //获取水平值
        float translationX = myView.getTranslationX();
        ObjectAnimator animator =  ObjectAnimator.ofFloat(myView,"translationX",translationX,630);
        float translationY = myView.getTranslationY();
        ObjectAnimator animator2 =  ObjectAnimator.ofFloat(myView,"translationY",translationY,1050);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animator).with(animator2);
        animSet.setDuration(4000);
        animSet.start();
        // 动画执行的监听回调事件
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // 动画结束
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                finish();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                // 动画开始
            }
        });
    }
}
