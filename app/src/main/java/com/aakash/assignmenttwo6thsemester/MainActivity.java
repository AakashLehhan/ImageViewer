package com.aakash.assignmenttwo6thsemester;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements myInterface{

    LinearLayout parentLayout, dynamicContainer, dynamicContainerTop;
    OrientationEventListener orientationEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLayout = findViewById(R.id.parentLayout);
        dynamicContainer = findViewById(R.id.dynamicContainer);
        dynamicContainerTop = findViewById(R.id.dynamicContainerTop);
        orientationEventListener = new OrientationEventListener(this) {
            @Override
            public void onOrientationChanged(int orientation) {
                parentLayout.setOrientation(LinearLayout.VERTICAL);
                if (orientation == 90 || orientation == 270){
                    dynamicContainer.setOrientation(LinearLayout.HORIZONTAL);
                    dynamicContainerTop.setOrientation(LinearLayout.HORIZONTAL);
                } else if (orientation == 0){
                    dynamicContainer.setOrientation(LinearLayout.VERTICAL);
                    dynamicContainerTop.setOrientation(LinearLayout.VERTICAL);
                }
            }
        };
    }

    @Override
    public void onButtonPressed(String string, Integer integer) {
        DisplayResult displayResult = (DisplayResult) getSupportFragmentManager().findFragmentById(R.id.fragOne);
        displayResult.onFragmentInteraction(string, integer);
    }
}