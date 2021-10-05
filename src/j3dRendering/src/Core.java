package j3dRendering.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import javax.media.j3d.Light;
import javax.media.j3d.NodeComponent;
import java.io.FileNotFoundException;

// For visualisation  of the Core component of the robot
public class Core extends Component{

    public Core() throws FileNotFoundException {

        ObjectFile objFile = new ObjectFile(ObjectFile.RESIZE | ObjectFile.TRIANGULATE);
        Scene objscene = objFile.load("/home/alex/IdeaProjects/Capstone/object_files/CoreComponent.obj");
        this.addChild(objscene.getSceneGroup());

    }
}
