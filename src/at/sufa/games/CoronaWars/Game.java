package at.sufa.games.CoronaWars;

import at.sufa.games.CoronaWars.actors.*;
import at.sufa.games.CoronaWars.screens.*;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends BasicGame {

    //Screens
    private Startscreen startscreen; //Screen that opens when program is started
    private Menu menu; //Main Menu
    private Hud hud; //Onscreen information during gameplay
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
    private Enemy enemy;

    private Image wallpaper;

    private boolean gameStart;
    private Music inGameMusic;
    private Sound laserSound;
    private Sound loser;
    private Sound winner;

    private long t;
    private long end;

    private int level;

    private boolean gameWon;
    private boolean gameLost;
    private boolean gameReset;
    private boolean tutorial;

    private long time;
    private AngelCodeFont font;

    public Game(String title) throws SlickException {
        super(title);

    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameStart = false;
        gameWon = false;
        gameLost = false;
        gameReset = false;
        tutorial = true;

        this.level = 1;

        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");

        this.startscreen = new Startscreen();
        this.menu = new Menu();

        inGameMusic = new Music("src/at/sufa/games/CoronaWars/music/Danger Zone.ogg");
        laserSound = new Sound("src/at/sufa/games/CoronaWars/Sounds/Laser.ogg");
        loser = new Sound("src/at/sufa/games/CoronaWars/Sounds/Loser.ogg");
        winner = new Sound("src/at/sufa/games/CoronaWars/Sounds/Yeah Baby.ogg");

        //initialises wallpaper and stars
        Image tmp = new Image("src/at/sufa/games/CoronaWars/graphics/wallpaper/Space.jpg");
        this.wallpaper = tmp.getScaledCopy(1200, 675);

        this.backgroundActors = new ArrayList<>();
        this.cannonBalls = new ArrayList<>();

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

        //initializes enemies for all levels
        this.levelOneEnemies = new ArrayList<>();
        this.levelTwoEnemies = new ArrayList<>();
        this.levelThreeEnemies = new ArrayList<>();
        this.level8Enemies = new ArrayList<>();

        this.enemies = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 5; i++) {

            this.enemy = new Enemy(100, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.levelOneEnemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);
        }

        for (int i = 0; i < 8; i++) {

            this.enemy = new Enemy(50, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.levelTwoEnemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);
        }

        for (int i = 0; i < 12; i++) {

            this.enemy = new Enemy(25, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.levelThreeEnemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);
        }
        for (int i = 0; i < 25; i++) {
            this.enemy = new Enemy(17, -(100 + r.nextInt(100)));
            this.enemies.add(enemy);
            this.level8Enemies.add(enemy);
            this.spaceShip.addCollisionPartner(enemy);

        }


        this.hud = new Hud();
        this.winscreen = new Winscreen();
        this.losescreen = new Losescreen();

        long t = System.currentTimeMillis();
        this.end = t + 12400;

    }


    @Override
    public void keyPressed(int key, char c) {


        if(tutorial){
        if (key == Input.KEY_S) {
            tutorial = false;
            inGameMusic.play();
            time = System.currentTimeMillis();}
        }

        if (key == Input.KEY_ESCAPE) {
            System.exit(0);
        }

        if((gameLost)||(gameWon)){
            if(key == Input.KEY_SPACE){
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
    }


    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if ((!gameWon) && (!gameLost)) {
            if (System.currentTimeMillis() < end) {
                startscreen.update(gameContainer, delta);
            } else if ((!gameStart) && (System.currentTimeMillis() > end)) {
                this.menu.update(gameContainer, delta);
            } else {
                gameReset = false;


                //levelcounter
                for (Enemy value : enemies) {
                    this.level = value.getLevel();
                }

                this.spaceShip.update(gameContainer, delta);


                for (Actor actor : backgroundActors) {
                    actor.update(gameContainer, delta);

                }
                for (CannonBall cannonball : cannonBalls) {
                    cannonball.update(gameContainer, delta);

                }
                if (!tutorial) {


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
                }

                for (Enemy value : enemies) {
                    hud.setHits(value.getHitCounter());
                    hud.setScore(value.getScore());
                    hud.setLevel(value.getLevel());
                }

                hud.setLives(spaceShip.getLiveCounter());

                if (hud.getRemainingLives() == 0) {
                    gameLost = true;

                }

            }
            winscreen.setScore(hud.getFinalScore());
        }
        if (gameWon) {
            gameStart = false;
            winscreen.update(gameContainer, delta);
            spaceShip.reset();

            if (!gameReset) {
                winner.play();
                for (Enemy value : enemies) {
                    value.reset();
                    value.setY();
                }
                gameReset = true;
            }
        }

        if (gameLost) {

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
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if ((!gameWon) && (!gameLost)) {
            if (System.currentTimeMillis() < end) {
                startscreen.render(graphics);
            } else if ((!gameStart) && (System.currentTimeMillis() > end)) {
                this.menu.render(graphics);
            } else if (gameStart) {
                this.wallpaper.draw(0, 0);
                for (Actor actor : backgroundActors) {
                    actor.render(graphics);

                }
                for (CannonBall cannonball : cannonBalls) {
                    cannonball.render(graphics);

                }
                spaceShip.render(graphics);
                if (tutorial) {
                    graphics.setColor(Color.black);
                    graphics.fillRect(450, 200, 300, 100);
                    graphics.setColor(Color.white);
                    graphics.drawString("Use arrowkeys to fly", 505, 220);
                    graphics.drawString("Press Y to shoot", 522, 240);
                    graphics.drawString("Press S when you're ready", 487, 260);
                }

                if (!tutorial) {
                    if (System.currentTimeMillis() <= (time + 3000)) {

                        font.drawString(460, 300, "Kill the Virus!");
                    }

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
                }

                if (!tutorial) {
                    hud.render(graphics);
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