package com.something.ihfaz.imperial2metric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonIM;
    Button buttonMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonIM = (Button) findViewById(R.id.buttonI2M);
        buttonMI = (Button) findViewById(R.id.buttonM2I);

        buttonIM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIMOptions();
            }
        });

        buttonMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMIOptions();
            }
        });
    }

    void showIMOptions(){
        Intent intentIM = new Intent(this, IMActivity.class);
        startActivity(intentIM);
    }

    void showMIOptions(){
        Intent intentMI = new Intent(this, MIActivity.class);
        startActivity(intentMI);
    }
}
