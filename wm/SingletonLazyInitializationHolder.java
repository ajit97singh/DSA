package src.src.wm;

public class SingletonLazyInitializationHolder {

    private SingletonLazyInitializationHolder(){}

    private static class Holder{
        static SingletonLazyInitializationHolder INSTANCE = new SingletonLazyInitializationHolder();
    }

    public SingletonLazyInitializationHolder getInstance(){
        return Holder.INSTANCE;
    }

}