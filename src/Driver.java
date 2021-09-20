package ReadJson.src;

// class to link tree logic classes and ReadJson classes

import Tree.src.TransformNode;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver {

    public Driver(String filename) throws FileNotFoundException {

        ReadPartData partData = new ReadPartData(filename);
        ReadConnectionData connectData = new ReadConnectionData(filename);

        ArrayList<PartData> PartDataList = partData.getDataArrayList();
        ArrayList<ConnectData> ConnectDataList = connectData.getDataArrayList();

        // Build Tree with 2 arraylists

    }

    public TransformNode getRoot(){
        return new TransformNode(new PartData("id", "core")); // This is just so we dont get an error, must be removed
        // Must return the root of the tree built
    }
}
