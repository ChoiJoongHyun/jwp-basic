package core.ref;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit3TestRunner {
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
    @Test
    public void run() throws Exception {
        Class<Junit3Test> clazz = Junit3Test.class;
        
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
        	logger.debug("method : {}" ,method.getName());
        	
        	if(method.getName().startsWith("test")) {
        		method.invoke(clazz.newInstance());
        	}
        }        
    }
}
