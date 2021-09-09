package ReadJson.src;

public class PartData {

	private String id;
	private String type;
	private boolean root;
	
	public PartData(String id, String type, boolean root){
		this.id = id;
		this.type = type;
		this.root = root;
	}
	
	public String getID() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean getRoot(){
		return root;
	}
	
	public String toString() {
		return id+"\t"+type+"\t"+root;
	}
}
