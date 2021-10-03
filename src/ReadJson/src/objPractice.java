package ReadJson.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import javax.media.j3d.BranchGroup;
import java.io.FileNotFoundException;

public class objPractice {

    public static void main(String[] args) throws FileNotFoundException {
        ObjectFile objFile = new ObjectFile();
        Scene objScene = objFile.load("/home/alex/IdeaProjects/Capstone/CoreComponent.obj");
        BranchGroup objBranchGroup = objScene.getSceneGroup();
    }
}
