package letsdothis.src;
import Tree.src.Transform;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;

import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.swing.*;
import javax.vecmath.*;

import java.applet.Applet;
import java.awt.*;
import java.io.FileNotFoundException;

import com.sun.j3d.utils.geometry.ColorCube;
public class Universe extends Applet{

    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;

    public Universe(Terrain terrain) {

        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

        canvas = new Canvas3D(config);
        add("Center", canvas);
        universe = new SimpleUniverse(canvas);

        BranchGroup scene = createSceneGraph(terrain);
        universe.getViewingPlatform().setNominalViewingTransform();

        universe.getViewer().getView().setBackClipDistance(100.0);
        universe.addBranchGraph(scene);

    }
  
    
    private BranchGroup createSceneGraph(Terrain terrain) {
    	// NOTE: This is a temporary method. It will be replaced with createTerrain() when STL files work

        BranchGroup objRoot = new BranchGroup();
        TransformGroup tg = new TransformGroup();

        Transform3D t3d = new Transform3D();
        t3d.setScale(0.5);
        tg.setTransform(t3d);

        tg.addChild(terrain.getTerrainTransformGroup());
        objRoot.addChild(tg);


        
        // Allow zooming in and out
//        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
//        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

//        KeyNavigatorBehavior key = new KeyNavigatorBehavior(terrain.getTerrainTransformGroup());
//        key.setSchedulingBounds(getBoundingSphere());
//		key.setEnable(true);
		
		
		// Set shape appearance
//		Appearance app = new Appearance();
//		Color3f objColor = new Color3f(0.8f, 0.2f, 0.1f);
//		Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
//		Material mat = new Material();
//		mat.setLightingEnable(true);
//		mat.setAmbientColor(black);
//		app.setMaterial(mat);
//		shape.setAppearance(app);
                
        // Create shape
//        Transform3D t3d = new Transform3D();
//        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
//        t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.9f));
//        t3d.setScale(0.125);
//        tg.setTransform(t3d);
//        tg.addChild(new ColorCube());
//        objRoot.addChild(tg);
        objRoot.addChild(terrain.getTerrainTransformGroup());
//        objRoot.addChild(key);
//        objRoot.addChild(scene.getSceneGroup());
        objRoot.compile();
        return objRoot;

    }

    
    protected Bounds createApplicationBounds() {
    	return new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
    }
    
    BoundingSphere getBoundingSphere() {
		return new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 200.0);
	}

    public static void getUniverse(Terrain terrain) {

        System.setProperty("sun.awt.noerasebackground", "true");
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setLightWeightPopupEnabled(false);

        Universe universe = new Universe(terrain);
        JFrame frame = new JFrame("Robot Universe");
        frame.setSize(1000, 1000);
        frame.getContentPane().add(universe);
        frame.setVisible(true);
    }
}
