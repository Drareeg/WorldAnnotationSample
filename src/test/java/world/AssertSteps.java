package world;

import cucumber.api.java.en.Then;
import src.world.Monkey;
import src.world.WorldObject;

/**
 * Created by Drareeg on 4/15/2016.
 */
public class AssertSteps {

    @WorldObject(value = "MONKEY")
    public static Monkey monkey;

    @Then("^He has (\\d+) bananas$")
    public void heHasBananas(int expectedAmount) throws Throwable {
        System.out.println(" expected: " + expectedAmount + ", actual:" + monkey.getBananas()+"\n");
    }
}
