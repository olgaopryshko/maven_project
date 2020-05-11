package sportgames.base;

public interface IPlayable {

    void play();

    default void gameOver() {
        System.out.println("Game over");
    }
}