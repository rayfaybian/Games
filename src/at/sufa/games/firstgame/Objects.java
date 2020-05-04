package at.sufa.games.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*Programmiere das Beispiel aus den Videos nach!

Mache folgende Adaptierungen

    Es gibt 10 Rectangles
    Es gibt 10 Circles
    Es gibt 10 Eclipsen (müssen wieder herinfliegen)

Baue folgende Objekte dazu:

    Baue die Rectangles so um, damit man im Konstruktor angeben kann ob sie von links nach rechts oder umgekehrt fliegen.
    Die Circles sollen im laufe des Fluges wachsen - immer größer werden (der Durchmesser wächst)*/

public class Objects extends BasicGame {
    private List<Actor> actors;


    public Objects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Rectangle.DIRECTION recDirection = null;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int myRandom = random.nextInt(3);
            switch (myRandom) {
                case 0:
                    recDirection = Rectangle.DIRECTION.LEFT;
                    break;
                case 1:
                    recDirection = Rectangle.DIRECTION.RIGHT;
                    break;
                case 2:
                    recDirection = Rectangle.DIRECTION.UP;
                    break;
                case 3:
                    recDirection = Rectangle.DIRECTION.DOWN;
                    break;
            }
            Rectangle rectangle = new Rectangle((float) random.nextInt(800), (float) random.nextInt(800),
                    random.nextInt(100), random.nextInt(100), (float) random.nextInt(20+1),
                    recDirection);
            this.actors.add(rectangle);

        }
        Circle.DIRECTION circleDirection = null;
        for (int i = 0; i < 10; i++) {
            int myRandom = random.nextInt(3);
            switch (myRandom) {
                case 0:
                    circleDirection = Circle.DIRECTION.LEFT;
                    break;
                case 1:
                    circleDirection = Circle.DIRECTION.RIGHT;
                    break;
                case 2:
                    circleDirection = Circle.DIRECTION.UP;
                    break;
                case 3:
                    circleDirection = Circle.DIRECTION.DOWN;
                    break;
            }
            Circle circle = new Circle((float) random.nextInt(800), (float) random.nextInt(800),
                    random.nextInt(10), (float) random.nextInt(20+1), circleDirection);
            this.actors.add(circle);

        }
        Ellipse.DIRECTION ellipseDirection = null;
        for (int i = 0; i < 10; i++) {
            int myRandom = random.nextInt(3);
            switch (myRandom) {
                case 0:
                    ellipseDirection = Ellipse.DIRECTION.LEFT;
                    break;
                case 1:
                    ellipseDirection = Ellipse.DIRECTION.RIGHT;
                    break;
                case 2:
                    ellipseDirection = Ellipse.DIRECTION.UP;
                    break;
                case 3:
                    ellipseDirection = Ellipse.DIRECTION.DOWN;
                    break;
            }

            Ellipse ellipse = new Ellipse((float) random.nextInt(800), (float) random.nextInt(80),
                    random.nextInt(100), random.nextInt(100), (float) random.nextInt(20+1),
                    ellipseDirection);
            this.actors.add(ellipse);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects("Rectangles & Circles"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}