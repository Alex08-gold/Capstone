package Tree.src;

import ReadJson.src.PartData;
import j3dRendering.src.Component;
import j3dRendering.src.Core;
import j3dRendering.src.FixedBrick;
import j3dRendering.src.Joint;
import javax.media.j3d.TransformGroup;


public class TransformNode extends TransformGroup {
	
	private PartData data;
	
	public TransformNode(PartData data, Component component) {
		super();
		this.data = data;
		this.addChild(component);
	}
	
	//Constructor that's actually used. Will add more cases
	public TransformNode(PartData data) {
		super();
		this.data = data;
		
		String type = data.getType();
		switch(type) {
			case "CoreComponent":
				this.addChild(new Core());
				break;
			case "FixedBrick":
				this.addChild(new FixedBrick());
				break;
			default:
				this.addChild(new Joint());
		}
		System.out.println(this.toString());
	}
	
	public String getID() {
		return data.getID();
	}
	
	public int getOrient() {
		return data.getOrientation();
	}
	
	public String toString(){
		return data.toString();
	}
	
}
