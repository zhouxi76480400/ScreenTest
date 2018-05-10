package me.zhouxi.screentest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,
    View.OnClickListener {

    private View v_preview;

    private TextView tv_r, tv_g, tv_b;

    private SeekBar sb_r, sb_g, sb_b;

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setSubtitle(getString(R.string.select_rgb_value));
        }
        v_preview = findViewById(R.id.v_preview);
        tv_r = findViewById(R.id.tv_r);
        tv_g = findViewById(R.id.tv_g);
        tv_b = findViewById(R.id.tv_b);
        sb_r = findViewById(R.id.sb_r);
        sb_g = findViewById(R.id.sb_g);
        sb_b = findViewById(R.id.sb_b);
        sb_r.setMax(255);
        sb_g.setMax(255);
        sb_b.setMax(255);
        sb_r.setOnSeekBarChangeListener(this);
        sb_g.setOnSeekBarChangeListener(this);
        sb_b.setOnSeekBarChangeListener(this);
        next = findViewById(R.id.btn_next);
        next.setOnClickListener(this);
        setPreview();
    }

    private void setPreview() {
        int r = sb_r.getProgress();
        int g = sb_g.getProgress();
        int b = sb_b.getProgress();
        int color = Color.rgb(r, g, b);
        tv_r.setText(String.valueOf(r));
        tv_g.setText(String.valueOf(g));
        tv_b.setText(String.valueOf(b));
        v_preview.setBackgroundColor(color);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        setPreview();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ScreenTestActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("r",sb_r.getProgress());
        bundle.putInt("g",sb_g.getProgress());
        bundle.putInt("b",sb_b.getProgress());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
