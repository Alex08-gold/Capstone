package RenderRobot.src;
import Tree.src.TransformNode;
import Tree.src.TreeBuilder;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.geometry.ColorCube;
import java.applet.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Terrain {
	private int height;
	private int width;
	private TransformGroup terrainTransformGroup;
	
	public Terrain(int height, int width, TransformNode tree) {
		this.height = height;
		this.width = width;

		// Create transform group that the robot body tree can be attached to
		this.terrainTransformGroup = new TransformGroup();
		terrainTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		terrainTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.9f));
        t3d.setScale(0.125);
        terrainTransformGroup.setTransform(t3d);
		this.terrainTransformGroup.addChild(tree);
	}
	
	public void setDimensions(int newHeight, int newWidth) {
		height = newHeight;
		width = newWidth;
	}
	
	public int getTerrainHeight() {
		return height;
	}
	
	public int getTerrainWidth() {
		return width;
	}
	
	public TransformGroup getTerrainTransformGroup() {
		return terrainTransformGroup;
	}

	public static void addPlane(BranchGroup bg) {

		Scene scene = null;

		// Read in the Body4.obj file. This is a rectangle that functions as a plane.
		ObjectFile objFileloader = new ObjectFile(ObjectFile.RESIZE);
		try {
			scene = objFileloader.load("object_files/Body4.obj");
		} catch (Exception e) {
			scene = null;
			System.err.println(e);
		}
		if (scene == null)
			System.exit(1);

		// Add the scene graph to the branch group as a child
		bg.addChild(scene.getSceneGroup());
	}
}