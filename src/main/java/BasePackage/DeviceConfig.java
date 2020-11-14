package BasePackage;

import com.google.gson.Gson;
import io.appium.java_client.AppiumDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class DeviceConfig {
    public static AppiumDriver<?> driver;
    public static String executionPlatform;
    public static JsonFileDataGetterSetter deviceConfig;

    public static synchronized String getExecutionPlatform() {
        return executionPlatform;
    }

    public synchronized void setExecutionPlatform(String executionPlatform) {
        DeviceConfig.executionPlatform = executionPlatform;
    }

//    public static JsonFileDataGetterSetter readWebConfig() throws IOException {
//        BufferedReader reader = null;
//        String filePath = System.getProperty("user.dir") + "/Data/data.json/";
//        reader = new BufferedReader(new FileReader(filePath));
//        Gson gson = new Gson();
//        JsonFileDataGetterSetter[] deviceConfig = gson.fromJson(reader, JsonFileDataGetterSetter[].class);
//        return new JsonFileDataGetterSetter(deviceConfig);
//    }

    public static JsonFileDataGetterSetter readConfig() throws IOException, ParseException {
//        BufferedReader reader = null;
//        BufferedReader reader;
/**        JsonReader reader=null;
 String filePath = System.getProperty("user.dir") + "/Data/data.json/";
 reader = new JsonReader(new FileReader(filePath));
 Gson gson = new GsonBuilder().setLenient().create();
 reader.beginArray();
 JsonFileDataGetterSetter deviceConfig = gson.fromJson(reader, JsonFileDataGetterSetter.class);**/


        /**    String filePath = System.getProperty("user.dir") + "/Data/data.json/";
         FileReader fileReader = new FileReader(filePath);
         try (JsonReader jsonReader = new JsonReader(fileReader)) {
         jsonReader.beginArray();
         //            jsonReader.beginObject();
         Gson gson = new Gson();
         while (jsonReader.hasNext()) {
         JsonFileDataGetterSetter deviceConfig = gson.fromJson(jsonReader, JsonFileDataGetterSetter.class);
         return deviceConfig;
         }
         //          jsonReader.skipValue();
         //            jsonReader.endObject();
         //            jsonReader.endArray();
         //            jsonReader.close();
         }
         //        catch (IllegalStateException | JsonSyntaxException exception)
         //        {exception.getCause();}
         return new JsonFileDataGetterSetter(deviceConfig);**/
        /** String filePath = System.getProperty("user.dir") + "/Data/data.json/";
         try {
         JsonElement jsonData = new JsonParser().parse(new FileReader(filePath));
         //            JsonElement deviceData = jsonData.getAsJsonObject().get("Device");
         JsonElement deviceData = jsonData.getAsJsonObject();
         JsonFileDataGetterSetter deviceConfig = new Gson().fromJson(deviceData, new TypeToken<JsonFileDataGetterSetter>() {
         }.getType());
         return deviceConfig;
         }
         catch (IllegalStateException | JsonSyntaxException exception)
         {exception.getCause();}
         return new JsonFileDataGetterSetter(deviceConfig);**/

        String filePath = System.getProperty("user.dir") + "/Data/data.json/";
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONArray deviceData = (JSONArray) obj;
//        System.out.println(deviceData);
        for (int i=0;i<deviceData.size();i++){

            JSONObject device = (JSONObject) deviceData.get(i);
//            JSONObject deviceConfig = (JSONObject) device.get("Device");
            JsonFileDataGetterSetter deviceConfig = new Gson().fromJson(device.toJSONString(), JsonFileDataGetterSetter.class);
//            JsonFileDataGetterSetter deviceConfig = new Gson().fromJson(device.toJSONString(), new TypeToken<JsonFileDataGetterSetter>() {
//            }.getType());
            return deviceConfig;
        }
        return new JsonFileDataGetterSetter(deviceConfig);
    }
}

