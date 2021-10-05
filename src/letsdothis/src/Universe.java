package letsdothis.src;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;
import java.applet.Applet;
import java.awt.*;

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
//        addLights(scene);
        universe.getViewingPlatform().setNominalViewingTransform();

        universe.getViewer().getView().setBackClipDistance(100.0);
        universe.addBranchGraph(scene);

    }
  
    
    private BranchGroup createSceneGraph(Terrain terrain) {
    	// NOTE: This is a temporary method. It will be replaced with createTerrain() when STL files work

        BranchGroup objRoot = new BranchGroup();
        addLights(objRoot);

        TransformGroup objScale = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setScale(0.5);
        objScale.setTransform(t3d);

        TransformGroup objTrans = new TransformGroup();
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        objScale.addChild(objTrans);

        objTrans.addChild(terrain.getTerrainTransformGroup());
        objRoot.addChild(objScale);

        KeyNavigatorBehavior key = new KeyNavigatorBehavior(terrain.getTerrainTransformGroup());
        key.setSchedulingBounds(getBoundingSphere());
		key.setEnable(true);

		Appearance app = new Appearance();
		Color3f objColor = new Color3f(0.8f, 0.2f, 0.1f);
		Color3f black = new Color3f(0.5f, 0.0f, 0.3f);
		Material mat = new Material();
		mat.setLightingEnable(true);
		mat.setAmbientColor(black);
		app.setMaterial(mat);

        objRoot.addChild(key);
        objRoot.compile();
        return objRoot;

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

    public void addLights(BranchGroup bg) {
        Color3f color = new Color3f(1.0f, 1.0f, 0.0f);
        Vector3f direction = new Vector3f(-1.0f, -1.0f, -1.0f);
        DirectionalLight light = new DirectionalLight(color, direction);
        light.setInfluencingBounds(getBoundingSphere());
        bg.addChild(light);
    }
}
