package src.world;

/**
 * Created by Drareeg on 4/15/2016.
 */
public class Monkey {
    
    private int bananas = 0;
    
    public void giveBananas(int amount) {
        bananas+=amount;
    }


    public int getBananas() {
        return bananas;
    }
}
