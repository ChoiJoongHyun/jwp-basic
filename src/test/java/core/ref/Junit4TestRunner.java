package core.ref;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit4TestRunner {
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
    @Test
    public void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;
        
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
        	logger.debug("method : {}" ,method.isAnnotationPresent(MyTest.class));
        	if(method.isAnnotationPresent(MyTest.class)) {
        		method.invoke(clazz.newInstance());
        	}
        }

    }
}
