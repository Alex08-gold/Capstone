package Tree.src;

import ReadJson.src.BrainData;
import ReadJson.src.ConnectData;
import ReadJson.src.PartData;

import java.io.FileNotFoundException;
import java.util.List;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class TreeBuilder {

	private List<BrainData> neurons;
	private List<PartData> parts;
	private List<ConnectData> connections;
	private TransformNode root;

	public static int scalePart;	//how big all the individual parts are
	public static double distParts;	//how far apart the parts are
	public static Double xPos;
	public static Double yPos;


	public TreeBuilder(List<PartData> parts, List<ConnectData> connections, Double xPos, Double yPos) throws FileNotFoundException {
		this.root = new TransformNode(parts.get(0));
		this.parts = parts;
		this.connections = connections;
		this.scalePart = 1;
		this.distParts = 1.5;
		this.xPos = xPos;
		this.yPos = yPos;
	}

//	public TreeBuilder(List<PartData> parts, List<BrainData> neurons, List<ConnectData> connections, int scalePart, int distParts){
//		this.parts = parts;
//		this.neurons = neurons;
//		this.connections = connections;
//		this.scalePart = scalePart;
//		this.distParts = distParts;
//	}

	private PartData findPart(String id){
		for(PartData currentPart: parts) {
			if(currentPart.getID().equals(id)) {
				return currentPart;
			}
		}
		return new PartData("no", "part", true, -1);
	}

	public void buildTree(TransformNode node) throws FileNotFoundException {
		Vector3d v = new Vector3d(new double[]{xPos, yPos, 0});
		Transform3D t3d = new Transform3D();
		t3d.setTranslation(v);
		buildTree(node, 0, t3d);
	}

	public void buildTree(TransformNode node, int currentOrient, Transform3D t3d) throws FileNotFoundException {
		for(ConnectData connection: connections){
			if(node.getID().equals(connection.getSrc())){

				//Create new TransformNode with relevant PartData and BrainData
				String searchfor = connection.getDest();
				PartData childPart = this.findPart(searchfor);

				TransformNode child = new TransformNode(childPart);
				node.addChild(child);

				Translation translation = new Translation(child, currentOrient,t3d,distParts,scalePart);
				child.setTransform(translation.createTranslation(t3d));

				buildTree(child, translation.getGlobalOrient(), translation.getTransformation());

				//buildTree(child, translation.getGlobalOrient());
			}
		}
	}
	public TransformNode getRoot(){
		return this.root;
	}
}
