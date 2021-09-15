package ReadJson.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadConnectionData implements ReadJsonData {

    private ArrayList<ConnectData> ConnectDataArrayList = new ArrayList<>();
    private ConnectData ConnectData;
    private JsonArray jsonArray;

    public ReadConnectionData(String filename) throws FileNotFoundException {
        this.ConnectData = new ConnectData();
        JsonObject jobject = ReadJsonData.getJsonFile(filename);
        JsonObject body = ReadJsonData.getData("body", jobject);
        this.jsonArray = body.getAsJsonArray("connection");
    }
    @Override
    public void createData(JsonElement jsonElement) {
        String src = jsonElement.getAsJsonObject().get("src").getAsString();
        String dest = jsonElement.getAsJsonObject().get("dest").getAsString();
        this.ConnectData.setSrc(src); this.ConnectData.setDest(dest);
    }

    @Override
    public ArrayList<ConnectData> getDataArrayList() {
        for (JsonElement j:this.jsonArray
        ) {
            createData(j);
            this.ConnectDataArrayList.add(this.ConnectData);
        }
        return this.ConnectDataArrayList;
    }
}
