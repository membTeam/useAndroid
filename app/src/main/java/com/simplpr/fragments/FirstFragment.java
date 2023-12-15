package com.simplpr.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.simplpr.R;
import com.simplpr.UserApiResponse;
import com.simplpr.UserService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private TextView textView;
    private LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btnFrFirst = view.findViewById(R.id.btnFrFirst);
        btnFrFirst.setOnClickListener(this);

        linearLayout = view.findViewById(R.id.firstFrLinearLayout);
        textView = view.findViewById(R.id.textViewResult);


        return view;
    }

    /*
    request: https://reqres.in/api/users/2

    {"data":{"id":2,"email":"janet.weaver@reqres.in",
    "first_name":"Janet",
    "last_name":"Weaver",
    "avatar":"https://reqres.in/img/faces/2-image.jpg"},

    "support":{"url":"https://reqres.in/#support-heading",
    "text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}
    https://reqres.in/api/unknown


    android.os.NetworkOnMainThreadException

     */

    @Override
    public void onClick(View v) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<UserApiResponse> callSync = service.getUser(2);

        TextView textView = linearLayout.findViewById(R.id.textViewResult);

        try {
            Response<UserApiResponse> response = callSync.execute();
            UserApiResponse apiResponse = response.body();
            String strForTextView = String.valueOf(apiResponse);

            textView.setText(strForTextView);

        } catch (Exception ex) {
            String sErr = ex.getMessage();
            if (sErr == null) {
                sErr = "null data error";
            } else {
                sErr = "err: " + sErr;
            }

            textView.setText(sErr);

        }

        /*AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Окно отладки")
                .setMessage("Проверочное сообщение")
                .setCancelable(true);

        AlertDialog dialog = builder.create();
        dialog.show();*/

    }
}