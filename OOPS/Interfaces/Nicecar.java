package OOPS.Interfaces;

public class Nicecar {
    private Engine engine;
    private Media player = new CDPlayer();

    public Nicecar() {
        engine = new Powerengine();
    }

    public Nicecar(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void startMusic() {
        player.start();
    }

    public void stopmusic() {
        player.stop();
    }

    public void upgradeEngine() {
        this.engine = new Electricengine();
    }
}
