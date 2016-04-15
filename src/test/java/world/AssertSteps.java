package world;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import src.world.Monkey;
import src.world.WorldObject;

/**
 * Created by Drareeg on 4/15/2016.
 */
public class AssertSteps {

    public AssertSteps() {
        System.out.println();
    }

    @WorldObject
    public static Monkey monkey;

    @WorldObject("JAKOB")
    public static Monkey jakob;

    @WorldObject("JOS")
    public static Monkey jos;

    @Then("^He has (\\d+) bananas$")
    public void heHasBananas(int expectedAmount) throws Throwable {
        expectedBananas(expectedAmount, monkey);
    }

    private void expectedBananas(int expectedAmount, Monkey monkey) {
            String correctMessage = " expected: " + expectedAmount + ", actual:" + monkey.getBananas() + System.lineSeparator();
        if(expectedAmount == monkey.getBananas()){
            System.out.print(correctMessage);
        }else {
            System.out.println("assertion WRONG: " + correctMessage);
        }

    }

    @Then("^Jakob has (\\d+) bananas$")
    public void jakobHasBananas(int expectedAmount) throws Throwable {
        expectedBananas(expectedAmount, jakob);
    }

    @And("^Jos has (\\d+) bananas$")
    public void josHasBananas(int expectedAmount) throws Throwable {
        expectedBananas(expectedAmount, jos);
    }

}

