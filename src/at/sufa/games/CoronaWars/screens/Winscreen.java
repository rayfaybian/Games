package at.sufa.games.CoronaWars.screens;

import at.sufa.games.CoronaWars.actors.Actor;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Winscreen implements Actor {
    private AngelCodeFont font;
    private int score;


    public Winscreen() throws SlickException {
        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
    }

    @Override
    public void render(Graphics graphics) {
        font.drawString(425,220,"Congratulations!");
        font.drawString(510, 270, "You won!");
        font.drawString(425,320, "Score: " + score + (" points"));
        graphics.drawString("Press SPACE to try again", 492,420);
        graphics.drawString("Press ESC to close game", 497,440);

        /*graphics.drawLine(450, 0, 450, 675); //left
        graphics.drawLine(750, 0, 750, 675); //right
        graphics.drawLine(600, 0, 600, 675); //middle
        graphics.drawLine(0, 337, 1200, 337); //horizontal*/


    }

    @Override
    public float getY() {
        return 0;
    }

    public void setScore(int score){
        this.score = score;
    }

}
