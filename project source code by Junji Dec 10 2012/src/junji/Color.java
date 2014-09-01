package junji;

public class Color {

	public Color(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getR() {
		return r;
	}



	public void setR(int r) {
		this.r = r;
	}



	public int getG() {
		return g;
	}



	public void setG(int g) {
		this.g = g;
	}



	public int getB() {
		return b;
	}



	public void setB(int b) {
		this.b = b;
	}



	private int r, g, b;
	
	public String toString()
	{
		return "("+r +","+g+","+b+")";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
