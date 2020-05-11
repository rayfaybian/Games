package at.sufa.games.CoronaWars.screens;

import at.sufa.games.CoronaWars.actors.Actor;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Hud implements Actor {
    private int lives;
    private int hits;
    private int score;
    private int level;
    private AngelCodeFont font;

    public Hud() throws SlickException {
        this.level = 1;
        this.lives = 3;
        this.hits = 0;
        this.score = 0;
        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public void render(Graphics graphics) {
        font.drawString(10, 620, getScore());
        font.drawString(10, 580, getHits());
        font.drawString(10, 540, getLives());
        font.drawString(10, 500, getLevel());

    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLives() {
        return "Lives: " + lives;
    }

    public String getHits() {
        return "Hits: " + hits;
    }

    public String getScore() {
        return "Score: " + score;
    }

    public String getLevel() {
        return "Level: " + level;
    }

    public int getFinalScore() {
        return score;
    }

    public int getRemainingLives() {
        return lives;
    }

    @Override
    public float getY() {
        return 0;
    }
}
