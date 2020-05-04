package at.sufa.games.CoronaWars;

import at.sufa.games.CoronaWars.actors.*;
import at.sufa.games.CoronaWars.screens.Hud;
import at.sufa.games.CoronaWars.screens.StartScreen;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends BasicGame {
    private List<Actor> backgroundActors;
    private List<Actor> levelOneActors;
    private List<Actor> levelTwoActors;
    private List<Actor> levelThreeActors;

    private SpaceShip spaceShip;
    private List<Enemy> enemies;
    private Enemy levelOneEnemy;
    private Enemy levelTwoEnemy;
    private Enemy levelThreeEnemy;
    private Image wallpaper;

    private Hud hud;
    private StartScreen startScreen;
    private boolean gameStart;
    private Music inGameMusic;
    private int level1 = 0;
    private int level2 = 10;
    private int level3 = 20;

    public Game(String title) throws SlickException {
        super(title);

    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.backgroundActors = new ArrayList<Actor>();
        gameStart = false;
        this.startScreen = new StartScreen();

        inGameMusic = new Music("src/at/sufa/games/CoronaWars/music/Chop Suey Music.ogg");


        Image tmp = new Image("src/at/sufa/games/CoronaWars/graphics/wallpaper/Space.jpg");
        this.wallpaper = tmp.getScaledCopy(1200, 675);

        Random random = new Random();
        for (int i = 0; i < 600; i++) {
            Stars stars1 = new Stars(random.nextInt(1200), random.nextInt(675), 25, 3);
            this.backgroundActors.add(stars1);
        }
        for (int i = 0; i < 80; i++) {
            Stars stars2 = new Stars(random.nextInt(1200), random.nextInt(675), 20, 5);
            this.backgroundActors.add(stars2);
        }
        for (int i = 0; i < 40; i++) {
            Stars stars3 = new Stars(random.nextInt(1200), random.nextInt(675), 15, 7);
            this.backgroundActors.add(stars3);
        }


        this.spaceShip = new SpaceShip();


        for (int i = 0; i < 1; i++) {

            this.levelOneActors = new ArrayList<Actor>();

            this.enemies = new ArrayList<>();

            this.levelOneEnemy = new Enemy(100);
            this.enemies.add(levelOneEnemy);
            this.levelOneActors.add(levelOneEnemy);
            this.spaceShip.addCollisionPartner(levelOneEnemy);
        }
        this.levelTwoActors = new ArrayList<Actor>();
        for (int i = 0; i < 10; i++) {
            this.levelTwoEnemy = new Enemy(50);
            this.enemies.add(levelTwoEnemy);
            this.levelTwoActors.add(levelTwoEnemy);
            this.spaceShip.addCollisionPartner(levelTwoEnemy);
        }
        this.levelThreeActors = new ArrayList<Actor>();
        for (int i = 0; i < 15; i++) {
            this.levelThreeEnemy = new Enemy(20);
            this.enemies.add(levelThreeEnemy);
            this.levelThreeActors.add(levelThreeEnemy);
            this.spaceShip.addCollisionPartner(levelThreeEnemy);
        }
        this.hud = new Hud();
    }


    @Override
    public void keyPressed(int key, char c) {
        if (!gameStart) {
            if (key == Input.KEY_SPACE) {
                startScreen.stopMusic();
                inGameMusic.play();
                gameStart = true;
            }
        }
        if (gameStart) {
            if (key == Input.KEY_Y) {
                CannonBall cbLeft = new CannonBall(this.spaceShip.getX() + 38, this.spaceShip.getY() + 108);
                CannonBall cbRight = new CannonBall(this.spaceShip.getX() + 124, this.spaceShip.getY() + 108);
                this.levelOneActors.add(cbLeft);
                this.levelOneActors.add(cbRight);
                for (Enemy enemy : enemies) {
                    enemy.addCollisionPartner(cbLeft);
                    enemy.addCollisionPartner(cbRight);
                }
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (!gameStart) {
            this.startScreen.update(gameContainer, delta);
        } else {
            this.spaceShip.update(gameContainer, delta);

            for (Actor actor : backgroundActors) {
                actor.update(gameContainer, delta);

            }

            if (hud.getHitNumber() < level2) {
                for (Actor actor : levelOneActors) {
                    actor.update(gameContainer, delta);
                }
            }
            if ((hud.getHitNumber() >= level2) && (hud.getHitNumber() < level3)) {
                for (Actor actor : levelTwoActors) {
                    actor.update(gameContainer, delta);
                }
            }
            if (hud.getHitNumber() >= level3) {
                for (Actor actor : levelThreeActors) {
                    actor.update(gameContainer, delta);
                }
            }
            for (int i = 0; i < enemies.size(); i++) {
                hud.setHits(enemies.get(i).getHitCounter());
                hud.setScore(enemies.get(i).getScore());
            }
        }
        hud.setLives(spaceShip.getLiveCounter() + levelOneEnemy.getLiveCounter() + levelTwoEnemy.getLiveCounter() +
                levelThreeEnemy.getLiveCounter());


    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if (!gameStart) {
            this.startScreen.render(graphics);
        } else {
            this.wallpaper.draw(0, 0);
            for (Actor actor : backgroundActors) {
                actor.render(graphics);

            }
            spaceShip.render(graphics);

            if (hud.getHitNumber() < level2) {
                for (Actor actor : levelOneActors) {
                    actor.render(graphics);
                }
            }
            if ((hud.getHitNumber() >= level2) && (hud.getHitNumber() < level3)) {
                for (Actor actor : levelOneActors) {
                    actor.render(graphics);
                }
            }
            if (hud.getHitNumber() >= level3) {
                for (Actor actor : levelOneActors) {
                    actor.render(graphics);
                }
            }
            hud.render(graphics);
        }

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Game("Corona Wars"));
            container.setDisplayMode(1200, 675, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}