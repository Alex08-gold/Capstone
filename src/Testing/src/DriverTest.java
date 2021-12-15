package Testing.src;

import ReadJson.src.ReadBrainData;
import ReadJson.src.ReadConnectionData;
import ReadJson.src.ReadJsonData;
import ReadJson.src.ReadPartData;
import Tree.src.TransformNode;
import Tree.src.TreeBuilder;
import letsdothis.src.Terrain;
import letsdothis.src.Universe;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DriverTest {
    public static void main(String[] argsInput) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter preferred JSON file name. GenerationBest-1 will be used as default.");
        String fileNameInput = input.next();

        // Create robot parts with user input filename
        String filename = getFileName(fileNameInput);
        ReadPartData partData = new ReadPartData(filename); // Read in Body parts from json file
        ReadConnectionData connectData = new ReadConnectionData(filename); // Read in connections from json file
        ReadBrainData brainData = new ReadBrainData(filename);

        // Create tree
        TreeBuilder treebuilder = new TreeBuilder(partData.getDataArrayList(),connectData.getDataArrayList(), 0.0, 0.0); // Build tree using partData and ConnectData Lists
        treebuilder.buildTree(treebuilder.getRoot());

        // Create terrain GUI
        Terrain terrain = new Terrain(500,500, treebuilder.getRoot());
        Universe.getUniverse(terrain);
    }

    public static String getFileName(String fileNameInput) throws FileNotFoundException {
        String fileName = null;
        try {
            fileName = "jsonFiles/" + fileNameInput;
            ReadJsonData.getJsonFile(fileName);
        } catch (FileNotFoundException e) {
            fileName = "jsonFiles/GenerationBest-1.json";
        }
        return fileName;
    }
}
