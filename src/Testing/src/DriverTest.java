package Testing.src;

import ReadJson.src.ReadConnectionData;
import ReadJson.src.ReadPartData;
import Tree.src.TransformNode;
import Tree.src.TreeBuilder;
import letsdothis.src.Terrain;
import letsdothis.src.Universe;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DriverTest {
    public static void main(String[] argsInput) throws FileNotFoundException {

        System.out.println("Please enter two digits separated by a space.");
        Scanner input = new Scanner(System.in);
        int height = input.nextInt();
        int width = input.nextInt();

        String filename = "/home/alex/RoboViz/GenerationBest-1.json"; // TODO: take in path from user through UI or terminal
        ReadPartData partData = new ReadPartData(filename); // Read in Body parts from json file
        ReadConnectionData connectData = new ReadConnectionData(filename); // Read in connections from json file

        // Create tree
        TreeBuilder treebuilder = new TreeBuilder(partData.getDataArrayList(), connectData.getDataArrayList()); // Build tree using partData and ConnectData Lists
        //TransformNode root = new TransformNode(treebuilder.getRoot().getPartData());
        //TransformNode root = treebuilder.getRoot();
        treebuilder.buildTree(treebuilder.getRoot());


        // Create terrain GUI
        Terrain terrain = new Terrain(height, width, treebuilder.getRoot()); //TODO: parseInt try/catch
        Universe.getUniverse(terrain);

        // 2
        //TODO: Get User Input (UI Code)

        // 1

        // 3
        //TODO:
        // Pass Root of the Tree and User Input to Rendering Environment
        // Call main of rendering environment

    }

    public static Integer[] parseArgs(String[] args) {
        // TODO: throw an error message if length is not equal to 2

        Integer[] parsedArgs = new Integer[2];
        try {
            for (int i = 0; i < args.length; i++) {
                parsedArgs[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid input. Enter two integers separated by a space.");
        }
        return parsedArgs;
    }
}
