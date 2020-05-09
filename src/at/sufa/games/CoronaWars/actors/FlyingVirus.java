package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class FlyingVirus implements Actor {
    private int size;
    private float x, y;
    private float speed;
    private Image myImage;


    public FlyingVirus(int size) throws SlickException {
        this.size = size;
        this.x = 1;
        this.y = -110;
        this.speed = size / 2.00f;
        Image tmp = new Image("src/at/sufa/games/CoronaWars/graphics/Corona.png");
        this.myImage = tmp.getScaledCopy(this.size, this.size);

    }


    @Override
    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        int tempX;
        this.x -= (float) delta / this.speed;
        this.y += (float) delta / this.speed;

        if ((this.x <= -size) || (this.y >= 675 + size)) {
            this.y = -110;
            this.x = random.nextInt(1500);
        }


    }

    @Override
    public void render(Graphics graphics) {
        this.myImage.draw(this.x, this.y);

    }

    @Override
    public float getY() {
        return 0;
    }
}
