package j3dRendering.src;

import java.applet.*;
import java.awt.*;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;

import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.PlatformGeometry;
//import com.sun.j3d.utils.behaviors.keyboard.*;

import com.sun.j3d.loaders.Scene;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.util.*;
import com.sun.j3d.utils.geometry.ColorCube;

public class Cubes extends Applet {

    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;
    private TransformGroup viewtrans = null;

    public Cubes() {
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

        BoundingSphere bounds = new BoundingSphere(new Point3d(), 10000.0);

        viewtrans = universe.getViewingPlatform().getViewPlatformTransform();
        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(viewtrans);
        keyNavBeh.setSchedulingBounds(bounds);
        PlatformGeometry platformGeom = new PlatformGeometry();
        platformGeom.addChild(keyNavBeh);
        universe.getViewingPlatform().setPlatformGeometry(platformGeom);
        objRoot.addChild(createColorCube());

        return objRoot;
    }
    private BranchGroup createColorCube() {

        BranchGroup objRoot = new BranchGroup();
        TransformGroup tg = new TransformGroup();
        Transform3D t3d = new Transform3D();

        t3d.setTranslation(new Vector3d(5.0, 0.0, 0.0));
        t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
        t3d.setScale(1.0);

        tg.setTransform(t3d);

        tg.addChild(new ColorCube());

        TransformGroup tg_2 = new TransformGroup();
        Transform3D t3d_2 = new Transform3D();

        t3d_2.setTranslation(new Vector3d(5.0, 0.0, 0.0));
        t3d_2.setRotation(new AxisAngle4f(0.0f, 1.0f, 0.0f, 3.14f));
        t3d_2.setScale(0.1);

        tg_2.setTransform(t3d_2);

        tg_2.addChild(new ColorCube());

        TransformGroup tg_3 = new TransformGroup();
        Transform3D t3d_3 = new Transform3D();

        t3d_3.setTranslation(new Vector3d(5.0, 0.0, 0.0));
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


    private Light createLight() {
        DirectionalLight light = new DirectionalLight(true, new Color3f(1.0f, 1.0f, 1.0f),
                new Vector3f(-0.3f, 0.2f, -1.0f));

        light.setInfluencingBounds(new BoundingSphere(new Point3d(), 10000.0));

        return light;
    }

    public static void main(String[] args) {
        Cubes applet = new Cubes();
        JFrame frame = new JFrame("Just Java 3D - Spinning Cube!");

        //Set the size of the JFrame
        frame.setSize(1000, 1000);

        //The frame will now hold the main canvas
        frame.getContentPane().add(applet);

        //Make sure the frame is actually visible
        frame.setVisible(true);

    }
}
