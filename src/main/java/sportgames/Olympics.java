package sportgames;

import sportgames.base.IPlayable;

public class Olympics {
    private IPlayable game;

    public IPlayable getGame() {
        return game;
    }

    public void setGame(IPlayable game) {
        this.game = game;
    }


    public void playGame() {
        game.play();
    }
}
