package ReadJson.src;

import java.util.List;

public class TreeBuilder {

	private List<PartData> parts;
	private List<ConnectData> connections;
	
	public TreeBuilder(List<PartData> parts, List<ConnectData> connections){
		this.parts = parts;
		this.connections = connections;
	}
	
	private PartData findData(String id){
		for(PartData currentPart: parts) {
			if(currentPart.getID().equals(id)) {
				return currentPart;
			}
		}
		return new PartData("no", "part", true);
	}
	
	public PartData getRootData(){
		PartData rootData = parts.get(0);
		parts.remove(0);
		return rootData;
	}
	
	public void buildTree(SubTree node){	
		for(ConnectData conn: connections){
			if(node.matchingSource(conn)){
				PartData data = findData(conn.getDest());	//It's O(N^2) but it should work fine
				SubTree child = new SubTree(data);
				node.addLeaf(child);
				
				buildTree(child);
			}
		}
	}	
}
