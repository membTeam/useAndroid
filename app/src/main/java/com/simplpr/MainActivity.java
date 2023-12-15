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
import com.simplpr.utils.RunThread;

public class MainActivity extends AppCompatActivity {

    private Button btnNext, btnBack, restAPI;
    FirstFragment firstFragment = new FirstFragment();
    NextFragment nextFragment = new NextFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        restAPI = findViewById(R.id.btnRestApi);

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


        restAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultApi = "";

                RunThread runThread = new RunThread();
                runThread.thread.start();

                restAPI.setEnabled(false);

                try {
                    runThread.thread.join();
                    resultApi = RESTapi.getStrResult();
                } catch (InterruptedException ex) {
                    resultApi = "er: " + ex.getClass().getName();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Сообщение RESTapi")
                        .setMessage(resultApi)
                        .setCancelable(true);

                AlertDialog dialog = builder.create();
                dialog.show();

                restAPI.setEnabled(true);
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