package world;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.stereotype.Component;
import src.world.Monkey;
import src.world.WorldObject;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Drareeg on 4/15/2016.
 */
public class MonkeySteps {

    @WorldObject(value = "MONKEY")
    public static Monkey monkey;


    public MonkeySteps() throws IOException, ClassNotFoundException {

    }

    @Given("^We have a monkey$")
    public void weHaveAMonkey() throws Throwable {
    }

    @When("^We give him (\\d+) bananas$")
    public void weGiveHimBananas(int arg0) throws Throwable {
        monkey.giveBananas(arg0);
    }
}
