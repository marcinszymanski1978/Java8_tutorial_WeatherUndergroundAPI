import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http_Config_Datas {

    private String WU_url = "https://api.weather.com/v2/pws/observations/current";
    private String WU_station_ID = "?stationId=IMZJOZEF4";
    private String WU_data_output_format="&format=json";
    private String WU_unit_format = "&units=m";
    private String WU_API_key = "&apiKey=33c5c10bf42247d785c10bf42207d7b3";



    public String getLinkConnection_WU_URL(){

        StringBuilder url_coonnection = new StringBuilder();
        url_coonnection.append(WU_url).
                append(WU_station_ID).
                append(WU_data_output_format).
                append(WU_unit_format).
                append(WU_API_key);
        return url_coonnection.toString();
    }





    @Override
    public String toString() {
        return "Http_Config_Datas{" +
                "WU_url='" + WU_url + '\'' +
                ", WU_station_ID='" + WU_station_ID + '\'' +
                ", WU_data_output_format='" + WU_data_output_format + '\'' +
                ", WU_unit_format='" + WU_unit_format + '\'' +
                ", WU_API_key='" + WU_API_key + '\'' +
                '}';
    }
}
