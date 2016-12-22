package core.http;

import java.util.HashMap;
import java.util.Map;

import next.controller.Controller;
import next.controller.CreateUserController;
import next.controller.ForwardController;
import next.controller.HomeController;
import next.controller.ListUserController;
import next.controller.LoginController;
import next.controller.LogoutController;
import next.controller.ProfileController;

public class RequestMapping {
    private static Map<String, Controller> controllers = new HashMap<String, Controller>();

    static {
        controllers.put("/users", new ListUserController());
        controllers.put("/users/logout", new LogoutController());
        controllers.put("/users/profile", new ProfileController());
        controllers.put("/", new HomeController());
        controllers.put("/users/create", new CreateUserController());
        controllers.put("/users/login", new LoginController());
        
        controllers.put("/users/form", new ForwardController("/users/form.jsp"));
        
        controllers.put("/users/loginForm", new ForwardController("/user/login.jsp"));
//        controllers.put("/", new HomeController());
//        controllers.put("/", new HomeController());
    }

    public static Controller getController(String requestUrl) {
        return controllers.get(requestUrl);
    }
}