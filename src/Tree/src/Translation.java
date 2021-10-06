package Tree.src;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class Translation {

    private TransformNode node;
    private Transform3D transformation;
    private int globalOrient;
    private double distPart;
    private int scalePart;

    public Translation(TransformNode node, int parentGlobalOrient, Transform3D t3d, double distPart, int scalePart) {
        this.node = node;
        this.distPart = distPart;
        this.scalePart = scalePart;
        globalOrient = calculateGlobalOrient(parentGlobalOrient);
        //this.transformation = new Transform3D();
        transformation = createTranslation(t3d);

    }

    private int calculateGlobalOrient(int parentGlobalOrient) {
        return (node.getOrient()+parentGlobalOrient)%4;
    }

    public Transform3D createTranslation(Transform3D t3d){
       // Transform3D t3d = new Transform3D();

        double[] v = {0,0,0};
        switch(globalOrient) {
            case 1:
                v[1] = -this.distPart;
                break;
            case 2:
                v[0] = -this.distPart;
                break;
            case 3:
                v[1] = this.distPart;
                break;
            default:
                v[0] = this.distPart;
                break;
        }

        t3d.setTranslation(new Vector3d(v));
        t3d.setScale(scalePart);
        return t3d;
    }

    public int getGlobalOrient(){
        return globalOrient;
    }

    public Transform3D getTransformation(){
        return this.transformation;
    }
    public void setTranslation(){
        node.setTransform(transformation);
    }
}

