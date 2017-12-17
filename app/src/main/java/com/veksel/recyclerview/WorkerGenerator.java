package com.veksel.recyclerview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Veksel on 12/17/2017.
 */

public class WorkerGenerator {
    private static List<String> maleNames = new ArrayList<>(Arrays.asList("John", "Bill", "Bob", "Oliver", "Jack", "Harry", "George", "William", "Henry"));
    private static List<String> femaleNames = new ArrayList<>(Arrays.asList("Anna", "Emma", "Sophie", "Jessica", "Scarlett", "Molly", "Lucy", "Megan"));
    private static List<String> surnames = new ArrayList<>(Arrays.asList("Green", "Smith", "Taylor", "Brown", "Wilson", "Walker", "White", "Jackson", "Wood"));
    private static List<Integer> femalePhoto = new ArrayList<>(Arrays.asList(R.drawable.f1 , R.drawable.f2, R.drawable.f3 , R.drawable.f4, R.drawable.f5 , R.drawable.f6, R.drawable.f7));
    private static List<Integer> malePhoto = new ArrayList<>(Arrays.asList(R.drawable.m1 , R.drawable.m2, R.drawable.m3 , R.drawable.m4, R.drawable.m5 , R.drawable.m6));
    private static List<String> positions = new ArrayList<>(Arrays.asList("Android programmer", "iOs programmer", "Web programmer", "Designer"));
    public static Worker generateWorker(){
        Worker worker = new Worker();
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(2);
        if (index == 0) {
            index = randomGenerator.nextInt(maleNames.size());
            String randomName = maleNames.get(index);
            index = randomGenerator.nextInt(surnames.size());
            String randomSurname = surnames.get(index);
            worker.setName(randomName + " " + randomSurname);
            index = randomGenerator.nextInt(malePhoto.size());
            Integer randomPhoto = malePhoto.get(index);
            worker.setPhoto(randomPhoto);
        } else {
            index = randomGenerator.nextInt(femaleNames.size());
            String randomName = femaleNames.get(index);
            index = randomGenerator.nextInt(surnames.size());
            String randomSurname = surnames.get(index);
            worker.setName(randomName + " " + randomSurname);
            index = randomGenerator.nextInt(femalePhoto.size());
            Integer randomPhoto = femalePhoto.get(index);
            worker.setPhoto(randomPhoto);
        }
        worker.setAge(Integer.toString(21 + randomGenerator.nextInt(6)));
        index = randomGenerator.nextInt(positions.size());
        worker.setPosition(positions.get(index));
        return worker;
    }
}
