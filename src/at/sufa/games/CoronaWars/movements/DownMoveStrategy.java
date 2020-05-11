package at.sufa.games.CoronaWars.movements;

import java.util.Random;

public class DownMoveStrategy implements MoveStrategy {
    private float x,y;
    private float speed;

    public DownMoveStrategy(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    public void update(int delta){
        Random random = new Random();
        this.y += (float)delta/this.speed;
        if(this.y > 683 ){
            this.x = random.nextInt(1200);
            this.y = 0;
        }

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
