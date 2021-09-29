package ReadJson.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.media.j3d.TransformGroup;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadPartData implements ReadJsonData {

    private ArrayList<PartData> PartDataArrayList = new ArrayList<>();
    private JsonArray jsonArray;

    public ReadPartData(String filename) throws FileNotFoundException {
        JsonObject jobject = ReadJsonData.getJsonFile(filename);
        JsonObject body = ReadJsonData.getData("body", jobject);
        this.jsonArray = body.getAsJsonArray("part");
    }

    @Override
    public void createData(JsonElement jsonElement, PartData partData) {
        String id = jsonElement.getAsJsonObject().get("id").getAsString();
        String type = jsonElement.getAsJsonObject().get("type").getAsString();
        int orientation = jsonElement.getAsJsonObject().get("orientation").getAsInt();
        partData.setId(id); partData.setType(type); partData.setOrientation(orientation);
    }

    @Override
    public void createData(JsonElement jsonElement, BrainData brainData) {

    }

    @Override
    public void createData(JsonElement jsonElement, ConnectData connectData) {

    }

    @Override
    public ArrayList<PartData> getDataArrayList() {

        for (JsonElement j:this.jsonArray)
        {
            PartData partData = new PartData();
            createData(j, partData);
            PartDataArrayList.add(partData);

        }
        return this.PartDataArrayList;
    }
}
