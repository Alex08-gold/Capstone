package readjson;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class ReadJson<T> {

	private List<T> dataList;
	private JsonArray jsonArray;
	
	public ReadJson(String filename, String a, String b) throws FileNotFoundException{
		
		JsonObject jobject = ReadJsonData.getJsonFile(filename);
        JsonObject body = ReadJsonData.getData(a, jobject);
        this.jsonArray = body.getAsJsonArray(b);
        
	}
	
	public abstract void createData(JsonElement jsonElement, Object object) {
	
	public ArrayList<T> getDataArrayList() {

        for (JsonElement j:this.jsonArray)
        {
            T element = new Object();
            createData(j, object);
            dataList.add(T);
        }
        return this.dataList;
    } 

    public JsonArray getJsonArray(){
        return this.jsonArray;
    }
}
