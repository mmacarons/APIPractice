package kr.tjit.apipractice;

import android.os.Bundle;
import android.widget.ListView;

public class BankListActivity extends BaseActivity {

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

    }

    @Override
    public void bindViews() {
        this.bankListView = (ListView) findViewById(R.id.bankListView);

    }
}
