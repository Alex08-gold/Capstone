package Testing.src;

import java.applet.*;
import java.awt.*;
import java.io.FileNotFoundException;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class RenderTest extends Applet {

    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;

    public RenderTest() throws FileNotFoundException {

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
        // Creating wireframe appearance
        Appearance app = new Appearance();
        PolygonAttributes polyAttrbutes = new PolygonAttributes();
        polyAttrbutes.setPolygonMode( PolygonAttributes.POLYGON_LINE );
        polyAttrbutes.setCullFace( PolygonAttributes.CULL_NONE ) ;
        app.setPolygonAttributes( polyAttrbutes );

        Shape3D shape = new Shape3D();
        shape.setAppearance(app);

        BranchGroup objRoot = new BranchGroup();
        ObjectFile objFile = new ObjectFile(ObjectFile.RESIZE | ObjectFile.TRIANGULATE);
        Scene objscene = objFile.load("/home/alex/IdeaProjects/Capstone/CoreComponent.obj");

        TransformGroup objScale = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setScale(0.5);
        objScale.setTransform(t3d);
        objRoot.addChild(objScale);

        TransformGroup objTrans = new TransformGroup();
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        objScale.addChild(objTrans);

        objTrans.addChild(objscene.getSceneGroup());
        objTrans.addChild(shape);

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

        RenderTest test = new RenderTest();
        JFrame frame = new JFrame("Java3D Prototype");
        frame.setSize(1000, 1000);
        frame.getContentPane().add(test);
        frame.setVisible(true);

    }
}
