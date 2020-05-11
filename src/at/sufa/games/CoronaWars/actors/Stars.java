package at.sufa.games.CoronaWars.actors;

import at.sufa.games.CoronaWars.movements.DownMoveStrategy;
import at.sufa.games.CoronaWars.movements.MoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Stars implements Actor {
    private MoveStrategy downMoveStrategy;
    private float speed;
    private float diameter;


    public Stars(int x, int y, float speed, float diameter) {
        this.downMoveStrategy = new DownMoveStrategy(x, y, speed);
        this.speed = speed;
        this.diameter = diameter;

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.downMoveStrategy.update(delta);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(downMoveStrategy.getX(), downMoveStrategy.getY(), diameter, diameter);

    }

    @Override
    public float getY() {
        return 0;
    }
}
