package comp5216.sydney.edu.au.runningdiary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Stat.class},version = 1,exportSchema = false)
public abstract class StatDB extends RoomDatabase{
    private static final String DATABASE_NAME = "stats_db";
    private static StatDB statDB;

    public abstract StatDAO statDAO();

    public static StatDB getDatabase(Context context){
        if(statDB == null){
            synchronized (StatDB.class){
                statDB = Room.databaseBuilder(context.getApplicationContext(),StatDB.class,DATABASE_NAME).build();
            }

        }
        return statDB;
    }

    public static void destroyInstance(){
        statDB = null;
    }



}
