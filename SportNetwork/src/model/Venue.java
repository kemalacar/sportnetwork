package model;

public class Venue {
	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", point=" + point + "]";
	}
	private String id;
	private String name;
	private Point point;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
}
