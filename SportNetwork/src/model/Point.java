package model;



public class Point {

	public PointType type;
	public double x ;
	public double y;
	
	
	public Point(double x,double y,PointType type) {
		this.x=x;
		this.y=y;
		this.type=type;
	}
	
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
		this.type=PointType.NONE;
	}
	public PointType getType() {
		return type;
	}
	
}