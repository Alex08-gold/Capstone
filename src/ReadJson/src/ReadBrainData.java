package ReadJson.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadBrainData implements ReadJsonData {
    private ArrayList<BrainData> BrainDataArrayList = new ArrayList<>();
    private JsonArray jsonArray;

    public ReadBrainData(String filename) throws FileNotFoundException {
        JsonObject jobject = ReadJsonData.getJsonFile(filename);
        JsonObject body = ReadJsonData.getData("brain", jobject);
        this.jsonArray = body.getAsJsonArray("neuron");
    }

    @Override
    public void createData(JsonElement jsonElement, BrainData brainData) {
        String id = jsonElement.getAsJsonObject().get("id").getAsString();
        double gain = jsonElement.getAsJsonObject().get("gain").getAsDouble();
        //double period = jsonElement.getAsJsonObject().get("period").getAsDouble();
        //double phaseOffset = jsonElement.getAsJsonObject().get("phaseOffset").getAsDouble();
        brainData.setId(id); brainData.setGain(gain);
        //brainData.setPeriod(period); brainData.setPhaseOffset(phaseOffset);
    }
    @Override
    public void createData(JsonElement jsonElement, ConnectData connectData) {

    }

    @Override
    public void createData(JsonElement jsonElement, PartData partData) {

    }

    @Override
    public ArrayList<BrainData> getDataArrayList() {
        for (JsonElement j:this.jsonArray)
        {
            BrainData brainData = new BrainData();
            createData(j, brainData);
            BrainDataArrayList.add(brainData);

        }
        return this.BrainDataArrayList;
    }
}
