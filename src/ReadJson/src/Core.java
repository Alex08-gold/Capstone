package ReadJson.src;

import com.sun.j3d.utils.geometry.ColorCube;

public class Core extends Component{

    public Core(){
        //STL file here
        this.addChild(new ColorCube());
    }
}
