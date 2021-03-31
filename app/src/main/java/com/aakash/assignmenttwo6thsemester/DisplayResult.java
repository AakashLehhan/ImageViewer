package com.aakash.assignmenttwo6thsemester;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

public class DisplayResult extends Fragment {

    View v;
    TextView userInfo;
    ImageView selectedImage;
    LinearLayout parentLayout;
    OrientationEventListener orientationEventListener;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.display_result, container, false);

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

        return v;
    }

    void onFragmentInteraction(String msg, Integer id){
        if (msg != null){
            userInfo = v.findViewById(R.id.userInfo);
            userInfo.setText("Welcome, " + msg);
            userInfo.setTextSize(25);
        }

        if (id != null){
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), id, null);
            selectedImage = v.findViewById(R.id.selectedImage);
            selectedImage.setImageDrawable(drawable);
        }
    }

}
