package Tree.src;

import ReadJson.src.PartData;
import j3dRendering.src.Component;
import j3dRendering.src.Core;
import j3dRendering.src.FixedBrick;
import j3dRendering.src.Joint;
import javax.media.j3d.TransformGroup;
import java.io.FileNotFoundException;


public class TransformNode extends TransformGroup {
	
	private PartData part;
	private BrainData neuron;
	
	public TransformNode(PartData part, Component component) {
		super();
		this.part = part;
		this.addChild(component);
	}
	
	//Constructor that's actually used. Will add more cases
	public TransformNode(PartData part) throws FileNotFoundException {
		super();
		this.part = part;
		
		String type = part.getType();
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
		this.neuron = null;
	}

	public TransformNode(PartData data, BrainData neuron) {
		super();
		this.data = data;
		this.neuron = neuron;
		this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); -- TransformGroup method, allows objects to be transformed at runtime 
		
		String type = data.getType();
		switch(type) {
		case "CoreComponent":
			this.addChild(new CompCore());
			break;
		case "ActiveHinge":
			this.addChild(new CompActiveHinge());
			break;
		case "FixedBrick":
			this.addChild(new CompFixedBrick());
			break;
		}	
	}
	
	public String getID() {
		return data.getID();
	}
	
	public int getOrient() {
		return data.getOrient();
	}
	
	public BrainData getNeuron(){
		return neuron;
	}
	
	public String toString(){
		return data.toString()+"\t"+neuron.toString();
	}
	
}
