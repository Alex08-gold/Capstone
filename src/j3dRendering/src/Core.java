package j3dRendering.src;

import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

public class Core {
    private TransformGroup transformgroup;
    private Transform3D transform3D  = new Transform3D();

    public Core(){
        transformgroup = new TransformGroup();
        // TODO: instantiate and set transform3D
        transformgroup.addChild(new ColorCube());
    }
    public TransformGroup getCore(){
        return this.transformgroup;
    }
}
