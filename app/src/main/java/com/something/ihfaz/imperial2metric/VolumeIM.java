package com.something.ihfaz.imperial2metric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VolumeIM extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch(Exception e) {
                return -1;
            }
        } else
            return 0.000;
    }

    TextView inputUnit;
    TextView outputUnit;
    EditText input;
    TextView output;
    double inValue = 0.000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_im);

        inputUnit = (TextView) findViewById(R.id.tvInputUnit);
        input = (EditText) findViewById(R.id.etInput);
        outputUnit = (TextView) findViewById(R.id.tvOutputUnit);
        output = (TextView) findViewById(R.id.tvOutput);

        Spinner volIMOptions = (Spinner) findViewById(R.id.volIMOptions);

        ArrayAdapter<String> volAdapter = new ArrayAdapter<String>(VolumeIM.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.volumeIM));
        volAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volIMOptions.setAdapter(volAdapter);

        volIMOptions.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        output.setText("0.000");

        switch(position){
            case 0:
                input.setEnabled(false);
                input.setFocusable(false);
                inputUnit.setText(" - ");
                outputUnit.setText(" - ");
                inValue = 0.000;
                break;
            case 1:
                input.setEnabled(true);
                input.setFocusableInTouchMode(true);
                Toast.makeText(parent.getContext(), "Fluid Ounces to Milliliters", Toast.LENGTH_SHORT).show();
                inputUnit.setText("fl oz");
                outputUnit.setText("ml");
                inValue = 29.5735 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 29.5735 * ParseDouble(input.getText().toString());
                        output.setText(Double.toString(inValue));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                break;
            case 2:
                input.setEnabled(true);
                input.setFocusableInTouchMode(true);
                Toast.makeText(parent.getContext(), "Pints to Milliliters", Toast.LENGTH_SHORT).show();
                inputUnit.setText("pt");
                outputUnit.setText("ml");
                inValue = 473.176 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 473.176 * ParseDouble(input.getText().toString());
                        output.setText(Double.toString(inValue));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                break;
            case 3:
                input.setEnabled(true);
                input.setFocusableInTouchMode(true);
                Toast.makeText(parent.getContext(), "Pints to Liters", Toast.LENGTH_SHORT).show();
                inputUnit.setText("pt");
                outputUnit.setText("l");
                inValue = 0.4732 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 0.4732 * ParseDouble(input.getText().toString());
                        output.setText(Double.toString(inValue));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                break;
            case 4:
                input.setEnabled(true);
                input.setFocusableInTouchMode(true);
                Toast.makeText(parent.getContext(), "Quarts to Liters", Toast.LENGTH_SHORT).show();
                inputUnit.setText("qt");
                outputUnit.setText("l");
                inValue = 0.94635 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 0.94635 * ParseDouble(input.getText().toString());
                        output.setText(Double.toString(inValue));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                break;
            case 5:
                input.setEnabled(true);
                input.setFocusableInTouchMode(true);
                Toast.makeText(parent.getContext(), "Gallons to Liters", Toast.LENGTH_SHORT).show();
                inputUnit.setText("gal");
                outputUnit.setText("l");
                inValue = 3.7854 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 3.7854 * ParseDouble(input.getText().toString());
                        output.setText(Double.toString(inValue));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        output.setText("0.000");
    }
}
