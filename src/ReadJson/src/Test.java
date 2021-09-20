package ReadJson.src;

import javax.media.j3d.TransformGroup;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {

		String filename = "/home/alex/RoboViz/GenerationBest-1.json";
		ReadPartData partData = new ReadPartData(filename);
		ReadConnectionData connectData = new ReadConnectionData(filename);

		for (PartData pd:partData.getDataArrayList()) {
			System.out.print(pd.toString()+ " ");
		}

		System.out.println();

		for (ConnectData cd:connectData.getDataArrayList()) {
			System.out.print(cd.toString()+ " ");
		}


		System.out.println("done");
	}
	
}
