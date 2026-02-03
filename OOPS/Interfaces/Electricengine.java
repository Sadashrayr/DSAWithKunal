package OOPS.Interfaces;

public class Electricengine implements Engine {
    @Override
    public void start(){
        System.out.println("Electric engine starts");
    }
    @Override
    public void stop(){
        System.out.println("electric engine stops");
    }
    @Override
    public void acc(){
        System.out.println("electric engine accelerate");
    }
    
}
