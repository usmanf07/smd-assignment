package com.example.smdassign;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.GridView;
import java.util.ArrayList;


import androidx.appcompat.app.AppCompatActivity;

public class ScreenOneActivity extends AppCompatActivity {

    private LinearLayout tabOne;
    private LinearLayout tabTwo;
    private View indicator;

    private TextView profileName;
    private TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screenone);
        profileName = findViewById(R.id.profileName);
        userName = findViewById(R.id.etName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String firstName = extras.getString("firstName");
            String lastName = extras.getString("lastName");
            String email = extras.getString("email");
            if (firstName != null && lastName != null) {
                profileName.setText(firstName + " " + lastName);
                userName.setText(email);
            }
        }

        GridView gridView = findViewById(R.id.profileGridView);
        ArrayList<Integer> images = new ArrayList<>();

        images.add(R.drawable.image1);
        images.add(R.drawable.image2);
        images.add(R.drawable.image3);
        images.add(R.drawable.image4);
        images.add(R.drawable.image12);
        images.add(R.drawable.image5);
        images.add(R.drawable.image6);
        images.add(R.drawable.image7);
        images.add(R.drawable.image8);
        images.add(R.drawable.image9);
        images.add(R.drawable.image10);
        images.add(R.drawable.image11);
        ImageAdapter adapter = new ImageAdapter(this, images);
        gridView.setAdapter(adapter);


        ImageView backButton = findViewById(R.id.back_arrow);
        tabOne = findViewById(R.id.tabOne);
        tabTwo = findViewById(R.id.tabTwo);
        indicator = findViewById(R.id.indicator);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tabOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(v);
            }
        });

        tabTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(v);
            }
        });
    }

    public void selectTab(View view) {

        TextView tabOneView = findViewById(R.id.taboneview);
        RelativeLayout tabTwoView = findViewById(R.id.tabtwoview);

        if (view.getId() == R.id.tabOne) {
            tabTwoView.setVisibility(View.GONE);
            indicator.setTranslationX(tabOne.getX() + (tabOne.getWidth() - indicator.getWidth()) );
            indicator.setVisibility(View.VISIBLE);
            tabOneView.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.tabTwo) {
            tabTwoView.setVisibility(View.VISIBLE);
            tabOneView.setVisibility(View.GONE);
            indicator.setTranslationX(tabTwo.getX() + (tabTwo.getWidth() - indicator.getWidth()) / 17);
            indicator.setVisibility(View.VISIBLE);
        }
    }




}
