package ca.bcit.ass1.chriskwon_taranrai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.MenuItem;
import android.content.Intent;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();
        double convertedValue = bundle.getDouble("convertedValue");
        String choice1 = bundle.getString("choice1");
        String choice2 = bundle.getString("choice2");
        double enteredValue = bundle.getDouble("enteredValue");
        TextView tv = (TextView) findViewById(R.id.textView3);
        tv.setText(enteredValue + " " + choice1 + " converts to " + String.format("%.2f", convertedValue) + " " + choice2);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), InputActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
