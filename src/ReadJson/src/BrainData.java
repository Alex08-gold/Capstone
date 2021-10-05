package ReadJson.src;

public class BrainData {

private String id;
	private String type;
	private double gain;
	private double period;
	private double phaseOffset;
	
	public BrainData(String id, double gain) {
		this.id = id;
		this.gain = gain;
		this.type = "Sigmoid";
		this.period = -1;
		this.phaseOffset = -1;
	}

    public BrainData(String id, double gain, double period, double phaseOffset) {
		this.id = id;
		this.gain = gain;
		this.period = period;
		this.phaseOffset = phaseOffset;
		this.type = "Oscillator";
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getType() {
		return this.type;
	}
	
	public double getGain() {
		return this.gain;
	}
	
	public double getPeriod() {
		return period;
	}
	
	public double getOffset() {
		return phaseOffset;
	}
	
	public String toString() {
		return id+" "+type+" "+gain+" "+period+" "+phaseOffset;
	}

}
