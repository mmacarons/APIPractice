package kr.tjit.apipractice.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectServer {

    private final static String serverURL = "http://13.124.249.254/";

    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }

    public static void postRequestSignIn(Context context,
                                        String user_id, String password,
                                        final JsonResponseHandler handler) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("user_id", user_id)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(serverURL + "auth")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("서버연결실패", e.toString());
            }

              @Override
            public void onResponse(Call call, Response response) throws IOException {

                String body = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(body);
                    if (handler != null) {
                        handler.onResponse(jsonObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    public static void postRequestLogin(Context context,
                                        String user_id, String password,
                                        final JsonResponseHandler handler) {

//        우리가 만드는 앱을 클라이언트로 활용
        OkHttpClient client = new OkHttpClient();

//        POST 메쏘드는 FormBody에 필요 데이터를 첨부.
        RequestBody requestBody = new FormBody.Builder()
                .add("user_id", user_id)
                .add("password", password)
                .build();

//        요청 자체를 생성. Request

        Request request = new Request.Builder()
                .url(serverURL + "auth")
                .post(requestBody)
                .build();


//        client를 이용해 실제로 서버에 접근
//        newCall 뒤로는 서버가 돌려주는 response에 대한 처리.

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("서버연결실패", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String body = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(body);
                    if (handler != null) {
                        handler.onResponse(jsonObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }

}
