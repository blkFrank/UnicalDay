package com.unicalday.logic.abstrclass;

import java.awt.Rectangle;


public abstract class AbstractStaticObject {
	
	protected float x;
	protected float y;
	protected float width;
	protected float height;
	protected Rectangle rectangle;
	protected ObjectID id;
	
	public AbstractStaticObject(float x, float y, float width, float height, ObjectID id) {
		rectangle = new Rectangle((int) x, (int) y, (int) width, (int) height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
	}
	
	public float getX() { return x; }
	public float getY() { return y; }
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }
	
	public float getWidth() { return width; }
	public float getHeight() { return height; }
	
	public Rectangle getRectangle() { return rectangle; }
	public abstract Rectangle getBounds();	
	public int getCode() { return getCode(); }
	
	
	public ObjectID getID() { return id; }
	public void setID (ObjectID i) { id=i;}
	
	
}