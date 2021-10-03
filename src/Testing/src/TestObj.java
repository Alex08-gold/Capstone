package Testing.src;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Vector3f;
import java.applet.Applet;
import java.awt.*;
import java.awt.desktop.AppForegroundListener;
import java.io.FileNotFoundException;

public class TestObj extends Applet {
    private Scene SCENE = null;
    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;
    private TransformGroup viewtrans = null;
    
    public TestObj() throws FileNotFoundException {
        ObjectFile OBJECT1 = new ObjectFile(ObjectFile.RESIZE);

        SCENE = OBJECT1.load("/home/alex/Downloads/CoreComponent.obj");
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
        BranchGroup bg = new BranchGroup(); 
        TransformGroup tg = new TransformGroup();

        Transform3D T3D = new Transform3D();
        T3D.setScale(0.125);

        tg.setTransform(T3D);
        tg.addChild(SCENE.getSceneGroup());
        bg.addChild(tg);
        return bg;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setProperty("sun.awt.noerasebackground", "true");
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setLightWeightPopupEnabled(false);

        TestObj test = new TestObj();
        JFrame frame = new JFrame("Java3D Prototype");
        frame.setSize(1000, 1000);
        frame.getContentPane().add(test);
        frame.setVisible(true);

    }

}
