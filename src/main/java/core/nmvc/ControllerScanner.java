package core.nmvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.Controller;
import core.mvc.DispatcherServlet;
import core.mvc.ForwardController;
import core.mvc.RequestMapping;

public class ControllerScanner {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private Map<Class<?>, Object> classMap = new HashMap<>();

    void initMapping(Set<Class<?>> annotated) throws Exception {
        logger.info("Initialized Request Mapping!");
        for (Class<?> clazz : annotated) {
        	
        	classMap.put(clazz, clazz.newInstance());
        	
    		
//    		logger.debug("getName : " + anno.getName());	//core.nmvc.MyController
//    		logger.debug("getName : " + anno.);	//
    		
    		
//    		Class<MyController> clazz = MyController.class;
//    		logger.debug(clazz.getName());
//    		MyController controller = clazz.newInstance();
    		
    		
		}
        
    }

    public Class<?> findClass(String url) {
        return (Class<?>) classMap.get(url);
    }

//    void put(String url, Controller controller) {
//        mappings.put(url, controller);
//    }

}
