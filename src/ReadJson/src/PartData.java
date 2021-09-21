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
	
	public String getID() {
		return getId();
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		return getId() +"\t"+ getType() +"\t"+ isRoot() +"\t"+ getOrientation();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
}
