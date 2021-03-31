package com.aakash.assignmenttwo6thsemester;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageControl extends Fragment {
    View v;
    GridView gv;

    ImageView one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen;
    Integer[] images = {R.drawable.icon_1,
            R.drawable.icon_2,
            R.drawable.icon_3,
            R.drawable.icon_4,
            R.drawable.icon_5,
            R.drawable.icon_6,
            R.drawable.icon_7,
            R.drawable.icon_8,
            R.drawable.icon_9,
            R.drawable.icon_10,
            R.drawable.icon_11,
            R.drawable.icon_12,
            R.drawable.icon_13,
            R.drawable.icon_14,
            R.drawable.icon_15,
            R.drawable.icon_16};

    myInterface myInterface;
    public static View prevImage;
    public static View nowImage;

    Button slideShow;

    Handler handler;
    Runnable runnable;
    int progress;

    LinearLayout parentLayout;
    OrientationEventListener orientationEventListener;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.image_control, container, false);

        parentLayout = v.findViewById(R.id.parentLayout);
        orientationEventListener = new OrientationEventListener(getContext()) {
            @Override
            public void onOrientationChanged(int orientation) {
                parentLayout.setOrientation(LinearLayout.VERTICAL);
                if (orientation == 90 || orientation == 270){
                    parentLayout.setOrientation(LinearLayout.HORIZONTAL);
                } else if (orientation == 0){
                    parentLayout.setOrientation(LinearLayout.VERTICAL);
                }
            }
        };

        slideShow = v.findViewById(R.id.slideShow);
        slideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevImage.setBackgroundResource(0);
                prevImage.setPadding(0, 0, 0, 0);
                progress = 0;
                View[] viewArr = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen};
                final Handler myHandler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (progress < 16){
                            nowImage = viewArr[progress];
                            if (progress == 0){
                                Drawable drawable = getResources().getDrawable(R.drawable.selected_image_bg);
                                one.setBackground(drawable);
                            } else {
                                applyBorder(prevImage, nowImage);
                            }
                            prevImage = nowImage;
                            myInterface.onButtonPressed(null, images[progress]);
                            progress += 1;
                        } else {
                            return;
                        }
                        myHandler.postDelayed(runnable, 1000);
                    }
                };
                myHandler.postDelayed(runnable, 50);
            }
        });

        one = v.findViewById(R.id.one);
        two = v.findViewById(R.id.two);
        three = v.findViewById(R.id.three);
        four = v.findViewById(R.id.four);
        five = v.findViewById(R.id.five);
        six = v.findViewById(R.id.six);
        seven = v.findViewById(R.id.seven);
        eight = v.findViewById(R.id.eight);
        nine = v.findViewById(R.id.nine);
        ten = v.findViewById(R.id.ten);
        eleven = v.findViewById(R.id.eleven);
        twelve = v.findViewById(R.id.twelve);
        thirteen = v.findViewById(R.id.thirteen);
        fourteen = v.findViewById(R.id.fourteen);
        fifteen = v.findViewById(R.id.fifteen);
        sixteen = v.findViewById(R.id.sixteen);

        prevImage = one;

        one.setOnClickListener(this::selectImage);
        two.setOnClickListener(this::selectImage);
        three.setOnClickListener(this::selectImage);
        four.setOnClickListener(this::selectImage);
        five.setOnClickListener(this::selectImage);
        six.setOnClickListener(this::selectImage);
        seven.setOnClickListener(this::selectImage);
        eight.setOnClickListener(this::selectImage);
        nine.setOnClickListener(this::selectImage);
        ten.setOnClickListener(this::selectImage);
        eleven.setOnClickListener(this::selectImage);
        twelve.setOnClickListener(this::selectImage);
        thirteen.setOnClickListener(this::selectImage);
        fourteen.setOnClickListener(this::selectImage);
        fifteen.setOnClickListener(this::selectImage);
        sixteen.setOnClickListener(this::selectImage);

        return v;
    }

    public void selectImage(View v){
        switch (v.getId()) {
            case R.id.one:
                myInterface.onButtonPressed(null, images[0]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.two:
                myInterface.onButtonPressed(null, images[1]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.three:
                myInterface.onButtonPressed(null, images[2]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.four:
                myInterface.onButtonPressed(null, images[3]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.five:
                myInterface.onButtonPressed(null, images[4]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.six:
                myInterface.onButtonPressed(null, images[5]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.seven:
                myInterface.onButtonPressed(null, images[6]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.eight:
                myInterface.onButtonPressed(null, images[7]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.nine:
                myInterface.onButtonPressed(null, images[8]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.ten:
                myInterface.onButtonPressed(null, images[9]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.eleven:
                myInterface.onButtonPressed(null, images[10]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.twelve:
                myInterface.onButtonPressed(null, images[11]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.thirteen:
                myInterface.onButtonPressed(null, images[12]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.fourteen:
                myInterface.onButtonPressed(null, images[13]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.fifteen:
                myInterface.onButtonPressed(null, images[14]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
            case R.id.sixteen:
                myInterface.onButtonPressed(null, images[15]);
                nowImage = v;
                applyBorder(prevImage, nowImage);
                prevImage = nowImage;
                break;
        }
    }

    public void applyBorder(View prevImage, View nowImage){
        prevImage.setBackgroundResource(0);
        prevImage.setPadding(0, 0, 0, 0);

        Drawable drawable = getResources().getDrawable(R.drawable.selected_image_bg);
        nowImage.setBackground(drawable);
    }

    @Override
    public void onStop(){
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            myInterface = (myInterface)getActivity();
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "Must implement onButtonPressedListener");
        }
    }
}
