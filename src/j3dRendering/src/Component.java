package j3dRendering.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import javax.media.j3d.TransformGroup;
import java.io.FileNotFoundException;

// Component (Core, FixedBrick and Joint) to be added to each TransfromNode as a child for the visualisation
public abstract class Component extends TransformGroup {

     public Component(String filepath) throws FileNotFoundException {
         ObjectFile objFile = new ObjectFile(ObjectFile.RESIZE | ObjectFile.TRIANGULATE);
         Scene objscene = objFile.load(filepath);
         this.addChild(objscene.getSceneGroup());

     }
}
