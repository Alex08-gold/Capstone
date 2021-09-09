package ReadJson.src;

import java.util.ArrayList;
import java.util.List;


public class SubTree {
	
	private PartData data;
	private List<SubTree> children;
	
	public SubTree(PartData data, List<SubTree> children) {
		this.data = data;
		this.children = children;
	}
	
	public SubTree(PartData data) {
		this.data = data;
		this.children = new ArrayList<SubTree>();
	}
	
	public PartData getData() {
		return data;
	}
	
	public boolean hasChildren(){
		return !(children.size()==0);
	}
	
	public void addLeaf(SubTree leaf) {
		children.add(leaf);
	}
	
	public String getID(){
		return data.getID();
	}
	
	public boolean matchingSource(ConnectData connection){
		return data.getID().equals(connection.getSrc());
	}
	
	public void traverse(){	//preOrder traversal
		visit();
		if(this.hasChildren()){
	         for(SubTree child: children){
	            child.traverse();
	         }  
	    }
	}
	
	public String fullTree(){
		StringBuilder s = new StringBuilder(data.toString() + "\n");
		if(this.hasChildren()) {
			for(SubTree child: children) {
				s.append("  ").append(child.toString());
			}
		}
		return s.toString();
	}
	
	public String toString(){
		return data.toString();
	}
	
	private void visit(){
		System.out.println(this.getData().toString());
	}

}
