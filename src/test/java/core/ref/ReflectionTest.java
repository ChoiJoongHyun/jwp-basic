package core.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;
import next.model.User;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;
        logger.debug(clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
        	logger.debug(field.getName() + " , " + field.getType() + " , " + field.getModifiers());
        }
        
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
        	logger.debug("method.getName() : " + method.getName());
        }
        
        
    }
    
    @Test
    public void newInstanceWithConstructorArgs() throws Exception{
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());
        
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        
        for(Constructor<?> constructor : constructors) {
        	logger.debug(constructor.toGenericString());
        	logger.debug(constructor.toString());
        	User user = (User) constructor.newInstance("id","pwd","name","email");
        	
        	logger.debug(user.toString());
        }
        
    }
    
    @Test
    public void privateFieldAccess() throws Exception {
        Class<Student> clazz = Student.class;
        logger.debug(clazz.getName());
        
        Student student = new Student();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(student, "중현");
        logger.debug("name : {} " , student.getName());
        
        name = clazz.getDeclaredField("age");
        name.setAccessible(true);
        name.set(student, 20);
        logger.debug("name : {} " , student.getAge());
        
        
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
        	logger.debug(field.getName() + " , " + field.getType() + " , " + field.getModifiers());
        	
        	
        }
        
    }
}
