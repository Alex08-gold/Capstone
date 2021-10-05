package Tree.src;

import ReadJson.src.PartData;
import j3dRendering.src.*;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import java.io.FileNotFoundException;


public class TransformNode extends TransformGroup {
	
<<<<<<< HEAD
	private PartData data;

	public TransformNode(PartData data) throws FileNotFoundException {
		super();
		this.data = data;

		System.out.println(data.toString());
=======
	private PartData part;
	
	public TransformNode(PartData part, Component component) {
		super();
		this.part = part;
		this.addChild(component);
	}
	
	//Constructor that's actually used. Will add more cases
	public TransformNode(PartData part) throws FileNotFoundException {
		super();
		this.part = part;
>>>>>>> 68f8789b04d6f0e03057739115807e360f13ae81
		
		String type = part.getType();
		switch(type) {
			case "CoreComponent":
				this.addChild(new Core());
				break;
			case "FixedBrick":
				this.addChild(new FixedBrick());
				break;
<<<<<<< HEAD
			case "ActiveHinge":
				this.addChild(new ActiveHinge());
				break;
			case "PassiveHinge":
				this.addChild(new PassiveHinge());
				break;

=======
			default:
				this.addChild(new Joint());
				break;
>>>>>>> 68f8789b04d6f0e03057739115807e360f13ae81
		}
	}
	
	public String getID() {
		return data.getID();
	}
	public PartData getPartData(){return this.data;}
	public int getOrient() {
		return data.getOrient();
	}
	
	public String toString(){
		return data.toString()+"\t"+neuron.toString();
	}
	
}
