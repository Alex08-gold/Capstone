package Tree.src;

import ReadJson.src.ConnectData;
import ReadJson.src.PartData;

import java.util.List;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class TreeBuilder {
	
	private List<PartData> parts;
	private List<ConnectData> connections;
	public final double scalePart;	//how big all the individual parts are
	public final double distParts;	//how far apart the parts are
	
	public TreeBuilder(List<PartData> parts, List<ConnectData> connections){
		this.parts = parts;
		this.connections = connections;
		this.scalePart = 1;
		this.distParts = 2.2;
	}
	
	public TreeBuilder(List<PartData> parts, List<ConnectData> connections, int scalePart, int distParts){
		this.parts = parts;
		this.connections = connections;
		this.scalePart = scalePart;
		this.distParts = distParts;
	}
	
	private PartData findData(String id){
		for(PartData currentPart: parts) {
			if(currentPart.getID().equals(id)) {
				return currentPart;
			}
		}
		return new PartData("no", "part", true, -1);
	}
	
	//I'm tempted to create a Translation class to separate this out, lemme know what you think
	private Transform3D createTranslation(int orientation){
		Transform3D t3d = new Transform3D();
		
		double[] v = {0,0,0};	//will be replaced by a Vector3D
		switch(orientation) {
		case 1:
			v[0] = -distParts;
			break;
		case 2:
			v[1] = distParts;
			break;
		case 3:
			v[1] = -distParts;
		default:
			v[0] = distParts;
			break;
		}
		Vector3d vector3d = new Vector3d(v);
		
		System.out.println("vector\t<"+v[0]+","+v[1]+","+v[2]+">");
		
		t3d.setTranslation(vector3d);
		t3d.setScale(scalePart);
		System.out.println(scalePart);
		return t3d;
	}
	
	public void buildTree(TransformNode node){
		for(ConnectData connection: connections){
			if(node.getID().equals(connection.getSrc())){
				
				//Create new TransformNode with relevant PartData and Component
				TransformNode child = new TransformNode(this.findData(connection.getDest()));
				//Add the new TransformNode to the current TransformNode
				node.addChild(child);
				//Set the Transformation on the new TransformNode
				child.setTransform(createTranslation(child.getOrient()));	//may need to apply to parent instead
				
				//call function on the child (new TransformNode)
				buildTree(child);
			}
		}
	}	
	
}
