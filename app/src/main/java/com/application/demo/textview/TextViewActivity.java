package com.application.demo.textview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.application.demo.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        tv = findViewById(R.id.textview_id);
        initTextSize();
        initTextAllCaps();
        initTextIsSelectable();
        initTextStyle();
    }

    private void initTextStyle() {
        CheckBox cb1 = findViewById(R.id.cbTextStyleNormal);
        CheckBox cb2 = findViewById(R.id.cbTextStyleItalic);
        CheckBox cb3 = findViewById(R.id.cbTextStyleBold);

    }

    private void initTextIsSelectable() {
        SwitchCompat sc = findViewById(R.id.scTextIsSelectable);
        sc.setOnCheckedChangeListener((buttonView, isChecked) -> tv.setTextIsSelectable(isChecked));
    }

    private void initTextAllCaps() {
        SwitchCompat sc = findViewById(R.id.scTextAllCaps);
        sc.setOnCheckedChangeListener((buttonView, isChecked) -> tv.setAllCaps(isChecked));
    }

    private void initTextSize() {
        TextView tvTextSize = findViewById(R.id.tvTextSize);
        SeekBar sb = findViewById(R.id.sbTextSize);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTextSize.setText(progress + "sp");
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
