package at.sufa.games.CoronaWars.screens;

import at.sufa.games.CoronaWars.actors.Actor;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Losescreen implements Actor {
    private AngelCodeFont font;


    public Losescreen() throws SlickException {
        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
    }
    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public void render(Graphics graphics) {
        font.drawString(445,220,"No more lives!");
        font.drawString(505,270,"You lost!");
        graphics.drawString("Press SPACE to try again", 492,420);
        graphics.drawString("Press ESC to close game", 497,440);

    }

    @Override
    public float getY() {
        return 0;
    }
}
