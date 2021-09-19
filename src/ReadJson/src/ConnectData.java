package ReadJson.src;

// Stores connection data that define the connections between body parts of the robots (Links in the tree)
public class ConnectData {
	
	private String src;
	private String dest;

	// Default constructor
	public ConnectData(){

	}
	// Takes in source and destination String id's of a body parts
	public ConnectData(String src, String dest) {
		this.setSrc(src);
		this.setDest(dest);
	}

	// Getter and setter methods 

	public String getSrc() {

	    return src;
	}
	
	public String getDest(){
		return dest;
	}
	
	public String toString() {

	    return getSrc() +" "+ getDest();
	}

	public void setSrc(String src) {

	    this.src = src;
	}

	public void setDest(String dest) {

	    this.dest = dest;
	}
}
