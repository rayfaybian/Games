package at.sufa.games.firstgame;

import org.newdawn.slick.Graphics;

public class Ellipse implements Actor {
    public enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    private float x,y;
    private int width;
    private int height;
    private float speed;
    private Ellipse.DIRECTION direction;

    public Ellipse(float x,float y, int width, int height, float speed, Ellipse.DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
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
                if (this.y > 800) {
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

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x,this.y, this.width, this.height);

    }
}
