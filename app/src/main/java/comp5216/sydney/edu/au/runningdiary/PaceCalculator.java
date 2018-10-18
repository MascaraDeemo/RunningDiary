package comp5216.sydney.edu.au.runningdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaceCalculator extends AppCompatActivity {

    public double time, distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        Button goBack = (Button) findViewById(R.id.BackToMain);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PaceCalculator.this, MainActivity.class);
                startActivity(intent);

            }
        });

        final Button calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePaceAndSpeed();
            }
        });
    }


    public void getTimeAndDistance(){
        EditText timeEdit = (EditText) findViewById(R.id.timeEdit);
        EditText distanceEdit = (EditText) findViewById(R.id.distanceEdit);
        String timeS = timeEdit.getText().toString();
        String distanceS = distanceEdit.getText().toString();

        time = Double.parseDouble(timeS);
        distance = Double.parseDouble(distanceS);
    }

    public void calculatePaceAndSpeed(){
        getTimeAndDistance();
        double timeInHour = time/60;
        double speed = Math.round((distance/timeInHour)*100.0)/100.0;
        double pace = Math.round((time/distance)*100.0)/100.0;
        TextView speedText = (TextView) findViewById(R.id.speed);
        speedText.setText("Speed : " + speed + " km/h");
        TextView paceText = (TextView) findViewById(R.id.pace);
        paceText.setText("Pace : " + pace + " min/km");

    }
}
