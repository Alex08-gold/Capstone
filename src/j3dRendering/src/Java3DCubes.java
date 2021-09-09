package j3dRendering.src;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Vector3d;
import java.awt.*;

public class Java3DCubes extends JPanel {

    public Java3DCubes() {

        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        SimpleUniverse universe = new SimpleUniverse(canvas);

        BranchGroup group = createSceneGraph();

        add("Center", canvas);

        universe.getViewingPlatform().setNominalViewingTransform();
        universe.getViewer().getView().setBackClipDistance(100.0);

        universe.addBranchGraph(group);

    }
    private BranchGroup createColorCube() {

        BranchGroup objRoot = new BranchGroup();
        TransformGroup tg = new TransformGroup();
        Transform3D t3d = new Transform3D();

        t3d.setTranslation(new Vector3d(0.0, 0.3, -1.5));
        t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
        t3d.setScale(0.125);

        tg.setTransform(t3d);
        tg.addChild(new ColorCube());

        TransformGroup tg_2 = new TransformGroup();
        Transform3D t3d_2 = new Transform3D();

        t3d_2.setTranslation(new Vector3d(3.0, 0.0, 0.0));
        t3d_2.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 3.14f));
        t3d_2.setScale(1.0);

        tg_2.setTransform(t3d_2);

        tg_2.addChild(new ColorCube());

        TransformGroup tg_3 = new TransformGroup();
        Transform3D t3d_3 = new Transform3D();

        t3d_3.setTranslation(new Vector3d(3.0, 0.0, 0.0));
        t3d_3.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0f));
        t3d_3.setScale(1.0);

        tg_3.setTransform(t3d_3);

        tg_3.addChild(new ColorCube());

        tg_2.addChild(tg_3);
        tg.addChild(tg_2);

        objRoot.addChild(tg);

        objRoot.compile();
        return objRoot;

    }
    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        objRoot.addChild(createColorCube());
        return objRoot;
    }

    public static void main(String[] args) {

        System.setProperty("sun.awt.noerasebackground", "true");
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setLightWeightPopupEnabled(false);

        Java3DCubes java3DCubes = new Java3DCubes();

        JFrame frame = new JFrame("Java3D Prototype");
        frame.setSize(1000, 1000);
        frame.getContentPane().add(java3DCubes);
        frame.setVisible(true);
    }
}