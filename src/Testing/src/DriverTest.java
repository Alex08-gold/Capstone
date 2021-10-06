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

        System.out.println("Please enter height.");
        Scanner input = new Scanner(System.in);
        int height = input.nextInt();
        System.out.println("Please enter width.");
        int width = input.nextInt();
        System.out.println("Please enter preferred JSON file name. GenerationBest-1 will be used as default." +
                "\nIf the default file name should be used, enter any text.");
        String fileNameInput = input.next();
        System.out.println("Please enter x starting position.");
        String xStartString = input.next();
        Double xStart = Double.parseDouble(xStartString);
        System.out.println("Please enter y starting position.");
        String yStartString = input.next();
        Double yStart = Double.parseDouble(yStartString);


//        String filename = "jsonFiles/GenerationBest-1.json"; // TODO: take in path from user through UI or terminal
        String filename = getFileName(fileNameInput);
        ReadPartData partData = new ReadPartData(filename); // Read in Body parts from json file
//        ReadPartData partData = readParts(fileNameInput);
        ReadConnectionData connectData = new ReadConnectionData(filename); // Read in connections from json file
        ReadBrainData brainData = new ReadBrainData(filename);

        // Create tree
        TreeBuilder treebuilder = new TreeBuilder(partData.getDataArrayList(),connectData.getDataArrayList(), xStart, yStart); // Build tree using partData and ConnectData Lists
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

    public static ReadPartData readParts(String fileNameInput) throws FileNotFoundException {
        ReadPartData partData = null;
        try {
            String filename = "jsonFiles/" + fileNameInput;
            partData = new ReadPartData(filename);
        } catch (FileNotFoundException e) {
            String filename = "jsonFiles/GenerationBest-1.json";
            partData = new ReadPartData(filename);
        }
        return partData;
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
