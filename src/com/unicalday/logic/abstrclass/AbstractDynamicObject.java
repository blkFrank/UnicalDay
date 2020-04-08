package com.unicalday.logic.abstrclass;

import java.awt.Rectangle;



public abstract class AbstractDynamicObject extends AbstractStaticObject{
		
		protected float velX = 0, velY = 0;
		private float gravity = 0.20f;
		private float MAX_SPEED = 10;
		
		protected Direction direction;
		
		protected boolean falling = true;
		protected boolean jumping = true;
		
		
		
		
		public AbstractDynamicObject(float x, float y, float width, float height, ObjectID id,  Direction direction) {
			super(x, y, width, height, id);
			this.direction = direction;
		}
		
		public Direction getDirection() { return direction; }
		public void setDirection(Direction dir) { direction = dir; }

		public float getVelX() { return velX; }
		public float getVelY() { return velY; }
		public void setVelX(float velX) { this.velX = velX; }
		public void setVelY(float velY) { this.velY = velY; }
			
		public boolean isFalling() { return falling; }
		public boolean isJumping() { return jumping; }
		public void setFalling(boolean falling) { this.falling = falling; }
		public void setJumping(boolean jumping) { this.jumping = jumping; }
			
		public void tick() {
			x += velX;
			y += velY;
			
			if (velX < 0) {
				setDirection(Direction.IDLELEFT);
			}
			else if (velX > 0) {
				setDirection(Direction.IDLERIGHT);
			}
			if (falling || jumping)
			{
				velY += gravity;
				if (velY > MAX_SPEED)
					velY = MAX_SPEED;
			}
		}
		
		@Override
		public Rectangle getBounds() {
			return new Rectangle((int) ((int) x + (width/2) - ((width/2)/2)), (int) ((int) y + (height/2)), (int) width / 2, (int) height / 2);
		}
		
		public Rectangle getBoundsTop() {
			return new Rectangle((int) ((int) x + (width/2) - ((width/2)/2)), (int) y, (int) width / 2, (int) height / 2);
		}
		
		public Rectangle getBoundsRight() {
			return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
		}
		
		public Rectangle getBoundsLeft() {
			return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
		}

}