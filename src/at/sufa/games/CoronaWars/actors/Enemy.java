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
    private HitCounter hitCounter;


    public Enemy(int diameter, float y) throws SlickException {
        this.hitCounter = new HitCounter();
        this.diameter = diameter;
        this.x = (float) random.nextInt(1114);
        this.y = y;
        this.speed = (float) diameter / 4;
        Image tmp = new Image("src/at/sufa/games/CoronaWars/graphics/Corona.png");
        this.enemy = tmp.getScaledCopy(this.diameter, this.diameter);
        this.collisionShape = new Circle(this.x, this.y, (float) (this.diameter - 5) / 2);
        this.collisionShapes = new ArrayList<>();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (this.y >= 675) {
            this.y = -40 - diameter;
            this.x = (float) random.nextInt(1114);
            hitCounter.decreaseScore();
        }
        this.y += (float) delta / (this.speed);
        this.collisionShape.setLocation(this.x + 2, this.y + 3);

        for (CollisionActor projectile : collisionShapes) {
            if (this.collisionShape.intersects(projectile.getCollisionShape())) {
                HitCounter.increment();
                System.out.println("Hit!" + hitCounter.getHits());
                this.y = -diameter;
                this.x = random.nextInt(1200 - diameter);

            }
        }
    }

    public void addCollisionPartner(CollisionActor cannonBall) {
        this.collisionShapes.add(cannonBall);
    }

    @Override
    public void render(Graphics graphics) {
        this.enemy.draw(this.x, this.y);
        //graphics.draw(collisionShape);

    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public int getHitCounter() {
        return hitCounter.getHits();
    }

    public int getLevel() {
        return hitCounter.getLevel();
    }

    public void reset() {
        hitCounter.reset();

    }

    public int getScore() {
        return hitCounter.getScore();
    }

    public float getY() {
        return y;
    }

    public void setY() {
        this.y = -(float) random.nextInt(400);
        this.collisionShape.setLocation(this.x,this.y);
    }
}
