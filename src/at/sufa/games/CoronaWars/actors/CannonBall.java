package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;


public class CannonBall implements CollisionActor {
    private float x, y;
    private Shape collisionShape;


    public CannonBall(float x, float y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Circle(this.x, this.y, 5);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        if (this.y <= 5) {
            this.x = -100;
            this.y = -200;
            this.collisionShape.setLocation(this.x, this.y);
        } else {
            this.y -= 5;
            this.collisionShape.setLocation(this.x, this.y);
        }
    }

    @Override
    public void render(Graphics graphics) {
        if (this.y > 0) {
            graphics.fillOval(this.x, this.y, 10, 10);
            graphics.draw(collisionShape);
        }
    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }
}
