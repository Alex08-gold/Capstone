package ReadJson.src;

public class ConnectData {
	
	private String src;
	private String dest;

	public ConnectData(){

	}
	public ConnectData(String src, String dest) {
		this.setSrc(src);
		this.setDest(dest);
	}
	
	public String getSrc() {
		return src;
	}
	
	public String getDest(){
		return dest;
	}
	
	public String toString() {
		return src+" "+dest;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
}
