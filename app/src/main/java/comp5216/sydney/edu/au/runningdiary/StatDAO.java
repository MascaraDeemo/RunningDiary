package comp5216.sydney.edu.au.runningdiary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StatDAO {
    @Query("SELECT * FROM stats")
    List<Stat> listAll();

    @Insert
    void insert(Stat stat);
}
