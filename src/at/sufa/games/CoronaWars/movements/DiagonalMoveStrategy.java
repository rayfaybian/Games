package at.sufa.games.CoronaWars.movements;

import java.util.Random;

public class DiagonalMoveStrategy implements MoveStrategy {
    private float x,y;
    private int size;
    private float speed;

    public DiagonalMoveStrategy(float x, float y, int size, float speed){
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;


    }
    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void update(int delta) {
        Random random = new Random();
        this.x -= (float) delta / this.speed;
        this.y += (float) delta / this.speed;

        if ((this.x <= -size) || (this.y >= 675 + size)) {
            this.y = -110;
            this.x = random.nextInt(1500);
        }

    }
}
