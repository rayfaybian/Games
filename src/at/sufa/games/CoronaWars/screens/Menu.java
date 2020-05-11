package at.sufa.games.CoronaWars.screens;

import at.sufa.games.CoronaWars.actors.Actor;
import at.sufa.games.CoronaWars.actors.FlyingVirus;
import at.sufa.games.CoronaWars.actors.Virus;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Actor {
    private Music music;

    private Image backGround;
    private Image logo;
    private List<Virus> viruses;
    private List<FlyingVirus> flyingViruses;
    private AngelCodeFont font;


    public Menu() throws SlickException {
        this.music = new Music("src/at/sufa/games/CoronaWars/music/Anthem.ogg");

        Image tmp1 = new Image("src/at/sufa/games/CoronaWars/graphics/wallpaper/Earth.png");
        this.backGround = tmp1.getScaledCopy(1200, 765);

        Image tmp2 = new Image("src/at/sufa/games/CoronaWars/graphics/Corona Wars.png");
        this.logo = tmp2.getScaledCopy(1008, 426);

        this.font = new AngelCodeFont("testdata/distance.fnt", "testdata/distance.png");

        generateForegroundVisuals();

        generateBackgroundVisuals();


        music.play();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        for (Virus virus : viruses) {
            virus.update(gameContainer, delta);
        }
        for (FlyingVirus fV : flyingViruses) {
            fV.update(gameContainer, delta);
        }
    }

    @Override
    public void render(Graphics graphics) {
        this.backGround.draw(0, 0);
        this.logo.draw(96, 100);


        for (FlyingVirus fV : flyingViruses) {
            fV.render(graphics);
        }


        for (Virus virus : viruses) {
            virus.render(graphics);
        }

        font.drawString(380, 600, "Press Space to save the world");
    }

    private void generateBackgroundVisuals() throws SlickException {
        this.flyingViruses = new ArrayList<>();

        FlyingVirus fVirus1 = new FlyingVirus(15);
        this.flyingViruses.add(fVirus1);
        FlyingVirus fVirus2 = new FlyingVirus(20);
        this.flyingViruses.add(fVirus2);
        FlyingVirus fVirus3 = new FlyingVirus(25);
        this.flyingViruses.add(fVirus3);
        FlyingVirus fVirus4 = new FlyingVirus(30);
        this.flyingViruses.add(fVirus4);
        FlyingVirus fVirus5 = new FlyingVirus(35);
        this.flyingViruses.add(fVirus5);
        FlyingVirus fVirus6 = new FlyingVirus(40);
        this.flyingViruses.add(fVirus6);
        FlyingVirus fVirus7 = new FlyingVirus(45);
        this.flyingViruses.add(fVirus7);
        FlyingVirus fVirus8 = new FlyingVirus(50);
        this.flyingViruses.add(fVirus8);
        FlyingVirus fVirus9 = new FlyingVirus(55);
        this.flyingViruses.add(fVirus9);
        FlyingVirus fVirus10 = new FlyingVirus(60);
        this.flyingViruses.add(fVirus10);
    }

    private void generateForegroundVisuals() throws SlickException {
        this.viruses = new ArrayList<>();

        Virus virus1 = new Virus(400, -80, 400, 100);
        this.viruses.add(virus1);
        Virus virus2 = new Virus(280, 1050, -100, 60);
        this.viruses.add(virus2);
        Virus virus3 = new Virus(250, 175, -135, 80);
        this.viruses.add(virus3);
        Virus virus4 = new Virus(600, 870, 230, 120);
        this.viruses.add(virus4);
    }

    @Override
    public float getY() {
        return 0;
    }

    public void stopMusic() {
        music.stop();
    }
}
