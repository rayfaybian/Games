package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {

    void update(GameContainer gameContainer, int delta);

    void render(Graphics graphics);
}
