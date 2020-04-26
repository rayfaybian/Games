package at.sufa.games.snowworld;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor {


    public enum SIZE {SMALL, MIDDLE, BIG}


    private float x, y;
    private int size;
    private float speed;
    private Random random;

    public Snowflake(SIZE size) {
        this.random = new Random();

        switch (size) {
            case SMALL:
                this.size = 4;
                this.speed = 10;
                break;
            case MIDDLE:
                this.size = 8;
                this.speed = 5;
                break;
            case BIG:
                this.size = 12;
                this.speed = 2;
                break;
        }
        setRandomPosition();
    }

    public void setRandomPosition() {
        this.x = (float) this.random.nextInt(1200);
        this.y = (float) this.random.nextInt(1000) - 1000;
    }

    @Override
    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 1080)
            setRandomPosition();

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.size, this.size);
    }

}
