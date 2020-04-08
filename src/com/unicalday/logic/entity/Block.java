package com.unicalday.logic.entity;

import java.awt.Rectangle;

import com.unicalday.logic.abstrclass.AbstractStaticObject;
import com.unicalday.logic.abstrclass.ObjectID;

public class Block extends AbstractStaticObject {
	
	private int code;
	
	public Block(float x, float y, float width, float height, ObjectID id, int code) {
		super(x, y, width, height, id);
		this.code = code;
	}
	
	@Override
	public Rectangle getBounds() {
		return this.rectangle;
	}

	@Override
	public int getCode() {
		return code;
	}
	public void setCode(int c)
	{
		code=c;
	}
	
}
