package ReadJson.src;

import javax.media.j3d.TransformGroup;

public class TransformNode extends TransformGroup{
    private PartData data;

    public TransformNode(PartData part){
        this.data = part;
        this.setUserData(data);
        Component component = null;
        if(data.getType().equals("CoreComponent")){
            component = new Core();

        }
        else if(data.getType().equals("FixedBrick")){
            component = new FixedBrick();
        }
        this.addChild(component);
    }
}
