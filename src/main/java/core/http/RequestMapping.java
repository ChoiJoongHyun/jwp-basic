package core.http;

import java.util.HashMap;
import java.util.Map;

import next.controller.Controller;
import next.controller.ListUserController;
import next.controller.LogoutController;
import next.controller.ProfileController;

public class RequestMapping {
    private static Map<String, Controller> controllers = new HashMap<String, Controller>();

    static {
        controllers.put("/users", new ListUserController());
        controllers.put("/users/logout", new LogoutController());
        controllers.put("/users/profile", new ProfileController());
    }

    public static Controller getController(String requestUrl) {
        return controllers.get(requestUrl);
    }
}