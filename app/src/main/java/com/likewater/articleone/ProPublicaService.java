package com.likewater.articleone;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

public class ProPublicaService {

    public static void findReps(String chamber, String state, Callback callback){
        //OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.PRO_PUBLICA_KEY);

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        //urlBuilder.addPathSegment(chamber);
        //urlBuilder.addPathSegment(state);
        //urlBuilder.addPathSegment(Constants.BASE_URL_END);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .header(Constants.HEADER, Constants.PRO_PUBLICA_KEY)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
