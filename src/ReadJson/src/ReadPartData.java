package ReadJson.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.media.j3d.TransformGroup;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadPartData implements ReadJsonData {

    private ArrayList<TransformGroup> TransformArrayList = new ArrayList<>();
    private TransformGroup tg;
    private PartData partData;
    private JsonArray jsonArray;

    public ReadPartData(String filename) throws FileNotFoundException {
        this.tg = new TransformGroup();
        this.partData = new PartData();
        JsonObject jobject = ReadJsonData.getJsonFile(filename);
        JsonObject body = ReadJsonData.getData("body", jobject);
        this.jsonArray = body.getAsJsonArray("part");
    }

    @Override
    public void createData(JsonElement jsonElement) {
        String id = jsonElement.getAsJsonObject().get("id").getAsString();
        String type = jsonElement.getAsJsonObject().get("type").getAsString();
        boolean root = jsonElement.getAsJsonObject().get("root").getAsBoolean();
        this.partData.setId(id); this.partData.setType(type); this.partData.setRoot(root);
    }

    @Override
    public ArrayList<TransformGroup> getDataArrayList() {

        for (JsonElement j:this.jsonArray
        ) {
            createData(j);
            tg.setUserData(partData);
            this.TransformArrayList.add(tg);
        }
        return this.TransformArrayList;
    }
}
