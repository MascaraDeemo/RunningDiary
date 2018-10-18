package comp5216.sydney.edu.au.runningdiary;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "Stats")
public class Stat {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "statsID")
    private int statsID;

    @ColumnInfo(name = "stats")
    private String stats;

    public int getStatsID() {
        return statsID;
    }

    public void setStatsID(@NonNull int statsID) {
        this.statsID = statsID;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }


    public Stat(String stats){
        this.stats = stats;
    }
}
