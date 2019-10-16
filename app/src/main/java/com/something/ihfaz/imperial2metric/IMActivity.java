package com.something.ihfaz.imperial2metric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IMActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLength;
    Button bVolume;
    Button bMass;
    Button bTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im);

        bLength = (Button) findViewById(R.id.buttonL);
        bVolume = (Button) findViewById(R.id.buttonV);
        bMass = (Button) findViewById(R.id.buttonM);
        bTemp = (Button) findViewById(R.id.buttonT);

        bLength.setOnClickListener(this);
        bVolume.setOnClickListener(this);
        bMass.setOnClickListener(this);
        bTemp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonL:
                ToLengthOptions();
                break;
            case R.id.buttonV:
                ToVolumeOptions();
                break;
            case R.id.buttonM:
                ToMassOptions();
                break;
            case R.id.buttonT:
                ToTempOptions();
                break;
        }
    }

    void ToLengthOptions(){
        Intent intent = new Intent(IMActivity.this, LengthIM.class);
        startActivity(intent);
    }

    void ToVolumeOptions(){
        Intent intent = new Intent(IMActivity.this, VolumeIM.class);
        startActivity(intent);
    }

    void ToMassOptions(){
        Intent intent = new Intent(IMActivity.this, MassIM.class);
        startActivity(intent);
    }

    void ToTempOptions(){
        Intent intent = new Intent(IMActivity.this, TempIM.class);
        startActivity(intent);
    }
}
