package j3dRendering.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import javax.media.j3d.Light;
import javax.media.j3d.NodeComponent;
import java.io.FileNotFoundException;

// For visualisation  of the Core component of the robot
public class Core extends Component{

    public Core() throws FileNotFoundException {
        super("object_files/CoreComponent.obj");
    }
}
