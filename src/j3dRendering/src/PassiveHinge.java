package j3dRendering.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import java.io.FileNotFoundException;

public class PassiveHinge extends Component {

    public PassiveHinge() throws FileNotFoundException {
        ObjectFile objFile = new ObjectFile(ObjectFile.RESIZE | ObjectFile.TRIANGULATE);
        Scene objscene = objFile.load("/home/alex/IdeaProjects/Capstone/object_files/PassiveHinge_Frame.obj");

        this.addChild(objscene.getSceneGroup());

    }
}
