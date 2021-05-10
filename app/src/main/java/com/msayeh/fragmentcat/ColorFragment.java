package com.msayeh.fragmentcat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorFragment extends Fragment {

    ArrayList<Integer> colors;
    int colorIndex;
    FrameLayout frameLayout;

    public ColorFragment(List<Integer> colors){
        this.colors = (ArrayList<Integer>) colors;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        colorIndex = new Random().nextInt(colors.size());
        frameLayout = view.findViewById(R.id.color_container);
        setBackgroundColor();

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(colorIndex < colors.size() - 1){
                    colorIndex++;
                }else {
                    colorIndex = 0;
                }
                setBackgroundColor();
            }
        });
    }

    void setBackgroundColor(){
        frameLayout.setBackgroundColor(ContextCompat.getColor(getContext().getApplicationContext(), colors.get(colorIndex)));
    }
}