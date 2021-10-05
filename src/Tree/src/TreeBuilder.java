package Tree.src;

import ReadJson.src.ConnectData;
import ReadJson.src.PartData;

import java.io.FileNotFoundException;
import java.util.List;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class TreeBuilder {

	private TransformNode root;
	public List<PartData> parts;
	private List<ConnectData> connections;
	public double scalePart;    //how big all the individual parts are
	public double distParts;    //how far apart the parts are

	public TreeBuilder(List<PartData> parts, List<ConnectData> connections) throws FileNotFoundException {
		this.parts = parts;
		this.connections = connections;
		this.root = new TransformNode(parts.get(0));
		this.scalePart = 1;
		this.distParts = 1.5;
	}

//	public TreeBuilder(List<PartData> parts, List<ConnectData> connections, int scalePart, int distParts) {
//		this.parts = parts;
//		this.connections = connections;
//		this.scalePart = scalePart;
//		this.distParts = distParts;
//	}

	private PartData findData(String id) {
		for (PartData currentPart : parts) {
			if (currentPart.getID().equals(id)) {
				return currentPart;
			}
		}
		return new PartData("no", "part", true, -1);
	}

	// int orientation: from parts.getOrientation()
	private Transform3D createTranslation(int orientation) {
		Transform3D t3d = new Transform3D();

		double[] v = {0, 0, 0};    //will be replaced by a Vector3D
		switch (orientation) {
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

		//System.out.println("vector\t<"+v[0]+","+v[1]+","+v[2]+">");

		t3d.setTranslation(vector3d);
		t3d.setScale(scalePart);
		return t3d;
	}

	public void buildTree(TransformNode node) throws FileNotFoundException {
		for (ConnectData connection : connections) {
			if (node.getID().equals(connection.getSrc())) {

				// Creates new child with the input node's destination
				TransformNode child = new TransformNode(this.findData(connection.getDest()));
				Transform3D transform3D = createTranslation(child.getOrient());
				child.setTransform(transform3D);
				node.addChild(child);
				buildTree(child);
			}
		}
	}

	public TransformNode getRoot() {
		return root;
	}
}
