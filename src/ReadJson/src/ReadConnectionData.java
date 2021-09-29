package ReadJson.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadConnectionData implements ReadJsonData {

    private ArrayList<ConnectData> ConnectDataArrayList = new ArrayList<>();
    private JsonArray jsonArray;

    public ReadConnectionData(String filename) throws FileNotFoundException {
        JsonObject jobject = ReadJsonData.getJsonFile(filename);
        JsonObject body = ReadJsonData.getData("body", jobject);
        this.jsonArray = body.getAsJsonArray("connection");
    }

    @Override
    public void createData(JsonElement jsonElement, ConnectData connectData) {
        String src = jsonElement.getAsJsonObject().get("src").getAsString();
        String dest = jsonElement.getAsJsonObject().get("dest").getAsString();
        connectData.setSrc(src); connectData.setDest(dest);
    }

    @Override
    public void createData(JsonElement jsonElement, PartData partData) {

    }

    @Override
    public void createData(JsonElement jsonElement, BrainData brainData) {

    }

    @Override
    public ArrayList<ConnectData> getDataArrayList() {
        for (JsonElement j:this.jsonArray
        ) {
            ConnectData connectData = new ConnectData();
            createData(j, connectData);
            this.ConnectDataArrayList.add(connectData);
        }
        return this.ConnectDataArrayList;
    }
}
