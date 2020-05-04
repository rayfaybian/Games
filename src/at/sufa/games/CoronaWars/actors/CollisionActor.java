package at.sufa.games.CoronaWars.actors;

import org.newdawn.slick.geom.Shape;

public interface CollisionActor extends Actor{

    public Shape getCollisionShape();
}
