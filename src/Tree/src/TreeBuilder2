package main;

import java.util.List;

import dataObjects.BrainData;
import dataObjects.ConnectData;
import dataObjects.PartData;
import transformations.Animation;
import transformations.Translation;

public class TreeBuilder {
	
	private List<PartData> parts;
	private List<BrainData> neurons;
	private List<ConnectData> connections;	
	
	public final int scalePart;	//how big all the individual parts are
	public final int distParts;	//how far apart the parts are
	
	public TreeBuilder(List<PartData> parts, List<BrainData> neurons, List<ConnectData> connections){
		this.parts = parts;
		this.neurons = neurons;
		this.connections = connections;
		this.scalePart = 1;
		this.distParts = 1;
	}
	
	public TreeBuilder(List<PartData> parts, List<BrainData> neurons, List<ConnectData> connections, int scalePart, int distParts){
		this.parts = parts;
		this.neurons = neurons;
		this.connections = connections;
		this.scalePart = scalePart;
		this.distParts = distParts;
	}
	
	private PartData findPart(String id){
		for(PartData currentPart: parts) {
			if(currentPart.getID().equals(id)) {
				return currentPart;
			}
		}
		return new PartData("no", "part", true, -1);
	}
	
	private boolean matchingNeuron(String id) {
		for(BrainData currentNeuron: neurons) {
			if(currentNeuron.getID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	private BrainData findNeuron(String id){
		for(BrainData currentNeuron: neurons) {
			if(currentNeuron.getID().equals(id)) {
				return currentNeuron;
			}
		}
		return new BrainData("no neuron", -1);
	}
	
	
	private TransformNode createChild(PartData childPart, String searchfor) {
		if(this.matchingNeuron(searchfor)) {
			BrainData childNeuron = this.findNeuron(searchfor);
			System.out.println(childNeuron.toString());
			return new TransformNode(childPart, childNeuron);
		}
		System.out.println("No neuron");
		return new TransformNode(childPart);
	}
	
	public void buildTree(TransformNode node){
		for(ConnectData connection: connections){
			if(node.getID().equals(connection.getSrc())){
				
				//Create new TransformNode with relevant PartData and BrainData
				String searchfor = connection.getDest();
				PartData childPart = this.findPart(searchfor);
				
				TransformNode child = createChild(childPart, searchfor);
				node.addChild(child);
				
				Translation translation = new Translation(child, distParts, scalePart);
				translation.setTranslation();
							
				if(child.getNeuron()!=null) {
					Animation animation = new Animation(child, node, 100);
					//animation.start();
					animation.setAnimation();
				}
				
				System.out.println();
				buildTree(child);
			}
		}
	}		
}
