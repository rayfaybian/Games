package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor {

    protected float x, y;
    protected float speed;
    protected int diameter;
    Random random = new Random();

    public Circle(){
        this.x = (float)random.nextInt(1200);
        this.y = (float)random.nextInt(675);
        this.diameter = 50;
        this.speed = (float)random.nextInt(25)+1;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    @Override
    public float getY() {
        return 0;
    }

    public void update(GameContainer gameContainer, int delta) {
    }
}

