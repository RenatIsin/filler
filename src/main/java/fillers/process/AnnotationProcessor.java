package fillers.process;

import annotations.Fill;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * Created by r.isin on 21.02.2017.
 */
public class AnnotationProcessor<T>{
    private Class<T> item;

    public AnnotationProcessor(Class<T> item) {
        this.item = item;
    }

    public T getInstance() throws IllegalAccessException, InstantiationException {
        Object instance = item.newInstance();
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Fill.class)) {
                Fill item = field.getAnnotation(Fill.class);
                field.setAccessible(true); // should work on private fields
                try {
                    Class c = item.filler();
                    Method m = c.getMethod(item.method());
                    field.set(instance, m.invoke(c.newInstance()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return (T)instance;
    }


}
