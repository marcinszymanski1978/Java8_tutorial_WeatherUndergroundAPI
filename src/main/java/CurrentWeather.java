import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;


public class CurrentWeather {

    private static HashMap<String, Object> currentWeatherMap;




    public String connect(String url) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                httpURLConnection.getResponseCode() == 200
                        ? httpURLConnection.getInputStream():httpURLConnection.getErrorStream()));

        String line ="";

        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        bufferedReader.close();
        httpURLConnection.disconnect();



        return stringBuilder.toString();
    }

    public void printCurrentWeatherMap(HashMap map){

        ArrayList list = (ArrayList) map.get("observations");
        HashMap hashMap = (HashMap) list.get(0);
        HashMap subHashMap = (HashMap) hashMap.get("metric");
        hashMap.remove("metric");
        HashMap newHashMap = new HashMap();
        newHashMap.putAll(hashMap);
        newHashMap.putAll(subHashMap);

        newHashMap.forEach((o, o2) -> {System.out.println(o+"="+o2);
                                });
    }

    public void getTemp(String json){

        JSONObject jsonObject = new JSONObject(json).getJSONArray("observations").getJSONObject(0).getJSONObject("metric");
//        System.out.println(jsonObject);
        System.out.println(jsonObject.get("temp"));


//        System.out.println(jsonArray.length());
//        for (int i = 0; i < jsonArray.length(); i++) {
//
//            System.out.println(jsonArray.getJSONObject(i));
//        }
//        System.out.println(jsonArray.getJSONObject(0).get("country"));
//        System.out.println(jsonArray);
    }




    public static void main(String[] args) throws IOException {
        Http_Config_Datas httpConfigDatas = new Http_Config_Datas();

        String link = httpConfigDatas.getLinkConnection_WU_URL();

        CurrentWeather currentWeather = new CurrentWeather();
        String json = currentWeather.connect(link);
//        System.out.println(json);


        currentWeatherMap = new HashMap<>(Utility.jsonToMap(json)) ;



        currentWeather.printCurrentWeatherMap(currentWeatherMap);

//        currentWeather.getTemp(json);




    }


}
