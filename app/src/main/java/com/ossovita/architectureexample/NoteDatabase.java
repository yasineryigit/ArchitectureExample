package com.ossovita.architectureexample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    //Singleton yapısında senkronize bir şekilde database objesine ulaşılacak.
    public static synchronized NoteDatabase getInstance(Context context){
        if(instance==null){//instance yoksa
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,NoteDatabase.class
                    ,"note_database")
                    .fallbackToDestructiveMigration()
                    .build();
            return instance;
        }else{//instance varsa
            return instance; //mevcut instance'i döndür
        }
    }
}
