package com.veksel.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Veksel on 12/17/2017.
 */

public class Preferences {

    private static final String WORKER_DATA = "worker_data";

    private SharedPreferences mSettings;

    public Preferences(Context context) {
        mSettings = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setWorkers(List<Worker> w){
        Gson gson = new Gson();
        String jsonStr = gson.toJson(w);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(WORKER_DATA, jsonStr);
        editor.apply();
    }

    public List<Worker> getWorkers(){
        Gson gson = new Gson();
        String jsonStr = mSettings.getString(WORKER_DATA, null);
        Type listType = new TypeToken<List<Worker>>(){}.getType();
        if (gson.fromJson(jsonStr, listType) == null)
            return new ArrayList<>();
        else
            return (List<Worker>) gson.fromJson(jsonStr, listType);
    }

    public void addWorker(Worker worker){
        int maxId = 0;
        List<Worker> workers = getWorkers();
        if (workers == null)
            workers = new ArrayList<>();
        for (Worker w : workers){
            if (w.getId() > maxId)
                maxId = w.getId();
        }
        worker.setId(maxId + 1);
        workers.add(worker);
        setWorkers(workers);
    }

    public void deleteWorker(int position){
        List<Worker> workers = getWorkers();
        workers.remove(position);
        setWorkers(workers);
    }
}

