//package letsdothis.src;
//import com.sun.j3d.utils.geometry.ColorCube;
//import com.sun.j3d.utils.*;
//import javax.media.j3d.*;
//import com.sun.j3d.utils.geometry.Box;
//
//import com.sun.j3d.utils.universe.SimpleUniverse;
//
//import javax.media.j3d.BranchGroup;
//import javax.media.j3d.Canvas3D;
//import javax.media.j3d.Transform3D;
//import javax.media.j3d.TransformGroup;
//import javax.swing.*;
//import javax.vecmath.*;
//import javax.vecmath.Vector3d;
//import java.awt.*;
//import com.sun.j3d.utils.geometry.ColorCube;
//public class Java3DCubes extends JPanel {
//
//    public Java3DCubes() {
//
//        setLayout(new BorderLayout());
//        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
//        Canvas3D canvas = new Canvas3D(config);
//        SimpleUniverse universe = new SimpleUniverse(canvas);
//        BranchGroup group = createSceneGraph();
//        add("Center", canvas);
//        universe.getViewingPlatform().setNominalViewingTransform();
//        universe.getViewer().getView().setBackClipDistance(100.0);
//        universe.addBranchGraph(group);
//
//    }
//    private BranchGroup createColorCube() {
//
//        BranchGroup objRoot = new BranchGroup();
//        TransformGroup tg = new TransformGroup();
//        Transform3D t3d = new Transform3D();
////        t3d.setTranslation(new Vector3d(0.0, 0.3, -1.5));
//        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
//        t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
//        t3d.setScale(0.125);
//        tg.setTransform(t3d);
//        tg.addChild(new ColorCube());
//        objRoot.addChild(tg);
//        objRoot.compile();
//        return objRoot;
//
//    }
//    private BranchGroup createSceneGraph() {
//        BranchGroup objRoot = new BranchGroup();
////        TransformGroup objTrans = new TransformGroup();
////        Appearance ap = new Appearance();
////        ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);
////        Material ma = new Material();
////        ma.setDiffuseColor(new Color3f(1.0f, 1.0f, 1.0f));
////        Box box = new Box(500, 30, 20, ap);
////        ap.setMaterial(ma);
////        box.setAppearance(ap);
////        objTrans.addChild(box);
////        objRoot.addChild(objTrans);
////        objRoot.compile();
////        return objRoot;
//
//        objRoot.addChild(createColorCube());
//        return objRoot;
//
//    }
//
//    public static void main(String[] args) {
//
//        System.setProperty("sun.awt.noerasebackground", "true");
//        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
//        ToolTipManager ttm = ToolTipManager.sharedInstance();
//        ttm.setLightWeightPopupEnabled(false);
//        Java3DCubes java3DCubes = new Java3DCubes();
//        JFrame frame = new JFrame("Java3D Prototype");
//        frame.setSize(1000, 1000);
//        frame.getContentPane().add(java3DCubes);
//        frame.setVisible(true);
//    }
//}
