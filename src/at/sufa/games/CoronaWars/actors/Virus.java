package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class Virus implements Actor {
    private int size;
    private float x,y;
    private float speed;
    private float xEnd;
    private float xStart;
    private Image myImage;
    private boolean goLeft;


    public Virus(int size, float x, float y, float speed) throws SlickException {
        Random random = new Random();
        this.size = size;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.xStart = x;
        this.xEnd = x + random.nextInt(40) + 25;
        Image tmp = new Image("src/at/sufa/games/CoronaWars/graphics/Corona.png");
        this.myImage = tmp.getScaledCopy(this.size,this.size);
        goLeft = false;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(this.x >= xEnd){
            goLeft = true;
        }
        if(this.x <= xStart){
            goLeft = false;
        }
        if(!goLeft){
            this.x += (float)delta/this.speed;
        }
        if(goLeft) {
            this.x -= (float) delta / this.speed;
        }
    }

    @Override
    public void render(Graphics graphics) {
        this.myImage.draw(this.x,this.y);

    }

    @Override
    public float getY() {
        return 0;
    }
}
