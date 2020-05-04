package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy implements CollisionActor {
    private Image enemy;
    private float x, y;
    private float speed;
    private int diameter;
    private Shape collisionShape;
    Random random = new Random();
    private List<CollisionActor> collisionShapes;
    private int hitCounter;
    private int score;
    private int liveCounter;

    public Enemy(int diameter) throws SlickException {
        this.diameter = diameter;
        this.x = (float) random.nextInt(1114);
        this.y = - diameter; //set to -110
        this.speed = (float)diameter/4;
        Image tmp = new Image("src/at/sufa/games/CoronaWars/graphics/Corona.png");
        this.enemy = tmp.getScaledCopy(this.diameter, this.diameter);
        this.collisionShape = new Circle(this.x,this.y, (float)(this.diameter-5)/2);
        this.collisionShapes = new ArrayList<CollisionActor>();
        this.hitCounter = 0;
        this.score = 0;
        this.liveCounter = 0;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(this.y >= 675){
            this.y = -10 -diameter;
            this.liveCounter --;
        }
        this.y += (float) delta / (this.speed);
        this.collisionShape.setLocation(this.x + 2, this.y + 3);

        for (CollisionActor collisionShape : collisionShapes) {
            if (this.collisionShape.intersects(collisionShape.getCollisionShape())) {
                countHit();
                countScore();
                System.out.println("Hit!" + getHitCounter());
                this.y = -diameter;
                this.x = random.nextInt(1114);


            }
        }
    }

    public void addCollisionPartner(CannonBall cannonBall) {
        this.collisionShapes.add(cannonBall);
    }

    @Override
    public void render(Graphics graphics) {
        this.enemy.draw(this.x, this.y);
        //graphics.draw(collisionShape);
        graphics.setColor(Color.black);
        graphics.fillRect(1000,575,200,100);
        graphics.setColor(Color.white);
        graphics.drawString("hits: " + hitCounter,1020,600);
    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public int getHitCounter() {
        return hitCounter;
    }

    public int getScore() {
        return score;
    }

    public void countHit(){
        this.hitCounter += 1;
    }

    public void countScore(){
        this.score = score + random.nextInt(100);
    }

    public int getLiveCounter(){
        return liveCounter;
    }

}
