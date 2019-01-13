package kr.tjit.apipractice;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kr.tjit.apipractice.adapters.BankAdapter;
import kr.tjit.apipractice.datas.Bank;
import kr.tjit.apipractice.utils.ConnectServer;

public class BankListActivity extends BaseActivity {

    List<Bank> bankList = new ArrayList<Bank>();
    BankAdapter mAdapter;


    private android.widget.ListView bankListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        mAdapter = new BankAdapter(mContext, bankList);
        bankListView.setAdapter(mAdapter);

        getBanksFromServer();


    }

    void getBanksFromServer() {

        ConnectServer.getRequestBanks(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                Log.d("은행목록", json.toString());

                try {
                    int code = json.getInt("code");

                    if (code == 200) {
                        JSONObject data = json.getJSONObject("data");
                        JSONArray banks = json.getJSONArray("banks");

                        for (int i=0; i<banks.length(); i++) {
                            JSONObject bankJson = banks.getJSONObject(i);

                            Bank bankObject = Bank.getBankFromJson(bankJson);
                            bankList.add(bankObject);

                        }
                        mAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void bindViews() {
        this.bankListView = (ListView) findViewById(R.id.bankListView);

    }
}
