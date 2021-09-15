package ReadJson.src;

import j3dRendering.src.Core;
import j3dRendering.src.FixedBrick;
import j3dRendering.src.Joint;

import javax.media.j3d.TransformGroup;

public class PartData {

	private String id;
	private String type;
	private boolean root;

	public PartData(){

	}
	public PartData(String id, String type, boolean root){
		this.setId(id);
		this.setType(type);
		this.root = root;
	}
	
	public String getID() {
		return id;
	}

	public TransformGroup getTransformGroup(){
		if(this.getType().equals("CoreComponent")){
			Core core = new Core();
			return core.getCore();
		}
		if(this.getType().equals("FixedBrick")){
			FixedBrick fixedBrick = new FixedBrick();
			return fixedBrick.getFixedBrick();
		}
		Joint joint = new Joint();
		return joint.getJoint();
	}
	
	public String getType() {
		return type;
	}
	
	public boolean getRoot(){
		return root;
	}
	
	public String toString() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTg(TransformGroup tg) {
	}

	public void setRoot(boolean root){
		this.root = root;
	}
}
