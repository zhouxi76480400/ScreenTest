package me.zhouxi.screentest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class ScreenTestActivity extends AppCompatActivity implements View.OnTouchListener{

    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new View(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        setContentView(view);
        view.setOnTouchListener(this);
        hideNavigationBar();
        setColor();
    }

    private void setColor() {
        Intent intent = getIntent();
        if(intent == null)
            return;
        Bundle bundle = intent.getExtras();
        if(bundle == null)
            return;
        int r = bundle.getInt("r",0);
        int g = bundle.getInt("g",0);
        int b = bundle.getInt("b",0);
        view.setBackgroundColor(Color.rgb(r,g,b));
    }

    private void hideNavigationBar() {
        int flag = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        getWindow().setAttributes(params);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        hideNavigationBar();
        return false;
    }
}
