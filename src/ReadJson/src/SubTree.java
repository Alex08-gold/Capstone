package ReadJson.src;

import javax.media.j3d.TransformGroup;
import java.util.ArrayList;
import java.util.List;


public class SubTree {
	
	private TransformGroup data;
	private List<SubTree> children;
	
	public SubTree(TransformGroup data, List<SubTree> children) {
		this.data = data;
		this.children = children;
	}
	
	public SubTree(TransformGroup data) {
		this.data = data;
		this.children = new ArrayList<>();
	}
	
	public String getData() {
		return data.getUserData().toString();
	}
	
	public boolean hasChildren(){
		return !(children.size()==0);
	}
	
	public void addLeaf(SubTree leaf) {
		children.add(leaf);
	}
	
	public boolean matchingSource(ConnectData connection){
		return getData().equals(connection.getSrc());
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
		StringBuilder s = new StringBuilder(data.getUserData().toString() + "\n");
		if(this.hasChildren()) {
			for(SubTree child: children) {
				s.append("  ").append(child.toString());
			}
		}
		else{
			return "Tree doesnt have children?"; //test
		}
		return s.toString();
	}

	@Override
	public String toString() {
		return "SubTree{" +
				"data=" + data +
				", children=" + children +
				'}';
	}

	private void visit(){
		System.out.println(this.getData());  //System.out.println(this.getData().toString());
	}

}
