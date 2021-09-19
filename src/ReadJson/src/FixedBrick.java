package ReadJson.src;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cylinder;

public class FixedBrick extends Component{

    public FixedBrick(){
        //STL file here
        this.addChild(new ColorCube());
    }
}
