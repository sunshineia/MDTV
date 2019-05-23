package com.example.mdtv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ChannelLab {
    private static ChannelLab instance;
    private List<String> tvs;
    private ChannelLab(){
        init ();
    }
    public static ChannelLab get(){
        if(null==instance){
            instance = new ChannelLab(); }
        return instance; }
    public int getSize(){
        return tvs.size ();
    }
    public String getTv(int n){
        return  tvs.get ( n );
    }
    public void init(){
        tvs = new ArrayList<String>(  );
        try {
            test(tvs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void test(List<String> tvs) throws IOException {
        ChannelJson json =new ChannelJson("data.json");//传文件进去
        JSONObject lan;
        JSONArray array = json.work("root");//指定json根路径
        for (int i = 0; i < array.length(); i++) {
            try {
                lan = array.getJSONObject(i);
                tvs.add(lan.getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}



