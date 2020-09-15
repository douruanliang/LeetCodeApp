package com.github.leetcodeapp.imooc.nick.cardtestproject.api;



import com.github.leetcodeapp.http.api.ApiUtil;
import com.github.leetcodeapp.imooc.nick.cardtestproject.CardContants;
import com.github.leetcodeapp.imooc.nick.cardtestproject.bean.QuestionInfo;
import com.google.gson.Gson;

import org.json.JSONObject;

public class GetQuestionInfoApi extends ApiUtil {

    public QuestionInfo mInfo;
    @Override
    protected String getUrl() {
        return CardContants.URL+"/getQuestion";
    }

    @Override
    protected void parseData(JSONObject jsonObject) throws Exception {
        try {
            JSONObject data =  jsonObject.optJSONObject("data");
            JSONObject info =  data.optJSONObject("info");

            mInfo = new Gson().fromJson(info.toString(),QuestionInfo.class);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //todo
    public void loadlocalData(JSONObject jsonObject) {
        try {
            JSONObject data =  jsonObject.optJSONObject("data");
            JSONObject info =  data.optJSONObject("info");

            mInfo = new Gson().fromJson(info.toString(),QuestionInfo.class);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
