package letsdothis.src;
import Tree.src.TransformNode;
import Tree.src.TreeBuilder;
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
		this.terrainTransformGroup = new TransformGroup();
		
		terrainTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		terrainTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.9f));
        t3d.setScale(0.125);
        terrainTransformGroup.setTransform(t3d);
        this.addTree(terrainTransformGroup, tree);
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
	
	private void addTree(TransformGroup terrainTransformGroup, TransformNode tree) {

		terrainTransformGroup.addChild(tree);
        //terrainTransformGroup.addChild(new ColorCube());
	}
	
}
