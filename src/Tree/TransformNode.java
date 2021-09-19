package Tree.src;

import ReadJson.src.PartData;
import j3dRendering.src.Component;
import j3dRendering.src.Core;
import j3dRendering.src.FixedBrick;
import j3dRendering.src.Joint;

import javax.media.j3d.TransformGroup;

// Sets PartData object as userData and adds component as child

public class TransformNode extends TransformGroup {

    public TransformNode(PartData part){
        this.setUserData(part);
        Component component = null;
        String type  = part.getType();
        switch (type) {
            case "CoreComponent":
                component = new Core();
                break;
            case "FixedBrick":
                component = new FixedBrick();
                break;
            default:
                component = new Joint();
                break;
        }
        this.addChild(component);

    }
}
