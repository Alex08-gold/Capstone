package ReadJson.src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {

		String filename = "/home/alex/RoboViz/GenerationBest-1.json";
		ReadPartData partData = new ReadPartData(filename);
		ReadConnectionData connectData = new ReadConnectionData(filename);

		RoboTree robotree = new RoboTree(partData.getDataArrayList(), connectData.getDataArrayList());
		System.out.println(robotree.getRoot().fullTree());
		robotree.traverse();
		System.out.println("done");
	}
	
}
