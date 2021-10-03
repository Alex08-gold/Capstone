package Testing.src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import ReadJson.src.ConnectData;
import ReadJson.src.PartData;
import Tree.src.TransformNode;
import Tree.src.TreeBuilder;


public class Test {

	//public TransformNode root;

	public TransformNode builder() throws FileNotFoundException {
		//Basic tree made from two basic arrayLists, just to make sure everything is working
		ConnectData C_H1 = new ConnectData("Core", "Hip1");
		ConnectData H1_UL1 = new ConnectData("Hip1", "UL1");
		ConnectData C_H2 = new ConnectData("Core", "Hip2");

		List<ConnectData> connections = new ArrayList<ConnectData>();
		connections.add(C_H1);
		connections.add(H1_UL1);
		connections.add(C_H2);

		PartData partCore = new PartData("Core", "CoreComponent", true, 0);
		PartData partHip1 = new PartData("Hip1", "ActiveHinge", false, 2);
		PartData partUL1 = new PartData("UL1", "FixedBrick", false, 0);
		PartData partHip2 = new PartData("Hip2", "ActiveHinge", false, 1);

		List<PartData> parts = new ArrayList<PartData>();
		parts.add(partCore);
		parts.add(partHip1);
		parts.add(partUL1);
		parts.add(partHip2);

		TransformNode root = new TransformNode(partCore);
		TreeBuilder treeBuilder = new TreeBuilder(parts, connections);
		treeBuilder.buildTree(root);

		return root;
	}

	public TransformNode buildRoot() throws FileNotFoundException {
		PartData partCore = new PartData("Core", "CoreComponent", true, 0);
		TransformNode root = new TransformNode(partCore);
		System.out.println(root.toString());
		return root;
	}

	//public TransformNode returnRoot(){
		//return root;
	//}
	
}