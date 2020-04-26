package at.sufa.games.snowworld;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnowWorld extends BasicGame {

    private List<Actor> snowflakes;

    public SnowWorld(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.snowflakes = new ArrayList<>();
        for (int j = 0; j < 400; j++) {
            Snowflake smallFlake = new Snowflake(Snowflake.SIZE.SMALL);
            this.snowflakes.add(smallFlake);
            Snowflake middleFlake = new Snowflake(Snowflake.SIZE.MIDDLE);
            this.snowflakes.add(middleFlake);
            Snowflake bigFlake = new Snowflake(Snowflake.SIZE.BIG);
            this.snowflakes.add(bigFlake);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : snowflakes) {
            actor.update(delta);

        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : snowflakes) {
            actor.render(graphics);

        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SnowWorld("SnowWorld3000"));
            container.setDisplayMode(1200, 675, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
