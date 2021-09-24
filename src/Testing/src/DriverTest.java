package Testing.src;

import ReadJson.src.ReadConnectionData;
import ReadJson.src.ReadPartData;
import Tree.src.TreeBuilder;

import java.io.FileNotFoundException;

public class DriverTest {
    public static void main(String[] args) throws FileNotFoundException {

        String filename = "/home/alex/RoboViz/GenerationBest-1.json"; // TODO: take in path from user through UI or terminal
        ReadPartData partData = new ReadPartData(filename); // Read in Body parts from json file
        ReadConnectionData connectData = new ReadConnectionData(filename); // Read in connections from json file

        //TODO: Get User Input (UI Code)

        TreeBuilder tree = new TreeBuilder(partData.getDataArrayList(),connectData.getDataArrayList()); // Build tree using partData and ConnectData Lists
        //tree.buildTree(); buildTree needs to take in a Transform node but TreeBuilder works work partdata and connect data

        //TODO: Build Tree
        // Pass Root of the Tree and User Input to Rendering Environment
        // Call main of rendering environment

    }
}
