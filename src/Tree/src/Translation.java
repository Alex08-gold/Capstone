package transformations;

import java3D.Transform3D;
import main.TransformNode;

public class Translation {
	
	private TransformNode node;
	private Transform3D transformation;	
	//probably cleaner not to store these as a parameters, but anyways...
	
	public Translation(TransformNode node, int distParts, int scalePart) {
		this.node = node;
		transformation = createTranslation(node, distParts, scalePart);
	}
	
	private Transform3D createTranslation(TransformNode node, int distParts, int scalePart){
		Transform3D t3d = new Transform3D();
		
		int[] v = {0,0,0};	//will be replaced by a Vector3D
		switch(node.getOrient()) {
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
		t3d.setTranslation(new Vector3d(v));
		t3d.setScale(scalePart);
		return t3d;
	}
	
	public void setTranslation(){
		node.setTransform(transformation);
	}
	
}
