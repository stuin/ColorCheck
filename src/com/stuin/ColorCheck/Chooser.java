package com.stuin.ColorCheck;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class Chooser extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooser);
        findViewById(R.id.MainLayout).setBackgroundColor(Color.BLACK);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        seekBar = (SeekBar) findViewById(R.id.Red);
        seekBar.setMax(255);
        seekBar.setBackgroundColor(Color.RED);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        seekBar = (SeekBar) findViewById(R.id.Green);
        seekBar.setMax(255);
        seekBar.setBackgroundColor(Color.GREEN);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        seekBar = (SeekBar) findViewById(R.id.Blue);
        seekBar.setMax(255);
        seekBar.setBackgroundColor(Color.BLUE);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        for(int i = 0; i < 8; i++) {
            View v = new View(this);
            switch(i) {
                case 0:
                    v = findViewById(R.id.Color1);
                    break;
                case 1:
                    v = findViewById(R.id.Color2);
                    break;
                case 2:
                    v = findViewById(R.id.Color3);
                    break;
                case 3:
                    v = findViewById(R.id.Color4);
                    break;
                case 4:
                    v = findViewById(R.id.Color5);
                    break;
                case 5:
                    v = findViewById(R.id.Color6);
                    break;
                case 6:
                    v = findViewById(R.id.Color7);
                    break;
                case 7:
                    v = findViewById(R.id.Color8);
                    break;
            }
            v.setBackgroundColor(findColor(i));
        }
    }

    public int findColor(int i) {
        String s = Integer.toBinaryString(i);
        while(s.length() < 3) s = "0" + s;

        int r = 0;
        if(s.charAt(0) == '1') r = 255;
        int g = 0;
        if(s.charAt(1) == '1') g = 255;
        int b = 0;
        if(s.charAt(2) == '1') b = 255;

        return Color.rgb(r,g,b);
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
            if(seekBar.getId() == R.id.seekBar) {
                findViewById(R.id.MainLayout).setBackgroundColor(findColor(i));
                seekBar.setBackgroundColor(findColor(i));

                seekBar = (SeekBar) findViewById(R.id.Red);
                seekBar.setProgress(Color.red(findColor(i)));
                seekBar = (SeekBar) findViewById(R.id.Green);
                seekBar.setProgress(Color.green(findColor(i)));
                seekBar = (SeekBar) findViewById(R.id.Blue);
                seekBar.setProgress(Color.blue(findColor(i)));
            }
            else {
                seekBar = (SeekBar) findViewById(R.id.Red);
                int r = seekBar.getProgress();
                seekBar = (SeekBar) findViewById(R.id.Green);
                int g = seekBar.getProgress();
                seekBar = (SeekBar) findViewById(R.id.Blue);
                int b = seekBar.getProgress();

                findViewById(R.id.MainLayout).setBackgroundColor(Color.rgb(r,g,b));
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };
}