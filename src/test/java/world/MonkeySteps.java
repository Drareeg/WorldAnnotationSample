package world;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import src.world.Monkey;
import src.world.WorldObject;

import java.io.IOException;

/**
 * Created by Drareeg on 4/15/2016.
 */
public class MonkeySteps {

    @WorldObject
    public static Monkey monkey;

    @WorldObject("JAKOB")
    public static Monkey jakob;

    @WorldObject("JOS")
    public static Monkey jos;

    public MonkeySteps() throws IOException, ClassNotFoundException {

    }

    @When("^We give a monkey (\\d+) bananas$")
    public void weGiveHimBananas(int amount) throws Throwable {
        monkey.giveBananas(amount);
    }

    @And("^We give monkey Jakob (\\d+) bananas$")
    public void weGiveMonkeyJakobBananas(int amount) throws Throwable {
        jakob.giveBananas(amount);
    }

    @And("^We give monkey Jos (\\d+) bananas$")
    public void weGiveMonkeyJosBananas(int amount) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        jos.giveBananas(amount);
    }
}
