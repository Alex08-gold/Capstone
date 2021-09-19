package ReadJson.src;

import java.io.*;
import java.util.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadJson {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter JSON file path: ");
            String filename = sc.next();

            JsonObject jobject = getJsonFile(filename);
            JsonObject body = getBody(jobject);
            JsonArray part = getPart(body);

            ArrayList<PartData> geneDataArrayList = new ArrayList<>();

            for (JsonElement j:part
            ) {
               PartData partData = createBodyData(j);
                geneDataArrayList.add(partData);
            }
            for (PartData gd:geneDataArrayList
            ) {
                System.out.println(gd.toString());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static JsonObject getJsonFile(String filename) throws FileNotFoundException {
        JsonObject jsonObject;
        jsonObject = (JsonObject) new JsonParser().parse(new FileReader(filename));
        return jsonObject;
    }
    public static JsonObject getBody(JsonObject jsonObject){
        return (JsonObject) jsonObject.get("body");
    }
    public static JsonArray getPart(JsonObject jsonObject){
        return (JsonArray) jsonObject.get("part");
    }

    public static PartData createBodyData(JsonElement jsonObject){
        String id = jsonObject.getAsJsonObject().get("id").getAsString();
        String type = jsonObject.getAsJsonObject().get("type").getAsString();
        return new PartData(id,type);
    }
}

