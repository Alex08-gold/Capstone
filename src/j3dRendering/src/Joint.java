package j3dRendering.src;

import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

// For visualisation of all joints
public class Joint extends Component{

    public Joint(){
        //STL file here
        this.addChild(new ColorCube());
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.setScale(1);

        this.setTransform(t3d);
    }
}
