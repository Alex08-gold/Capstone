package letsdothis.src;

public class RobotWindow {
	private int windowHeight;
	private int windowWidth;
	
	public RobotWindow(int defaultHeight, int defaultWidth) {
		this.windowHeight = defaultHeight;
		this.windowWidth = defaultWidth;
	}
	
	
	
	public int getTerrainHeight() {
		return windowHeight;
	}
	
	public int getTerrainWidth() {
		return windowWidth;
	}
}
