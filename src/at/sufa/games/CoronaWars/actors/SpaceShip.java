package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip implements Actor {
    private Image rocketImage;
    private float x, y;
    private Shape collisionShapeVertical;
    private Shape collisionShapeHorizontal;
    private List<CollisionActor> collisionShapes;
    private int liveCounter;
    private Sound shipExplosion;
    private boolean isCrashed;

    public SpaceShip() throws SlickException {
        int width = 175;
        int height = 182;
        this.rocketImage = new Image("src/at/sufa/games/CoronaWars/graphics/Spaceship.png");
        this.x = 513;
        this.y = 480;
        this.collisionShapeVertical = new Rectangle(this.x, this.y, 50, 145);
        this.collisionShapeHorizontal = new Ellipse(this.x, this.y, 90, 30);
        this.collisionShapes = new ArrayList<>();
        this.liveCounter = 5;
        this.shipExplosion = new Sound("src/at/sufa/games/CoronaWars/Sounds/Ship Explosion.ogg");
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        int shipspeed = 5;

        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            if (this.y <= 530) {
                this.y += shipspeed;
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            if (this.y >= -50) {
                this.y -= shipspeed;
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            if (this.x >= -75) {
                this.x -= shipspeed;
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            if (this.x <= 1100) {
                this.x += shipspeed;
            }
        }
        this.collisionShapeVertical.setLocation(this.x + 62, this.y + 35);
        this.collisionShapeHorizontal.setLocation(this.x - 3, this.y + 112);

        detectCollision();
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x, this.y);
    }

    private void detectCollision() {
        for (CollisionActor collisionShape : collisionShapes) {
            if (this.collisionShapeHorizontal.intersects(collisionShape.getCollisionShape())
                    || this.collisionShapeVertical.intersects(collisionShape.getCollisionShape())) {
                System.out.println("Collision!");
                this.x = 513;
                this.y = 480;
                this.liveCounter--;
                shipExplosion.play();

            }
        }
    }

    public void addCollisionPartner(CollisionActor collisionShape) {
        this.collisionShapes.add(collisionShape);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getLiveCounter() {
        return liveCounter;
    }

    public void reset() {
        this.liveCounter = 5;
    }

}
