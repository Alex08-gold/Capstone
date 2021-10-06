package Tree.src;

import ReadJson.src.PartData;
import j3dRendering.src.*;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import java.io.FileNotFoundException;


public class TransformNode extends TransformGroup {
	
	private PartData data;

	public TransformNode(PartData data) throws FileNotFoundException {
		super();
		this.data = data;

//		System.out.println(data.toString());
		
		String type = data.getType();
		switch(type) {
			case "CoreComponent":
				this.addChild(new Core());
				break;
			case "FixedBrick":
				this.addChild(new FixedBrick());
				break;
			case "ActiveHinge":
				this.addChild(new ActiveHinge());
				break;
			case "PassiveHinge":
				this.addChild(new PassiveHinge());
				break;
			default:
				this.addChild(new PassiveHinge());
				break;
		}
	}
	
	public String getID() {
		return data.getID();
	}
	public PartData getPartData(){
		return this.data;
	}

	public int getOrient() {
		return data.getOrientation();
	}
	
	public String toString(){
		return data.toString();
	}
	
}
