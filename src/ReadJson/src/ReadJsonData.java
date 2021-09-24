package ReadJson.src;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public interface ReadJsonData {

    static JsonObject getData(String data, JsonObject jsonObject) {

        return (JsonObject) jsonObject.get(data);
    }

    static JsonObject getJsonFile(String filename) throws FileNotFoundException {
        JsonObject jsonObject;
        jsonObject = (JsonObject) new JsonParser().parse(new FileReader(filename));
        return jsonObject;
    }

    void createData (JsonElement jsonElement, ConnectData connectData);
    void createData(JsonElement jsonElement, PartData partData);
    void createData(JsonElement jsonElement, BrainData brainData);

    ArrayList getDataArrayList();
}
