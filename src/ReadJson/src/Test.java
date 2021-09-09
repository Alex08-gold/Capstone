package ReadJson.src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ReadPartData partData = new ReadPartData();
		ReadConnectionData connectData = new ReadConnectionData();
		String filename = "/home/alex/RoboViz/GenerationBest-1.json";

		RoboTree robotreeA = new RoboTree(partData.getDataArrayList(filename), connectData.getDataArrayList(filename));
		robotreeA.traverse();
		System.out.println("done");
	}
	
}
