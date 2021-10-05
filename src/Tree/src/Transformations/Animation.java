package Tree.src.Transformation;

import java3D.Point3f;
import java3D.Transform3D;
import main.TransformNode;

public class Animation {
	
	private PositionPathInterpolator interpolator;
	private TransformNode node;
	private TransformNode parent;
	private int n;
	
	public Animation(TransformNode node, TransformNode parent, int n) {
		this.node = node;
		this.parent = parent;
		this.n = n;
		
        Alpha alpha = new Alpha();
		Transform3D axis = new Transform3D();
		float[] knots = this.createKnots();
		Point3f[] positions = new Point3f[n];
		switch(node.getNeuron().getType()) {
			case "oscillator":
				this.createSinePoints();
				long halfPeriod = (long)node.getNeuron().getPeriod()*1000;
				alpha.setIncreasingAlphaDuration(halfPeriod);
				alpha.setDecreasingAlphaDuration(halfPeriod);
				alpha.setLoopCount(-1);
				break;
			case "sigmoid":
				this.createSigmoidPoints();
				alpha.setIncreasingAlphaDuration(node.getNeuron().getPeriod()*1000;
				alpha.setLoopCount(1);
				break;
		}
		interpolator = new PositionPathInterpolator(alpha, node, axis, knots, positions);
		
		BoundingSphere boundingSphere = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1.0);
		interpolator.setSchedulingBounds(boundingSphere);
	}
	
	private Point3f createPoint3f(double u) {
		double x = 0;
		double y = 0;
		double z = 0;
		
		switch(node.getOrient()) {
		case 1:
			x = -u;
			break;
		case 2:
			y = u;
			break;
		case 3:
			y = -u;
		default:
			y = u;
			break;
		}
		return new Point3f(x, y, z);
	}
	
	private float[] createKnots(){
		float[] knots = new float[n];
		for(int i=0; i<this.n; i++){
		  	knots[i] = i;
		}
		return knots;
	}
	
	private Point3f[] createSinePoints() {
		Point3f[] positions = new Point3f[n];
		double amp = node.getNeuron().getGain();
		double u;
		for(int i=0; i<n; i++) {
			double th = 2*Math.PI/i;	//may oscillate into rest of robot...may need to just take half the period
			u = Math.abs(amp * Math.sin(th));
			positions[i] = createPoint3f(u);
			
			if(i%10==0) {
				System.out.println(positions[i].toString()+"\n");
			}
		}
		return positions;
	}
	
	private Point3f[] createSigmoidPoints() {
		Point3f[] positions = new Point3f[n];
		double amp = node.getNeuron().getGain();
		double u;
		for(int i=0; i<n; i++) {
			double th = 2*Math.PI/i; //half wave
			u = Math.abs(amp/(1+Math.pow(Math.E, -th)));
			positions[i] = createPoint3f(u);
		}
		return positions;
	}
	
	public void setAnimation() {
		parent.addChild(interpolator);
	}
}
