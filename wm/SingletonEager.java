package src.src.wm;

public class SingletonEager {


    // this is the easiest way to implement a singleton.
    // As soon as the class is loaded the instance is created

    private SingletonEager(){

    }

    private static final SingletonEager INSTANCE = new SingletonEager();

    public static SingletonEager getInstance(){
        return INSTANCE;
    }

}
