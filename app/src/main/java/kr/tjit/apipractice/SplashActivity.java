package kr.tjit.apipractice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import kr.tjit.apipractice.datas.User;
import kr.tjit.apipractice.utils.ConnectServer;
import kr.tjit.apipractice.utils.ContextUtil;
import kr.tjit.apipractice.utils.GlobalData;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ContextUtil.getToken(mContext).equals("")) {
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                    GlobalData.token = ContextUtil.getToken(mContext);

                    ConnectServer.getRequestMyInfo(mContext, new ConnectServer.JsonResponseHandler() {
                        @Override
                        public void onResponse(JSONObject json) {
                            Log.d("내정보응답", json.toString());
                            try {
                                JSONObject data = json.getJSONObject("data");
                                JSONObject user = data.getJSONObject("user");

//                                JSONObject => User클래스로 파싱
                                User userObject = User.getUserFromJson(user);
                                GlobalData.loginUser = userObject;

                                Intent intent = new Intent(mContext, MainActivity.class);
                                startActivity(intent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });




                }
            }
        }, 1500);

    }

    @Override
    public void bindViews() {

    }
}
