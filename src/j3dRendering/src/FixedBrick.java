package j3dRendering.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;
import java.io.FileNotFoundException;

// For visualisation of a FixedBrick body part
public class FixedBrick extends Component{

    public FixedBrick() throws FileNotFoundException {
        ObjectFile objFile = new ObjectFile(ObjectFile.RESIZE | ObjectFile.TRIANGULATE);
        Scene objscene = objFile.load("/home/alex/IdeaProjects/Capstone/CoreComponent.obj");

        this.addChild(objscene.getSceneGroup());

        Transform3D t3d = new Transform3D();
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.setScale(1);

        this.setTransform(t3d);
    }
}
