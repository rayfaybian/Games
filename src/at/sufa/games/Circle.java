package at.sufa.games;

import org.newdawn.slick.Graphics;

import javax.swing.*;

public class Circle implements Actor {
    public enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    private float x, y;
    private int diameter;
    private float speed;
    private DIRECTION direction;
    private int originalDiameter;
    private int counter;

    public Circle(float x, float y, int diameter, float speed, DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.speed = speed;
        this.direction = direction;
        this.originalDiameter = diameter;
        this.counter = 0;
    }


    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);

    }

    public void update(int delta) {
        counter++;
        if (counter == 10 && this.diameter < (this.originalDiameter*5)) {
            this.diameter++;
            counter = 0;
               }
        switch (direction) {
            case RIGHT:
                this.x += (float) delta / this.speed;
                if (this.x == 800) {
                    this.x = 0;
                    this.diameter = originalDiameter;
                }
                break;

            case LEFT:
                this.x -= (float) delta / this.speed;
                this.diameter += (float) delta / this.speed;
                if (this.x < 1) {
                    this.x = 800;
                    this.diameter = originalDiameter;
                }
                break;

            case UP:
                this.y += (float) delta / this.speed;
                this.diameter += (float) delta / this.speed;
                if (this.y > 800) {
                    this.y = 0;
                    this.diameter = originalDiameter;
                }
                break;

            case DOWN:
                this.y -= (float) delta / this.speed;
                this.diameter += (float) delta / this.speed;
                if (this.y < 1) {
                    this.y = 800;
                    this.diameter = originalDiameter;
                }
                break;

        }


    }
}
