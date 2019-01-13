package kr.tjit.apipractice;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.tjit.apipractice.utils.GlobalData;

public class MainActivity extends BaseActivity {

    private android.widget.TextView welcomMsgTxt;
    private de.hdodenhof.circleimageview.CircleImageView userProfileImgView;
    private android.widget.TextView userEmailTxt;
    private android.widget.TextView userPhoneTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        String welcomeMessage = String.format("%s님 환영합니다!", GlobalData.loginUser.getName());
        welcomMsgTxt.setText(welcomeMessage);

        userEmailTxt.setText(GlobalData.loginUser.getEmail());

        Log.d("프로필이미지", GlobalData.loginUser.getProfile_image());

        Glide.with(mContext).load(GlobalData.loginUser.getProfile_image()).into(userProfileImgView);

    }

    @Override
    public void bindViews() {
        this.userPhoneTxt = (TextView) findViewById(R.id.userPhoneTxt);
        this.userEmailTxt = (TextView) findViewById(R.id.userEmailTxt);
        this.userProfileImgView = (CircleImageView) findViewById(R.id.userProfileImgView);
        this.welcomMsgTxt = (TextView) findViewById(R.id.welcomMsgTxt);

    }
}
