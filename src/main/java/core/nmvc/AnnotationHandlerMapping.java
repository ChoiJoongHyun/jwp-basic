package core.nmvc;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import core.annotation.RequestMethod;
import core.ref.ReflectionTest;
public class AnnotationHandlerMapping {
	
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
	
    private Object[] basePackage;

    private Map<HandlerKey, HandlerExecution> handlerExecutions = Maps.newHashMap();

    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }

    public void initialize() {

//    	logger.debug("initialize start");
//    	
//    	Reflections reflections = new Reflections("my.project");
//    	Set<Class<?>>annotated=reflections.getTypesAnnotatedWith(Controller.class);
////    	Class<Junit4Test> clazz = Junit4Test.class;
////    	Method[] methods = clazz.getDeclaredMethods();
////        for(Method method : methods) {
////        	logger.debug("method : {}" ,method.isAnnotationPresent(MyTest.class));
////        	
////        }
    	
    	
    }

    public HandlerExecution getHandler(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        RequestMethod rm = RequestMethod.valueOf(request.getMethod().toUpperCase());
        return handlerExecutions.get(new HandlerKey(requestUri, rm));
    }
}
