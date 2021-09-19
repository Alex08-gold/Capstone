package ReadJson.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.media.j3d.TransformGroup;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadPartData implements ReadJsonData {

    private ArrayList<TransformGroup> TransformArrayList = new ArrayList<>();
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
        partData.setId(id); partData.setType(type);
    }

    @Override
    public void createData(JsonElement jsonElement) {

    }

    @Override
    public void createData(JsonElement jsonElement, ConnectData connectData) {

    }

    @Override
    public ArrayList<TransformGroup> getDataArrayList() {

        for (JsonElement j:this.jsonArray)
        {
            PartData partData = new PartData();
            createData(j, partData);
            //TransformGroup tg = partData.getTransformGroup();
            //tg.setUserData(partData);
            //this.TransformArrayList.add(tg);
        }
        return this.TransformArrayList;
    }
}
