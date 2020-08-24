package com.example.covid19apiinfo;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Covid19APIInstance {
    public static final String my_url="https://api.covid19api.com/";
    static Retrofit retrofit;
    public static Retrofit getInstance(){
        if (retrofit==null)
            retrofit=new Retrofit.Builder()
                     .baseUrl(my_url)
                     .addConverterFactory(ScalarsConverterFactory.create())
                     .build();
        return retrofit;
    }
}
