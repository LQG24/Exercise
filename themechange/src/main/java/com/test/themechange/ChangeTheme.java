package com.test.themechange;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by abc on 2016/9/12.
 */
public class ChangeTheme extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeChageUtil.changeTheme(this);
        setContentView(R.layout.activity_change);
        Button mChangeBtn = (Button) findViewById(R.id.btn_change);
        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ThemeChageUtil.isChange){
                    ThemeChageUtil.isChange = false;
                }else {
                    ThemeChageUtil.isChange = true;
                }
                ChangeTheme.this.recreate();   //重新创建当前activity实例
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
