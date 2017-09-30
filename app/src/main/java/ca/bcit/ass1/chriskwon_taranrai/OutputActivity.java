package ca.bcit.ass1.chriskwon_taranrai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;
import android.content.Intent;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button backButton = (Button) findViewById(R.id.button2);

        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(OutputActivity.this, InputActivity.class);
                startActivity(i);
            }
        });


        Bundle bundle = getIntent().getExtras();
        double convertedValue = bundle.getDouble(getResources().getString(R.string.converted_val));
        String choice1 = bundle.getString(getResources().getString(R.string.choice1));
        String choice2 = bundle.getString(getResources().getString(R.string.choice2));
        double enteredValue = bundle.getDouble(getResources().getString(R.string.entered_val));
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(String.format("%.2f", enteredValue) + " " + choice1 + " " + getResources().getString(R.string.converts_to) + " " + String.format("%.2f", convertedValue) + " " + choice2);
    }
    //NOTE: note that in most parts where Español is used, the decimal separator is a comma (source: https://spanish.stackexchange.com/questions/4159/how-to-read-a-decimal-number-in-spanish)
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), InputActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
