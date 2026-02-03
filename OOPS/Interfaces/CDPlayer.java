package OOPS.Interfaces;

public class CDPlayer implements Media {

    @Override
    public void start(){
        System.out.println("Music is starting");
    }
    @Override
    public void stop(){
        System.out.println("Music is stoped");
    }
}
