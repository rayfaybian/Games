package at.sufa.games.CoronaWars.actors;

import at.sufa.games.CoronaWars.movements.MoveStrategy;
import org.newdawn.slick.GameContainer;

public abstract class AbstractMovableActor implements CollisionActor {
    protected MoveStrategy moveStrategy;

    public AbstractMovableActor(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.moveStrategy.update(delta);
    }
}
