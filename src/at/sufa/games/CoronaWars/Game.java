package at.sufa.games.CoronaWars;

import at.sufa.games.CoronaWars.actors.*;
import at.sufa.games.CoronaWars.screens.*;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends BasicGame {

    //Screens
    private Startscreen startscreen;
    private Menu menu;
    private Hud hud;
    private Winscreen winscreen;
    private Losescreen losescreen;

    //Lists
    private List<Actor> backgroundActors; //stars flying through space
    private List<Enemy> enemies;
    private List<CannonBall> cannonBalls;
    private List<Enemy> levelOneEnemies;
    private List<Enemy> levelTwoEnemies;
    private List<Enemy> levelThreeEnemies;
    private List<Enemy> level8Enemies;

    //Actors
    private SpaceShip spaceShip;

    //Music & Sounds
    private Music inGameMusic;
    private Sound laserSound;
    private Sound loser;
    private Sound winner;


    //Booleans
    private boolean gameStart;
    private boolean gameWon;
    private boolean gameLost;
    private boolean gameReset;
    private boolean tutorial;

    private AngelCodeFont font;
    private Image wallpaper;

    private int level;

    private long time;
    private long end;


    public Game(String title){
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        initBooleans();
        initLists();
        initGraphics();
        initSounds();
        initScreens();

        this.spaceShip = new SpaceShip();

        initEnemies();

        this.level = 1;

        long t = System.currentTimeMillis();
        this.end = t + 13940;

    }//main init method
    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if ((!gameWon) && (!gameLost)) {

            if (System.currentTimeMillis() < end) {

                startscreen.update(gameContainer, delta);

            } else if ((!gameStart) && (System.currentTimeMillis() > end)) {
                this.menu.update(gameContainer, delta);
            } else {
                gameReset = false;

                getLevel();

                for (Actor actor : backgroundActors) {
                    actor.update(gameContainer, delta);
                }

                this.spaceShip.update(gameContainer, delta);

                for (CannonBall cannonball : cannonBalls) {
                    cannonball.update(gameContainer, delta);

                }
                if (!tutorial) {
                    updateEnemies(gameContainer, delta);
                }

                getValues();
            }

        }
        if (gameWon) updateGameWin(gameContainer, delta);

        if (gameLost) updateGameLose(gameContainer, delta);
    }//main update method
    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if ((!gameWon) && (!gameLost)) {
            if (System.currentTimeMillis() < end) {
                startscreen.render(graphics);
            } else if ((!gameStart) && (System.currentTimeMillis() > end)) {
                this.menu.render(graphics);
            } else if (gameStart) {

                renderBackdrop(graphics);
                renderCannonballs(graphics);
                spaceShip.render(graphics);

                if (tutorial) {
                    renderTutorialGraphics(graphics);
                }

                if (!tutorial) {
                    if (System.currentTimeMillis() <= (time + 3000)) {

                        font.drawString(460, 300, "Kill the Virus!");
                    }

                    hud.render(graphics);
                    renderLevelEnemies(graphics);
                }
            }
        }
        if (gameWon) {
            winscreen.render(graphics);
            inGameMusic.stop();
        }

        if (gameLost) {
            losescreen.render(graphics);
            inGameMusic.stop();
        }
    }//main render method

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Game("Corona Wars"));
            container.setDisplayMode(1200, 675, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }//main method

    @Override
    public void keyPressed(int key, char c) {
        if ((gameStart) && (tutorial)) {
            if (key == Input.KEY_S) {
                tutorial = false;
                inGameMusic.play();
                time = System.currentTimeMillis();
            }
        }

        if (key == Input.KEY_ESCAPE) {
            System.exit(0);
        }

        if ((gameLost) || (gameWon)) {
            if (key == Input.KEY_SPACE) {
                inGameMusic.play();
            }
        }

        if (!gameStart && (System.currentTimeMillis() > end)) {
            if (key == Input.KEY_SPACE) {
                menu.stopMusic();
                gameStart = true;
                gameLost = false;
                gameWon = false;
            }
        }

        if (gameStart) {
            if (key == Input.KEY_Y) {
                laserSound.play();
                CannonBall cbLeft = new CannonBall(this.spaceShip.getX() + 38, this.spaceShip.getY() + 108);
                this.cannonBalls.add(cbLeft);
                CannonBall cbRight = new CannonBall(this.spaceShip.getX() + 124, this.spaceShip.getY() + 108);
                this.cannonBalls.add(cbRight);
                for (Enemy enemy : enemies) {
                    enemy.addCollisionPartner(cbLeft);
                    enemy.addCollisionPartner(cbRight);
                }
            }
        }
    }//key inputs


    //init methods:

    private void initScreens() throws SlickException {
        this.startscreen = new Startscreen();
        this.menu = new Menu();
        this.winscreen = new Winscreen();
        this.losescreen = new Losescreen();
        this.hud = new Hud();
    }//initialises screens

    private void initEnemies() throws SlickException {
        Random r = new Random();

        Enemy enemy;
        for (int i = 0; i < 5; i++) {

            enemy = new Enemy(100, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.levelOneEnemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);
        }

        for (int i = 0; i < 8; i++) {

            enemy = new Enemy(50, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.levelTwoEnemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);
        }

        for (int i = 0; i < 12; i++) {

            enemy = new Enemy(25, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.levelThreeEnemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);
        }

        for (int i = 0; i < 25; i++) {
            enemy = new Enemy(17, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.level8Enemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);
        }
    }//initialises enemies

    private void initLists() {
        this.backgroundActors = new ArrayList<>();
        this.cannonBalls = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.levelOneEnemies = new ArrayList<>();
        this.levelTwoEnemies = new ArrayList<>();
        this.levelThreeEnemies = new ArrayList<>();
        this.level8Enemies = new ArrayList<>();
    }//initialises various lists

    private void initBooleans() {
        gameStart = false;
        gameWon = false;
        gameLost = false;
        gameReset = false;
        tutorial = true;
    }//initialises various booleans

    private void initGraphics() throws SlickException {
        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");

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
    }//initialises images, fonts ang graphics

    private void initSounds() throws SlickException {
        inGameMusic = new Music("src/at/sufa/games/CoronaWars/music/Danger Zone.ogg");
        laserSound = new Sound("src/at/sufa/games/CoronaWars/Sounds/Laser.ogg");
        loser = new Sound("src/at/sufa/games/CoronaWars/Sounds/Loser.ogg");
        winner = new Sound("src/at/sufa/games/CoronaWars/Sounds/Yeah Baby.ogg");
    }//initialises music & sounds


    //update methods:

    private void getValues() {
        for (Enemy value : enemies) {
            hud.setHits(value.getHitCounter());
            hud.setScore(value.getScore());
            hud.setLevel(value.getLevel());
        }
        hud.setLives(spaceShip.getLiveCounter());

        if (hud.getRemainingLives() < 1) {
            gameLost = true;
        }
    }//gets values for various counters

    private void updateEnemies(GameContainer gameContainer, int delta) {
        switch (level) {

            case 1:
                for (Actor actor : levelOneEnemies) {
                    actor.update(gameContainer, delta);
                }
                break;

            case 2:
                for (Enemy levelOneEnemy : levelOneEnemies) {
                    levelOneEnemy.setY();
                }
                for (Actor actor : levelTwoEnemies) {
                    actor.update(gameContainer, delta);
                }
                break;

            case 3:
                for (Enemy levelTwoEnemy : levelTwoEnemies) {
                    levelTwoEnemy.setY();
                }

                for (Actor actor : levelThreeEnemies) {
                    actor.update(gameContainer, delta);
                }
                break;
            case 4:
                for (Actor actor : levelOneEnemies) {
                    actor.update(gameContainer, delta);
                }

                for (Enemy levelThreeEnemy : levelThreeEnemies) {
                    levelThreeEnemy.setY();
                }


                for (Actor actor : levelTwoEnemies) {
                    actor.update(gameContainer, delta);
                }
                break;
            case 5:
                for (Enemy levelTwoEnemy : levelTwoEnemies) {
                    levelTwoEnemy.setY();
                }
                for (Actor actor : levelOneEnemies) {
                    actor.update(gameContainer, delta);
                }
                for (Actor actor : levelThreeEnemies) {
                    actor.update(gameContainer, delta);
                }
                break;
            case 6:
                for (Enemy levelOneEnemy : levelOneEnemies) {
                    levelOneEnemy.setY();
                }
                for (Actor actor : levelTwoEnemies) {
                    actor.update(gameContainer, delta);
                }
                for (Actor actor : levelThreeEnemies) {
                    actor.update(gameContainer, delta);
                }
                break;
            case 7:
                for (Actor actor : levelOneEnemies) {
                    actor.update(gameContainer, delta);
                }
                for (Actor actor : levelTwoEnemies) {
                    actor.update(gameContainer, delta);
                }
                for (Actor actor : levelThreeEnemies) {
                    actor.update(gameContainer, delta);
                }
                break;
            case 8:
                for (Enemy levelOneEnemy : levelOneEnemies) {
                    levelOneEnemy.setY();
                }
                for (Enemy levelTwoEnemy : levelTwoEnemies) {
                    levelTwoEnemy.setY();
                }
                for (Enemy levelThreeEnemy : levelThreeEnemies) {
                    levelThreeEnemy.setY();
                }
                for (Actor actor : level8Enemies) {
                    actor.update(gameContainer, delta);
                }
                break;
            case 9:
                gameWon = true;
                break;
        }
    }//updates enemies depending on current level

    private void getLevel() {
        for (Enemy value : enemies) {
            this.level = value.getLevel();
        }
    }//checks and updates current level

    private void updateGameLose(GameContainer gameContainer, int delta) {
        gameStart = false;
        losescreen.update(gameContainer, delta);
        spaceShip.reset();

        if (!gameReset) {
            loser.play();
            for (Enemy value : enemies) {
                value.reset();
                value.setY();
            }
            gameReset = true;
        }
    }//reset method for when game is lost

    private void updateGameWin(GameContainer gameContainer, int delta) {
        winscreen.setScore(hud.getFinalScore());
        winscreen.update(gameContainer, delta);
        spaceShip.reset();

        gameStart = false;

        if (!gameReset) {
            winner.play();
            for (Enemy value : enemies) {
                value.reset();
                value.setY();
            }
            gameReset = true;
        }
    }//reset method for when game is won


    //render methods:

    private void renderLevelEnemies(Graphics graphics) {

        switch (level) {
            case 1:
                for (Actor actor : levelOneEnemies) {
                    actor.render(graphics);
                }
                break;

            case 2:
                for (Actor actor : levelTwoEnemies) {
                    actor.render(graphics);
                }
                break;

            case 3:
                for (Actor actor : levelThreeEnemies) {
                    actor.render(graphics);
                }
                break;

            case 4:
                for (Actor actor : levelOneEnemies) {
                    actor.render(graphics);
                }
                for (Actor actor : levelTwoEnemies) {
                    actor.render(graphics);
                }
                break;

            case 5:
                for (Actor actor : levelOneEnemies) {
                    actor.render(graphics);
                }
                for (Actor actor : levelThreeEnemies) {
                    actor.render(graphics);
                }
                break;

            case 6:
                for (Actor actor : levelTwoEnemies) {
                    actor.render(graphics);
                }
                for (Actor actor : levelThreeEnemies) {
                    actor.render(graphics);
                }
                break;

            case 7:
                for (Actor actor : levelOneEnemies) {
                    actor.render(graphics);
                }
                for (Actor actor : levelTwoEnemies) {
                    actor.render(graphics);
                }
                for (Actor actor : levelThreeEnemies) {
                    actor.render(graphics);
                }
                break;

            case 8:
                for (Actor actor : level8Enemies) {
                    actor.render(graphics);
                }
                break;
        }
    }//renders different enemies depending on current level

    private void renderTutorialGraphics(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(450, 200, 300, 100);
        graphics.setColor(Color.white);
        graphics.drawString("Use arrowkeys to fly", 505, 220);
        graphics.drawString("Press Y to shoot", 522, 240);
        graphics.drawString("Press S when you're ready", 487, 260);
    }//onscreen instructions during tutorial phase

    private void renderCannonballs(Graphics graphics) {
        for (CannonBall cannonball : cannonBalls) {
            cannonball.render(graphics);

        }
    }//renders fired cannonballs

    private void renderBackdrop(Graphics graphics) {
        this.wallpaper.draw(0, 0);

        for (Actor actor : backgroundActors) {
            actor.render(graphics);

        }
    }//renders background visuals

}