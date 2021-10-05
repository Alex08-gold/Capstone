package Testing.src;

import ReadJson.src.ConnectData;
import ReadJson.src.PartData;
import ReadJson.src.ReadConnectionData;
import ReadJson.src.ReadPartData;
import Tree.src.TransformNode;
import Tree.src.TreeBuilder;
import letsdothis.src.Terrain;
import letsdothis.src.Universe;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverTest {
    public static void main(String[] argsInput) throws FileNotFoundException {

//        System.out.println("Please enter two digits separated by a space.");
//        Scanner input = new Scanner(System.in);
//        int height = input.nextInt();
//        int width = input.nextInt();

//        String filename = "/home/alex/RoboViz/GenerationBest-1.json"; // TODO: take in path from user through UI or terminal
//        ReadPartData partData = new ReadPartData(filename); // Read in Body parts from json file
//        ReadConnectionData connectData = new ReadConnectionData(filename); // Read in connections from json file

        // Create tree
        //TreeBuilder treebuilder = new TreeBuilder(partData.getDataArrayList(),connectData.getDataArrayList()); // Build tree using partData and ConnectData Lists
        //TransformNode root = treebuilder.buildTree2();

        PartData r = new PartData("r", "r", true, 3);
        PartData a = new PartData("a", "a", true, 3);
        PartData aa = new PartData("aa", "aa", true, 3);
        PartData ab = new PartData("ab", "ab", true, 3);
        PartData aaa = new PartData("aaa", "aaa", true, 3);

        ArrayList<PartData> parts = new ArrayList<PartData>();
        parts.add(r);
        parts.add(a);
        parts.add(aa);
        parts.add(ab);
        parts.add(aaa);

        ConnectData r_a = new ConnectData("r", "a");
        ConnectData a_aa = new ConnectData("a", "aa");
        ConnectData a_ab = new ConnectData("a", "ab");
        ConnectData aa_aaa = new ConnectData("aa", "aaa");

        ArrayList<ConnectData> conn = new ArrayList<ConnectData>();
        conn.add(r_a);
        conn.add(a_aa);
        conn.add(a_ab);
        conn.add(aa_aaa);

        TreeBuilder tb = new TreeBuilder(parts, conn);
        TransformNode tn = tb.getRoot();
        tb.buildTree(tn);





        //System.out.println(treebuilder.parts.get(0)+"eh");
        //System.out.println(root.toString()+"a");

        // Create terrain GUI
        //Terrain terrain = new Terrain(height, width, root); //TODO: parseInt try/catch
        //Universe.getUniverse(terrain);

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
