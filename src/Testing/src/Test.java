package ReadJson.src;
import java.applet.*;
import java.awt.*;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;

import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.PlatformGeometry;

public class Test extends Applet {

    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;
    private TransformGroup viewtrans = null;

        public Test() {
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
        private BranchGroup createColorCube() {

            BranchGroup objRoot = new BranchGroup();

            PartData partData = new PartData("core", "CoreComponent");
            TransformNode transformNode = new TransformNode(partData);

            Transform3D t3d = new Transform3D();

            t3d.setTranslation(new Vector3d(0.0, 0.3, -1.5));
            t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
            t3d.setScale(0.125);

            transformNode.setTransform(t3d);

            PartData part2 = new PartData("id", "FixedBrick");
            TransformNode tg_2 = new TransformNode(part2);

            Transform3D t3d_2 = new Transform3D();

            t3d_2.setTranslation(new Vector3d(5.0, 0.0, 0.0));
            t3d_2.setRotation(new AxisAngle4f(0.0f, 1.0f, 0.0f, 3.14f));
            t3d_2.setScale(0.1);

            tg_2.setTransform(t3d_2);
            transformNode.addChild(tg_2);

            objRoot.addChild(transformNode);

            objRoot.compile();
            return objRoot;

        }
        private BranchGroup createSceneGraph() {
            BranchGroup objRoot = new BranchGroup();

            objRoot.addChild(createColorCube());
            return objRoot;
        }

    public static void main(String[] args){
        System.setProperty("sun.awt.noerasebackground", "true");
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setLightWeightPopupEnabled(false);

        Test test = new Test();
        JFrame frame = new JFrame("Java3D Prototype");
        frame.setSize(1000, 1000);
        frame.getContentPane().add(test);
        frame.setVisible(true);

    }
}
