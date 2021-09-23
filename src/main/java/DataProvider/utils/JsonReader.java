package DataProvider.utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static Object[][] getJSONData(String JSON_path, String JSON_data, int JSON_attributes) throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader(java.lang.String.valueOf((JSON_path))));
        JSONObject jo = (JSONObject) obj;
        JSONArray js = (JSONArray) jo.get(JSON_data);

        Object[][] arr = new String[js.size()][JSON_attributes];
        for(int i=0; i < js.size(); i++){
            JSONObject obj1 = (JSONObject) js.get(i);
            arr[i][0] = java.lang.String.valueOf(obj1.get("username"));
            arr[i][1] = java.lang.String.valueOf(obj1.get("password"));
        }
        return arr;
    }

}
