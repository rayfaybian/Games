package at.sufa.games.CoronaWars.actors;

import java.util.Random;

public class HitCounter {

    private static int hits;
    private static int hitsPerLevel;
    private static int level = 1;
    private static int score = 0;

    public static void increase() {
        Random r = new Random();
        hits++;
        hitsPerLevel++;
        if (hitsPerLevel == 50) { //<-- determines how many enemies you have to hit until you reach the next level
            hitsPerLevel = 0;
            level++;
        }
        score = score + r.nextInt(100);//points for each hit are randomly generated
    }

    public void decreaseScore() {
        score = score - 50;
        if (score <= 0) {
            score = 0;
        }
    }

    public int getHits() {
        return hits;
    }

    public int getLevel() {
        return level;
    }

    public void reset() {
        hits = 0;
        hitsPerLevel = 0;
        level = 1;
        score = 0;
    }

    public int getScore() {
        return score;
    }


}
