package pl.stefanski;

import java.util.Collections;
import java.util.Map;

public class Accounts {

    private static Map<String, String> users = Collections.singletonMap("admin", "admin");

    public static Map<String, String> getUsers() {
        return users;
    }
}
