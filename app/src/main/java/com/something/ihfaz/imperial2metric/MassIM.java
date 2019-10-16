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

public class MassIM extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

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
        setContentView(R.layout.activity_mass_im);

        inputUnit = (TextView) findViewById(R.id.tvInputUnit);
        input = (EditText) findViewById(R.id.etInput);
        outputUnit = (TextView) findViewById(R.id.tvOutputUnit);
        output = (TextView) findViewById(R.id.tvOutput);

        Spinner massIMOptions = (Spinner) findViewById(R.id.massIMOptions);

        ArrayAdapter<String> massAdapter = new ArrayAdapter<String>(MassIM.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.massIM));
        massAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        massIMOptions.setAdapter(massAdapter);

        massIMOptions.setOnItemSelectedListener(this);
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
                Toast.makeText(parent.getContext(), "Ounces to Grams", Toast.LENGTH_SHORT).show();
                inputUnit.setText("oz");
                outputUnit.setText("g");
                inValue = 28.3495 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 28.3495 * ParseDouble(input.getText().toString());
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
                Toast.makeText(parent.getContext(), "Pounds to Kilograms", Toast.LENGTH_SHORT).show();
                inputUnit.setText("lb");
                outputUnit.setText("kg");
                inValue = 0.453592 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 0.453592 * ParseDouble(input.getText().toString());
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
                Toast.makeText(parent.getContext(), "Stones to Kilograms", Toast.LENGTH_SHORT).show();
                inputUnit.setText("st");
                outputUnit.setText("kg");
                inValue = 6.35029 * ParseDouble(input.getText().toString());
                output.setText(Double.toString(inValue));

                input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        inValue = 6.35029 * ParseDouble(input.getText().toString());
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
