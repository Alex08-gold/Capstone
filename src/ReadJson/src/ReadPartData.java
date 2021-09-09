package ReadJson.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadPartData implements ReadJsonData {

    private ArrayList<PartData> PartDataArrayList = new ArrayList<>();
    private PartData partData;
    private JsonArray jsonArray;

    @Override
    public void createData(JsonElement jsonElement) {
        String id = jsonElement.getAsJsonObject().get("id").getAsString();
        String type = jsonElement.getAsJsonObject().get("type").getAsString();
        boolean root = jsonElement.getAsJsonObject().get("root").getAsBoolean();
        this.partData = new PartData(id,type,root);
    }

    public void getBodyPartArray(String filename) throws FileNotFoundException {
        JsonObject jobject = ReadJsonData.getJsonFile(filename);
        JsonObject body = ReadJsonData.getData("body", jobject);
        this.jsonArray = body.getAsJsonArray("part");
    }

    @Override
    public ArrayList<PartData> getDataArrayList(String filename) throws FileNotFoundException {

        getBodyPartArray(filename);
        for (JsonElement j:this.jsonArray
        ) {
            createData(j);
            this.PartDataArrayList.add(this.partData);
        }
        return this.PartDataArrayList;
    }
}
