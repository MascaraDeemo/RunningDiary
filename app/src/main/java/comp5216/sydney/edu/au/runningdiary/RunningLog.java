package comp5216.sydney.edu.au.runningdiary;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class RunningLog extends AppCompatActivity {

    ArrayList<String> stats;
    ArrayAdapter<String> adapter;
    StatDAO statDao;
    StatDB db;
    String data;
    ListView listView;
    Button backButton;
    Button generateButton;
    TextView report;
    double distance;
    double time;
    double pace;
    double speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_log);
        listView = (ListView) findViewById(R.id.listView);
        backButton = (Button) findViewById(R.id.backB);
        generateButton = (Button) findViewById(R.id.generateReport);
        report = (TextView) findViewById(R.id.reportView);
        db = StatDB.getDatabase(this.getApplication().getApplicationContext());
        statDao = db.statDAO();
        readItemsFromDatabase();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RunningLog.this, MainActivity.class);
                startActivity(intent);
            }
        });

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 0; distance = 0;
                calculate();
                time = Math.round(time/60.0* 100.0)/100.0;
                pace = Math.round(time/distance*100.0)/100.0;
                speed = Math.round(distance/time/60*100.0)/100.0;
                report.setText("Your total Running time this week is " + time + "min" + "\n" + "Your total Running distance this week is " + distance + "km"
                + "\nAverage Pace is " + pace + "min/km" + "\nAverage Speed is " + speed + "km/h");
            }
        });

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stats);
        listView.setAdapter(adapter);

    }


    private void calculate(){
        String[] splitS, tempS;
        String timeS;
        String distanceS;
        double tempTime;
        double tempDis;
        for(String i: stats){
             splitS = i.split("\n");
             tempS = splitS[0].split(" ");
             timeS = tempS[1];
             timeS = removeLastChar(timeS);
             tempTime = Double.parseDouble(timeS);
             time = time +tempTime;
             tempS = splitS[1].split(" ");
             distanceS = tempS[1];
             distanceS = removeLastChar(removeLastChar(distanceS));
             tempDis = Double.parseDouble(distanceS);
             distance = distance + tempDis;
        }

    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }


    private void readItemsFromDatabase(){
        try{
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids){
                    List<Stat> itemsfromDB= statDao.listAll();
                    stats = new ArrayList<String>();
                    if(itemsfromDB != null & itemsfromDB.size()>0){
                        for(Stat i:itemsfromDB){
                            stats.add(0,i.getStats());
                        }
                    }
                    return null;
                }
            }.execute().get();
        }catch (Exception ex){
            return;
        }
    }


}
