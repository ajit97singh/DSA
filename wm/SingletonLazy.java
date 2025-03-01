package src.src.wm;

public class SingletonLazy {

    /*
    This demonstrates singleton pattern using Double-Checked Locking  or "classic" singleton
    This is also a lazy initialization singleton
    Although this implementation solves multi-threading issues with lazy initialization and volatile and double-check
    locking, the volatile keyword is guaranteed to work only with JVM starting with version 1.5 or later.
    */

    private SingletonLazy(){}

    // when multiple threads use a same variable they cache it in their registers
    // volatile makes sure that the threads do not use cached value of this variable and refer to main memory instead
    // volatile forces value read/writes from main memory instead of caches
    private static volatile SingletonLazy INSTANCE;

    public SingletonLazy getInstance(){

        if (INSTANCE == null) {
            synchronized (SingletonLazy.class) {
                // if INSTANCE was not volatile this thread would refer to cached values of INSTANCE which will be null
                if (INSTANCE == null){
                    INSTANCE = new SingletonLazy();
                }
            }
        }
        return INSTANCE;
    }

}
