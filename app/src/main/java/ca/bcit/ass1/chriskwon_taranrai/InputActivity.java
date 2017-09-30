package ca.bcit.ass1.chriskwon_taranrai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button yourButton = (Button) findViewById(R.id.button);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
                String selected = mySpinner.getSelectedItem().toString();
                String choice1 = "";
                String choice2 = "";
                EditText myEditText = (EditText) findViewById(R.id.editText);
                if (myEditText.getText().toString().matches("")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(InputActivity.this).create();
                    alertDialog.setTitle(getResources().getString(R.string.alert));
                    alertDialog.setMessage(getResources().getString(R.string.alert_message));
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.ok),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    double enteredValue = Double.parseDouble(myEditText.getText().toString());
                    double result = 0;
                    if (selected.equalsIgnoreCase(getResources().getString(R.string.kilo_to_miles))) {
                        result = enteredValue * Double.parseDouble(getResources().getString(R.string.kilo_miles));
                        choice1 = getResources().getString(R.string.kilometers);
                        choice2 = getResources().getString(R.string.miles);
                    } else if (selected.equalsIgnoreCase(getResources().getString(R.string.miles_to_kilo))) {
                        result = enteredValue * Double.parseDouble(getResources().getString(R.string.miles_kilo));
                        choice1 = getResources().getString(R.string.miles);
                        choice2 = getResources().getString(R.string.kilometers);
                    } else if (selected.equalsIgnoreCase(getResources().getString(R.string.meters_to_yards))) {
                        result = enteredValue * Double.parseDouble(getResources().getString(R.string.meters_yards));
                        choice1 = getResources().getString(R.string.meters);
                        choice2 = getResources().getString(R.string.yards);
                    } else if (selected.equalsIgnoreCase(getResources().getString(R.string.yards_to_meters))) {
                        result = enteredValue * Double.parseDouble(getResources().getString(R.string.yards_meters));
                        choice1 = getResources().getString(R.string.yards);
                        choice2 = getResources().getString(R.string.meters);
                    } else if (selected.equalsIgnoreCase(getResources().getString(R.string.meters_to_feet))) {
                        result = enteredValue * Double.parseDouble(getResources().getString(R.string.meters_feet));
                        choice1 = getResources().getString(R.string.meters);
                        choice2 = getResources().getString(R.string.feet);
                    } else if (selected.equalsIgnoreCase(getResources().getString(R.string.feet_to_meters))) {
                        result = enteredValue * Double.parseDouble(getResources().getString(R.string.feet_meters));
                        choice1 = getResources().getString(R.string.feet);
                        choice2 = getResources().getString(R.string.meters);
                    } else {

                    }
                    Bundle bundle = new Bundle();
                    bundle.putDouble(getResources().getString(R.string.converted_val), result);
                    bundle.putString(getResources().getString(R.string.choice1), choice1);
                    bundle.putString(getResources().getString(R.string.choice2), choice2);
                    bundle.putDouble(getResources().getString(R.string.entered_val), enteredValue);
                    Intent i = new Intent(InputActivity.this, OutputActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });
    }
}