package com.aakash.assignmenttwo6thsemester;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static android.text.TextUtils.isEmpty;

public class ChooseAction extends Fragment {

    View v;

    EditText email;
    Button validate;

    myInterface myInterface;
    LinearLayout dynamicContainer;
    View newView;

    LinearLayout parentLayout;
    OrientationEventListener orientationEventListener;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.perform_validation, container, false);

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

        newView = inflater.inflate(R.layout.image_control, null);

        dynamicContainer = v.findViewById(R.id.dynamicContainer);
        email = v.findViewById(R.id.email);
        validate = v.findViewById(R.id.validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setError(null);
                String uName = email.getText().toString();
                boolean cancel = false;
                View focusView = null;

                if (isEmpty(uName)) {
                    email.setError("Field required!");
                    focusView = email;
                    cancel = true;
                } else if (!(uName.contains("@user"))){
                    email.setError("Invalid user!");
                    focusView = email;
                    cancel = true;
                }

                if (cancel){
                    focusView.requestFocus();
                } else {
                    myInterface.onButtonPressed(uName, null);

                    ((LinearLayout)v.getParent()).removeView(v);

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    ImageControl newFrag = new ImageControl();
                    fragmentTransaction.add(R.id.dynamicContainer, newFrag, null);
                    fragmentTransaction.commit();

                    //dynamicContainer.addView(newView);
                }
            }
        });
        return v;
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
