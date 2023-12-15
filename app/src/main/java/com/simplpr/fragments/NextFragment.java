package com.simplpr.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.simplpr.R;

public class NextFragment extends Fragment implements OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_next, container, false);

        Button btnRunDialog = (Button) view.findViewById(R.id.btnRunDialog);
        Button btnRunInMainActivity = (Button) view.findViewById(R.id.btnRunInMainActivity);

        btnRunInMainActivity.setOnClickListener(this);

        btnRunDialog.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Button btnId = (Button) v;
        String strMessage;

        Integer id = v.getId();

        if (id == R.id.btnRunInMainActivity) {
            strMessage = "btnRunInMainActivity";
        } else if (id == R.id.btnRunDialog) {
            strMessage = "btnRunDialog";
        } else if (v.getId() == R.id.btnRunInMainActivity) {
            strMessage = "btnRunInMainActivity";
        } else {
            strMessage = "Не опознана";
        }

        strMessage = "Id button: " + strMessage;

        Toast.makeText(getContext(), strMessage, Toast.LENGTH_LONG).show();
    }
}