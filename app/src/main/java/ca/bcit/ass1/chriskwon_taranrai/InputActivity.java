package ca.bcit.ass1.chriskwon_taranrai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button yourButton = (Button) findViewById(R.id.button);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
                String selected = mySpinner.getSelectedItem().toString();
                String choice1 = "";
                String choice2 = "";
                EditText myEditText = (EditText) findViewById(R.id.editText);
                double enteredValue = Double.parseDouble(myEditText.getText().toString());
                double result = 0;
                if(selected.equalsIgnoreCase("Kilometers to Miles")) {
                    result = enteredValue*0.62137;
                    choice1 = "Kilometers";
                    choice2 = "Miles";
                } else if(selected.equalsIgnoreCase("Miles to Kilometers")) {
                    result = enteredValue*1.60934;
                    choice1 = "Miles";
                    choice2 = "Kilometers";
                } else if(selected.equalsIgnoreCase("Meters to Yards")) {
                    result = enteredValue*1.0936;
                    choice1 = "Meters";
                    choice2 = "Yards";
                } else if(selected.equalsIgnoreCase("Yards to Meters")) {
                    result = enteredValue*0.9144;
                    choice1 = "Yards";
                    choice2 = "Meters";
                } else if(selected.equalsIgnoreCase("Meters to Feet")) {
                    result = enteredValue*3.28;
                    choice1 = "Meters";
                    choice2 = "Feet";
                } else if(selected.equalsIgnoreCase("Feet to Meters")) {
                    result = enteredValue*0.3048;
                    choice1 = "Feet";
                    choice2 = "Meters";
                } else {

                }
                Bundle bundle = new Bundle();
                bundle.putDouble("convertedValue",result);
                bundle.putString("choice1",choice1);
                bundle.putString("choice2",choice2);
                bundle.putDouble("enteredValue",enteredValue);
                Intent i = new Intent(InputActivity.this, OutputActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
