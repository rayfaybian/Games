package at.sufa.games.CoronaWars.screens;

import at.sufa.games.CoronaWars.actors.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Startscreen implements Actor {
    private String copyright;
    private String dCVPresents;
    private String cCGame;
    private Image logo;

    private long switch1;
    private long switch2;
    private long switch3;

    public Startscreen() throws SlickException {
        this.logo = new Image("src/at/sufa/games/CoronaWars/graphics/DCV Logo.png");
        this.copyright = "Copyright © 2020 by Fabian Suppan";
        this.dCVPresents = "presents";
        this.cCGame = "A Coding Campus Game";

        //graphics get synced to music
        long t = System.currentTimeMillis();
        this.switch1 = t + 6000;
        this.switch2 = t + 9500;
        this.switch3 = t + 11500;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
    }

    @Override
    public void render(Graphics graphics) {

        if (System.currentTimeMillis() < switch1) {
            graphics.drawString(this.copyright, 452, 328);
        }
        if ((System.currentTimeMillis() > switch1 + 1000) && (System.currentTimeMillis() < switch2)) {
            graphics.drawString(this.dCVPresents, 565, 410);
            logo.draw(417,269);
        }
        if (System.currentTimeMillis() > switch3 && System.currentTimeMillis() < switch3 + 3000) {
            graphics.drawString(this.cCGame, 510, 328);
        }

        //lines to help adjust text
        //graphics.drawLine(450, 0, 450, 675); //left
        //graphics.drawLine(750, 0, 750, 675); //right
        //graphics.drawLine(600, 0, 600, 675); //middle
        //graphics.drawLine(0, 337, 1200, 337); //horizontal
    }

    @Override
    public float getY() {
        return 0;
    }

}

