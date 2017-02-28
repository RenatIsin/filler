package fillers.process;

import annotations.Fill;
import fillers.BaseFiller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by r.isin on 21.02.2017.
 *
 * Class for annotation process
 */
public class Filler<T>{
    private Class<T> item;

    public Filler(Class<T> item) {
        this.item = item;
    }

    /**
     *
     * @return Single filled object of Class<T>
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public T getInstance() throws IllegalAccessException, InstantiationException {
        return getInstance(1).get(0);
    }

    /**
     *
     * @param count items of filled objects
     * @return List<Class<T>> with count of elements
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<T> getInstance(int count) throws IllegalAccessException, InstantiationException {
        final List<T> ret = new ArrayList<T>(count);
        for (int i = 0; i < count; i++) {
            int index = i;
            ret.add(index, (T)item.newInstance());
            Field[] fields = ret.get(i).getClass().getDeclaredFields();
            Arrays.stream(fields).filter((field -> field.isAnnotationPresent(Fill.class)))
                    .forEach(field -> {
                        field.setAccessible(true);
                        setValue(ret.get(index), field);
                    });
        }
        return ret;
    }

    private void setValue(Object instance, Field field) {
        try {
            Fill item = field.getAnnotation(Fill.class);
            Class<? extends BaseFiller> c = item.filler();
            Method m = c.getMethod(item.method());
            field.set(instance, m.invoke(c.newInstance()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wrapper for getInstance with default exception handling
     * @return Single filled object of Class<T>
     */
    public T single() {
        return items(1).get(0);
    }


    /**
     *
     * @param count
     * @return List<Class<T>> with count of elements
     */
    public List<T> items(int count) {
        try {
            return getInstance(count);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


}
