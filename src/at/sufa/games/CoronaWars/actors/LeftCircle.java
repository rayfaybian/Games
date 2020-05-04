package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;

public class LeftCircle extends Circle {

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x += (float) delta / this.speed;
        if (this.x > 1200) {
            this.x = 0;
        }
    }
}

