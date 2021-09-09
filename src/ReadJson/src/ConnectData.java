package ReadJson.src;

public class ConnectData {
	
	private String src;
	private String dest;
	
	public ConnectData(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}
	
	public String getSrc() {
		return src;
	}
	
	public String getDest(){
		return dest;
	}
	
	public String toString() {
		return src+"\t"+dest;
	}
}
