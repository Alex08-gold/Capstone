package ReadJson.src;

import javax.media.j3d.TransformGroup;
import java.util.List;

public class RoboTree {
	
	private SubTree root;

	public RoboTree(List<TransformGroup> parts, List<ConnectData> connections){
		TreeBuilder treeBuilder = new TreeBuilder(parts, connections);
		root = new SubTree(treeBuilder.getRootData());
		treeBuilder.buildTree(root);
	}
	
	public RoboTree(SubTree root){
		this.root = root; //yes yes, I know it's unsafe, just for testing
	}
	
	public void traverse(){
		root.traverse();
	}

	public SubTree getRoot() {
		return root;
	}
}
