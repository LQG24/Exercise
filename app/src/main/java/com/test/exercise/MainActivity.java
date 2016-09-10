package com.test.exercise;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_register;
    private TextView tv;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = (Button) findViewById(R.id.bt_main_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_SHORT).show();
            }
        });
        btn_register = (Button) findViewById(R.id.bt_main_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "注册", Toast.LENGTH_SHORT).show();
            }
        });
        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);
        jump();
        vlueAnim();
        objectAnim();
    }

    private void objectAnim() {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(tv1, "alpha", 0.5f, 1f, 0.5f, 1f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(tv1, "rotation", 0f, 360f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(tv1, "scaleY", 1f, 3f, 1f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(tv1, "translationY", 0f, -100f);
//        ObjectAnimator anim4 = ObjectAnimator.ofFloat(tv1, "translationX", 0f, 50f); //X轴平移
        AnimatorSet animset = new AnimatorSet(); //定义一个AnimatorSet对象
        animset.play(anim1).with(anim2).with(anim3).after(anim4);  //先执行anim1和anim2，再执行anim3,再执行anim4
        animset.setDuration(6000);
        animset.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
//        animset.setInterpolator(new OvershootInterpolator());
        animset.start();
    }

    private void vlueAnim() {
        ValueAnimator anmator = ValueAnimator.ofFloat(0f, 1f, 0f, 1f);
        anmator.setDuration(5000);
        anmator.setRepeatCount(3);
        anmator.setRepeatMode(ValueAnimator.RESTART);
        anmator.start();
    }

    private void jump() {
        TranslateAnimation down = new TranslateAnimation(0, 0, -300, 0);//位移动画，从button的上方300像素位置开始
        down.setFillAfter(true);//设置动画固定结束后位置
        down.setInterpolator(new BounceInterpolator()); //弹跳动画,要其它效果的当然也可以设置为其它的值
        down.setDuration(2000); //持续时间
        btn_login.startAnimation(down);
        btn_register.startAnimation(down);
    }

    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "复合动画", Toast.LENGTH_SHORT).show();
    }
}
