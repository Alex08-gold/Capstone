package ReadJson.src;


public class PartData {

	private String id;
	private String type;

	public PartData(){

	}
	public PartData(String id, String type){
		this.setId(id);
		this.setType(type);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
	
