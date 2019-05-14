package inthebloodhorse.designpatter.factory.simpleFactory;

import java.util.HashMap;

public interface CarTypeMap {

    HashMap<Integer, Class> carType = new HashMap<Integer, Class>() {
        {
            put(1, Audi.class);
            put(2, Bmw.class);
        }
    };

}
