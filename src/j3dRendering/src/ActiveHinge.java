package j3dRendering.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;
import java.io.FileNotFoundException;

// For visualisation of all joints
public class ActiveHinge extends Component{

    public ActiveHinge() throws FileNotFoundException {
        super("object_files/ActiveHinge_Frame.obj");

    }
}
