package ReadJson.src;

import java.util.List;

public class RoboTree {
	
	private SubTree root;
	private static TreeBuilder treeBuilder;
	
	public RoboTree(List<PartData> parts, List<ConnectData> connections){
		treeBuilder = new TreeBuilder(parts, connections);
		root = new SubTree(treeBuilder.getRootData());
		treeBuilder.buildTree(root);
	}
	
	public RoboTree(SubTree root){
		this.root = root; //yes yes, I know it's unsafe, just for testing
	}
	
	public void traverse(){
		root.traverse();
	}
}
