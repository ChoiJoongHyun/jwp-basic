package core.nmvc;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.*;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import core.annotation.Controller;
import core.annotation.RequestMethod;
import core.mvc.RequestMapping;
import core.ref.MyTest;
import core.ref.ReflectionTest;
import next.model.User;
public class AnnotationHandlerMapping {
	
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
	
    private Object[] basePackage;

    private Map<HandlerKey, HandlerExecution> handlerExecutions = Maps.newHashMap();

    private ControllerScanner cs;
    
    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }

    public void initialize() throws Exception {    	
    	logger.debug("initialize start");
    	Reflections reflections = new Reflections(basePackage);
    	
    	Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Controller.class);
    	cs = new ControllerScanner();
    	cs.initMapping(annotated);
    	
    }

//    private HandlerKey createHandlerKey(RequestMapping rm){ 
//    	return new HandlerKey(rm.value(),rm.method()); 
//    }
    public HandlerExecution getHandler(HttpServletRequest request) {
    	logger.debug("HandlerExecution start");
        String requestUri = request.getRequestURI();
        logger.debug("HandlerExecution requestUri : " + requestUri);
        RequestMethod rm = RequestMethod.valueOf(request.getMethod().toUpperCase());
        return handlerExecutions.get(new HandlerKey(requestUri, rm));
    }
}
