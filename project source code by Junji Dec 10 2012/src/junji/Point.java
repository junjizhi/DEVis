package junji;
import java.lang.Math;

//float type point
public class Point
{
	public Point(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	private float x, y;
	
	public float distance(Point p)
	{
		return (float)Math.sqrt((x-p.getX())*(x-p.getX())+(y-p.getY())*(y-p.getY()));
	}
	
	public float distance(float px, float py)
	{
		return (float)Math.sqrt((x-px)*(x-px)+(y-py)*(y-py));
	}
}