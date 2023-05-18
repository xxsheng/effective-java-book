package create$update;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StaticFactory {

    public interface Service {

    }

    public interface Provide {
        Service newService();
    }

    public static class Services {
        private static final Map<String, Provide> provides = new ConcurrentHashMap<>();

        private final static String DEFAULT_PROVIDE_NAME = "<def>";

        public static void registerDefaultProvide(Provide p) {
            provides.put(DEFAULT_PROVIDE_NAME, p);
        }

        public static void registerProvide(String name, Provide p) {
            provides.put(name, p);
        }

        public Service newInstance() {
            return provides.get(DEFAULT_PROVIDE_NAME).newService();
        }

        public Service newInstance(String name) {
            return provides.get(name).newService();
        }


    }
}
