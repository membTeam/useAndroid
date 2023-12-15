package com.simplpr.utils;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
    request: https://reqres.in/api/users/2

    {"data":{"id":2,"email":"janet.weaver@reqres.in",
    "first_name":"Janet",
    "last_name":"Weaver",
    "avatar":"https://reqres.in/img/faces/2-image.jpg"},
    "support":{"url":"https://reqres.in/#support-heading",
    "text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}
    https://reqres.in/api/unknown

    show exception android.os.NetworkOnMainThreadException
     */

public class RESTapi {

    public static String methodGet() {

        String strResult;

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<UserApiResponse> callSync = service.getUser(2);

        try {
            Response<UserApiResponse> response = callSync.execute();
            UserApiResponse apiResponse = response.body();
            strResult = String.valueOf(apiResponse);

        } catch (Exception ex) {
            String sErr = ex.getMessage();
            if (sErr == null) {
                sErr = "error\n" + ex.getClass().getName();
            } else {
                sErr = "err: " + sErr;
            }

            strResult = sErr;
        }

        return strResult;
    }

}
