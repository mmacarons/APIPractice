package kr.tjit.apipractice.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Bank implements Serializable {

    private int id;
    private int code;
    private String bankName;
    private String logoUrl;

    public static Bank getBankFromJson(JSONObject bankJson) {
        Bank bank = new Bank();

        try {

            bank.setId(bankJson.getInt("id"));
            bank.setCode(bankJson.getInt("code"));
            bank.setBankName(bankJson.getString("name"));
            bank.setLogoUrl(bankJson.getString("logo"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bank;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
