package Tree.src;

import components.CompActiveHinge;
import components.CompCore;
import components.CompFixedBrick;
import components.Component;
import dataObjects.BrainData;
import dataObjects.PartData;
import java3D.TransformGroup;

public class TransformNode extends TransformGroup{
	
	private PartData data; //rename to something better...
	private BrainData neuron; 
	
	public TransformNode(PartData data, Component component) {
		super();
		this.data = data;
		this.addChild(component);
	}
	
	public TransformNode(PartData data) {
		super();
		this.data = data;
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
		this.neuron = null;
	}
	
	//Constructor that's actually used. Will add more cases
	public TransformNode(PartData data, BrainData neuron) {
		super();
		this.data = data;
		this.neuron = neuron;
		//this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); -- TransformGroup method, allows objects to be transformed at runtime 
		
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
