package com.simplpr.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.simplpr.R;

public class FirstFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btnFrFirst = view.findViewById(R.id.btnFrFirst);
        btnFrFirst.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Сообщение")
                .setMessage("Проверочное сообщение")
                .setCancelable(true);

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}