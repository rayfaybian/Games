package at.sufa.games.CoronaWars.actors;

import at.sufa.games.CoronaWars.movements.DiagonalMoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class FlyingVirus implements Actor {
    private DiagonalMoveStrategy diagonalMoveStrategy;
    private Image myImage;


    public FlyingVirus(int size) throws SlickException {

        float x = 1;
        float y = -110;
        float speed = size / 2.00f;

        this.diagonalMoveStrategy = new DiagonalMoveStrategy(x, y, size, speed);

        Image tmp = new Image("src/at/sufa/games/CoronaWars/graphics/Corona.png");
        this.myImage = tmp.getScaledCopy(size, size);

    }


    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.diagonalMoveStrategy.update(delta);
    }

    @Override
    public void render(Graphics graphics) {
        this.myImage.draw(diagonalMoveStrategy.getX(), diagonalMoveStrategy.getY());

    }

    @Override
    public float getY() {
        return 0;
    }
}
