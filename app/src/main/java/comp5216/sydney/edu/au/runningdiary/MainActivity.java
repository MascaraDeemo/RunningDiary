package comp5216.sydney.edu.au.runningdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button paceCal = (Button) findViewById(R.id.paceCalBtn);
        paceCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paceIntent = new Intent();
                paceIntent.setClass(MainActivity.this, PaceCalculator.class);
                startActivity(paceIntent);
            }
        });

        Button tracker = (Button) findViewById(R.id.mapTracker);
        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent();
                mapIntent.setClass(MainActivity.this, MapsActivity.class);
                startActivity(mapIntent);
            }
        });

        Button log = (Button) findViewById(R.id.runningLog);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logIntent = new Intent();
                logIntent.setClass(MainActivity.this, RunningLog.class);
                startActivity(logIntent);
            }
        });

        final Button music = (Button) findViewById(R.id.musicButton);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musicIntent = new Intent();
                musicIntent.setClass(MainActivity.this, MusicActivity.class);
                startActivity(musicIntent);
            }
        });
    }



}
