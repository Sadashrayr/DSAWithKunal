package OOPS.Interfaces;

public class Main {
    public static void main(String[] args) {
        // Engine car = new Car();
        // car.acc();
        // car.start();
        // car.stop();
        // Media carmedia = new Car();
        // carmedia.stop();
        Nicecar car = new Nicecar();
        car.start();
        car.startMusic();
        car.upgradeEngine();
        car.start();
    }

}
