package ReadJson.src;

public class BrainData {

private String id;
	private String type;
	private double gain;
	private double period;
	private double phaseOffset;

	public BrainData(){
		this.setType("Sigmoid");
		this.setPeriod(-1);
		this.setPhaseOffset(-1);
	}
	
	public BrainData(String id, double gain) {
		this.setId(id);
		this.setGain(gain);
		this.setType("Sigmoid");
		this.setPeriod(-1);
		this.setPhaseOffset(-1);
	}

    public BrainData(String id, double gain, double period, double phaseOffset) {
		this.setId(id);
		this.setGain(gain);
		this.setPeriod(period);
		this.setPhaseOffset(phaseOffset);
		this.setType("Oscillator");
	}

	public String getId() {
		return id;
	}
	public String getType() {
		return type;
	}

	public double getGain() {
		return gain;
	}

	public double getPeriod() {
		return period;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}

	public void setPeriod(double period) {
		this.period = period;
	}

	public double getPhaseOffset() {
		return phaseOffset;
	}

	public void setPhaseOffset(double phaseOffset) {
		this.phaseOffset = phaseOffset;
	}
	public String toString() {
		return getId() +" "+ getType() +" "+ getGain() +" "+ getPeriod() +" "+ getPhaseOffset()+" ";
	}

}
