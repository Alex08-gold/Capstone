package j3dRendering.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;
import java.io.FileNotFoundException;

// For visualisation of a FixedBrick body part
public class FixedBrick extends Component{

    public FixedBrick() throws FileNotFoundException {
        super("object_files/CoreComponent.obj");
    }
}
