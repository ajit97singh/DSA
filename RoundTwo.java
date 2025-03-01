package src.src;

import src.src.GreyOrenge.EnployeeInfo;

public class RoundTwo {
    // 1 microservice
    // one java library --> does db operations
    // writeDataAsync(Object data, func1 ) -- > calls the callback method to notify the client that data has been written
    //
    //

//    @Autowired
//    private EnployeeInfoService enployeeInfoService;


    private long invokeTime = -1;
    private boolean executionCompleted = false;


    public RoundTwo() {
    }

    public void func1() {
        System.out.println(System.currentTimeMillis() - invokeTime);
        executionCompleted = true;
    }


    public void writeToDb(Object row) {
        long start = System.currentTimeMillis();
        invokeTime = start;
//        writeDataAsync(row, func1);
        while(!executionCompleted) {
            // sleep

        }
    }




    // a b service , b is server , a is client
    //

    // a uses 3rd (b) party API ,
    // import jackson fasterxml
//    ObjectMapper op = new ObjectMapper();
    Object response = null;

//    EnployeeInfo info = op.covertValue(response, EnployeeInfo.class);

}
