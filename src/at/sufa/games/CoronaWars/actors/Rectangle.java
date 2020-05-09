package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle implements Actor {

    private float x,y;
    private int width;
    private int height;
    private float speed;


    public Rectangle(float x, float y, int width, int height, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;

    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);

    }

    public void update(GameContainer gameContainer, int delta) {

             this.x += (float) delta / this.speed;
                if (this.x > 800) {
                    this.x = (-this.width);
                }

    }
    @Override
    public float getY() {
        return 0;
    }
}
