package ReadJson.src;

public class PartData {

	private String id;
	private String type;
	private boolean root;
	private int orientation;

	public PartData(){

	}
	
	public PartData(String id, String type, boolean root, int orientation){
		this.setId(id);
		this.setType(type);
		this.setRoot(root);
		this.setOrientation(orientation);
	}

	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return getID() +"\t"+ getType() +"\t"+ isRoot() +"\t"+ getOrientation();
	}

	public String getID() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRoot() {
		return this.root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public int getOrient() {
		return this.orientation;
	}

	public void setOrient(int orientation) {
		this.orientation = orientation;
	}
}
