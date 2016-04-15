package world;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Drareeg on 4/15/2016.
 */
@Component
public class World {


    private HashMap<Object, Object> items = new HashMap();

    public Object getOrNew(Object key, Class clazz){
        if(!items.containsKey(key)){
            try {
                items.put(key, clazz.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return items.get(key);

    }

}
