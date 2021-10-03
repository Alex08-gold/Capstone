package Testing.src;

import com.sun.j3d.utils.universe.SimpleUniverse;
import j3dRendering.src.Core;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import java.applet.Applet;
import java.awt.*;
import java.io.FileNotFoundException;

public class TestCoreRendering extends Applet {
    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;

    public TestCoreRendering() throws FileNotFoundException {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

        canvas = new Canvas3D(config);
        add("Center", canvas);
        universe = new SimpleUniverse(canvas);

        BranchGroup scene = createSceneGraph();
        universe.getViewingPlatform().setNominalViewingTransform();

        universe.getViewer().getView().setBackClipDistance(100.0);
        universe.addBranchGraph(scene);
    }

    private BranchGroup createSceneGraph() throws FileNotFoundException {
        BranchGroup objRoot = new BranchGroup();

        TransformGroup objScale = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setScale(0.5);
        objScale.setTransform(t3d);
        objRoot.addChild(objScale);

        TransformGroup objTrans = new TransformGroup();
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        objScale.addChild(objTrans);

        objTrans.addChild(new Core());

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        Color3f bgColor = new Color3f(1.0f, 1.0f, 1.0f);
        Background bgNode = new Background(bgColor);
        bgNode.setApplicationBounds(bounds);
        objRoot.addChild(bgNode);

        return objRoot;
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.setProperty("sun.awt.noerasebackground", "true");
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setLightWeightPopupEnabled(false);

        TestCoreRendering test = new TestCoreRendering();
        JFrame frame = new JFrame("Java3D Prototype");
        frame.setSize(1000, 1000);
        frame.getContentPane().add(test);
        frame.setVisible(true);

    }
}
