package src.world;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Drareeg on 4/15/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface WorldObject {
    String DEFAULTVALUE = "verysecretkey";

    String value() default DEFAULTVALUE;
}
