public class waterBottles {

    //solution1

    public int numWaterBottles(int numBottles, int numExchange) {

        int emptyBottles=0;
        int count=0;
        count=numBottles;
        int getBottles=numBottles/numExchange;
        emptyBottles=numBottles-(getBottles*numExchange);
        count+=getBottles;
        getBottles += emptyBottles;
        numBottles=getBottles;
        while (getBottles>=numExchange){
            getBottles=getBottles/numExchange;
            emptyBottles=numBottles-(getBottles*numExchange);
            count+=getBottles;
            getBottles += emptyBottles;
            numBottles=getBottles;
        }
        return count;
    }

    //solution2
    public int numWaterBottles2(int numBottles, int numExchange) {
        int count = numBottles;
        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            count += newBottles;
            numBottles = newBottles + (numBottles % numExchange);
        }
        return count;
    }
}
