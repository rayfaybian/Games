package at.sufa.firstGame;

import org.newdawn.slick.Graphics;

public class Rectangle implements Actor {
    public enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    private float x,y;
    private int width;
    private int height;
    private float speed;
    private DIRECTION direction;

    public Rectangle(float x, float y, int width, int height, float speed, DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);

    }

    public void update(int delta) {

        switch (direction) {
            case RIGHT:
                this.x += (float) delta / this.speed;
                if (this.x > 800) {
                    this.x = (-this.width);
                }
                break;

            case LEFT:
                this.x -= (float) delta / this.speed;
                if (this.x < (-this.width)) {
                    this.x = 800;
                }
                break;

            case UP:
                this.y += (float) delta / this.speed;
                if(this.y > 800) {
                    this.y = (-this.height);
                }
                break;

            case DOWN:
                this.y -= (float) delta / this.speed;
                if (this.y < (-this.height)) {
                    this.y = 800;
                }
                break;

        }

    }
}
