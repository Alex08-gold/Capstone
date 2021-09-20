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

		ArrayList<TransformGroup> tg = new ArrayList<>();
		ArrayList<ConnectData> connect = new ArrayList<>();
        TransformGroup transformGroup = new TransformGroup();
        PartData partdata = new PartData("id", "type", true);
        transformGroup.setUserData(partdata);
		tg.add(transformGroup);
		connect.add(new ConnectData("src", "dest"));

		RoboTree roboTree = new RoboTree(tg, connect);
		System.out.print(tg);
		System.out.print(connect);

		//RoboTree robotree = new RoboTree(partData.getDataArrayList(), connectData.getDataArrayList());
		for(TransformGroup transform: partData.getDataArrayList()){
			System.out.println(transformGroup.getUserData().toString());
		}
		System.out.println("ConnectData: "+connectData.getDataArrayList());
		//robotree.traverse(); // test
		System.out.println("done");
	}
	
}
