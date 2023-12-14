package com.simplpr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.simplpr.fragments.FirstFragment;
import com.simplpr.fragments.NextFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnNext, btnBack, btnFrNext;
    FirstFragment firstFragment = new FirstFragment();
    NextFragment nextFragment = new NextFragment();


    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        setNewFragment(firstFragment);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(firstFragment);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextFragment nextFragment = new NextFragment();
                setNewFragment(nextFragment);
            }
        });
    }

    private void setNewFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment );
        ft.addToBackStack(null);
        ft.commit();
    }
}