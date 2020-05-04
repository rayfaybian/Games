package at.sufa.games.CoronaWars.movements;

public interface MoveStrategy {
    public float getX();
    public float getY();
    public void update(int delta);
}
