package com.msayeh.fragmentcat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorFragment firstColor = new ColorFragment(Colors.getAllColors());
        ColorFragment secondColor = new ColorFragment(Colors.getAllColors());
        ColorFragment thirdColor = new ColorFragment(Colors.getAllColors());

        getSupportFragmentManager().beginTransaction().add(R.id.first_color, firstColor).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.second_color, secondColor).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.third_color, thirdColor).commit();
    }
}

class Colors {
    private static List<Integer> colors = new ArrayList<Integer>(){{
        add(R.color.white);
        add(R.color.black);
        add(R.color.purple_200);
        add(R.color.purple_500);
        add(R.color.purple_700);
        add(R.color.teal_200);
        add(R.color.teal_700);
    }};

    public static List<Integer> getAllColors(){
        return colors;
    }

    public static Integer getRandomColor(){
        int i = new Random().nextInt(colors.size());
        return colors.get(i);
    }
}