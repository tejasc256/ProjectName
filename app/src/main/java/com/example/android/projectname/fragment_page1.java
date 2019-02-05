package com.example.android.projectname;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.projectname.R;

public class fragment_page1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_page1,null);

        Button button1 = (Button) view.findViewById(R.id.EditProfileButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), EngineersRegistrationForm.class);
                startActivity(i1);
            }
        });

        Button button2 = (Button) view.findViewById(R.id.JobsButton);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getActivity(), SearchActivity.class);
                startActivity(i2);
            }
        });

        Button button3 = (Button) view.findViewById(R.id.AboutUsButton);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getActivity(), About_Us.class);
                startActivity(i3);
            }
        });

        Button button4 = (Button) view.findViewById(R.id.FaqButton);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getActivity(), FAQ.class);
                startActivity(i4);
            }
        });

        return view;
    }
}