package ReadJson.src;

import javax.media.j3d.TransformGroup;
import java.util.List;

public class TreeBuilder {

	private List<TransformGroup> parts;
	private List<ConnectData> connections;
	
	public TreeBuilder(List<TransformGroup> parts, List<ConnectData> connections){
		this.parts = parts;
		this.connections = connections;
	}
	
	private TransformGroup findData(String id){
		for(TransformGroup currentPart: parts) {
			if(currentPart.getUserData().toString().equals(id)) {
				return currentPart;
			}
		}
		return new TransformGroup();
	}
	
	public TransformGroup getRootData(){
		TransformGroup rootData = parts.get(0);
		parts.remove(0);
		return rootData;
	}
	
	public void buildTree(SubTree node){
		for(ConnectData conn: connections){
			if(node.matchingSource(conn)){
				TransformGroup data = findData(conn.getDest());	//It's O(N^2) but it should work fine
				SubTree child = new SubTree(data);
				node.addLeaf(child);

				buildTree(child);
			}
		}
	}	
}
