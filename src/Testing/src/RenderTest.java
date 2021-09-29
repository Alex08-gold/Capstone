package Testing.src;

import java.applet.*;
import java.awt.*;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;

import com.sun.j3d.utils.universe.SimpleUniverse;

public class RenderTest extends Applet {

    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;
    private TransformGroup viewtrans = null;

    public RenderTest() {
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
    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        TransformGroup tg = new TransformGroup();
        Transform3D tg3 = new Transform3D();
        tg3.setScale(0.125);
        tg.setTransform(tg3);

        Test testTree = new Test();
        tg.addChild(testTree.builder());

        objRoot.addChild(tg);
        return objRoot;
    }

    public static void main(String[] args){
        System.setProperty("sun.awt.noerasebackground", "true");
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setLightWeightPopupEnabled(false);

        RenderTest test = new RenderTest();
        JFrame frame = new JFrame("Java3D Prototype");
        frame.setSize(1000, 1000);
        frame.getContentPane().add(test);
        frame.setVisible(true);

    }
}
