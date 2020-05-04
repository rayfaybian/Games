package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;

public class RightCircle extends Circle {


    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x -= (float) delta / this.speed;
        if (this.x < 0) {
            this.x = 1200;
        }
    }
}
