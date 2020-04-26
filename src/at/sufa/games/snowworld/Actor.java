package at.sufa.games.snowworld;

import org.newdawn.slick.Graphics;

public interface Actor {

    void update(int delta);

    void render(Graphics graphics);
}
