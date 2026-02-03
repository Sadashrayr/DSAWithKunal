package OOPS.Interfaces;

public class Powerengine implements Engine {
    @Override
    public void start() {
        System.out.println("The power engine is starting");
    }

    @Override
    public void stop() {
        System.out.println("The power engine is stopped");
    }

    @Override
    public void acc() {
        System.out.println("The power engine is accelerating");
    }
}
