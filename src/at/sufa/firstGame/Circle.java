package at.sufa.firstGame;

import org.newdawn.slick.Graphics;

public class Circle implements Actor {
    public enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    private float x, y;
    private int startDiameter;
    private float speed;
    private DIRECTION direction;
    private int finalDiameter;
    private int counter;
    private int diameter;

    public Circle(float x, float y, int startDiameter, float speed, DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.startDiameter = startDiameter;
        this.finalDiameter = (startDiameter * 3);
        this.speed = speed;
        this.direction = direction;
        this.diameter = startDiameter;
        this.counter = 0;
    }


    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    public void update(int delta) {
        counter++;
        if (counter == (this.speed * 4)) {
            this.diameter++;
            counter = 0;
        }

        switch (direction) {
            case RIGHT:
                this.x += (float) delta / this.speed;
                if (this.x > 799) {
                    this.x = (-this.diameter);
                    this.diameter = startDiameter;
                    counter = 0;
                }
                break;

            case LEFT:
                this.x -= (float) delta / this.speed;
                if (this.x < ( - this.diameter)) {
                    this.x = 800;
                    this.diameter = startDiameter;
                    counter = 0;
                }
                break;

            case UP:
                this.y += (float) delta / this.speed;
                this.startDiameter += (float) delta / this.speed;
                if (this.y > 799) {
                    this.y = (-this.diameter);
                    this.diameter = startDiameter;
                    counter = 0;
                }
                break;

            case DOWN:
                this.y -= (float) delta / this.speed;
                this.startDiameter += (float) delta / this.speed;
                if (this.y < ( - this.diameter)) {
                    this.y = 800;
                    this.diameter = startDiameter;
                    counter = 0;
                }
                break;

        }


    }
}
