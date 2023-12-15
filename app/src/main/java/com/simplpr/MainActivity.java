package com.simplpr;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.simplpr.fragments.FirstFragment;
import com.simplpr.fragments.NextFragment;
import com.simplpr.utils.RESTapi;

public class MainActivity extends AppCompatActivity {

    private Button btnNext, btnBack, btnFrNext;
    FirstFragment firstFragment = new FirstFragment();
    NextFragment nextFragment = new NextFragment();


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

        Button restAPI = findViewById(R.id.btnRestApi);
        restAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultApi = RESTapi.methodGet();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Сообщение RESTapi")
                        .setMessage(resultApi)
                        .setCancelable(true);

                AlertDialog dialog = builder.create();
                dialog.show();
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