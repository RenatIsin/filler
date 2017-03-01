package fillers.process;

import annotations.Fill;
import fillers.BaseFiller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public T getInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return getInstance(1).get(0);
    }

    /**
     *
     * @param count items of filled objects
     * @return List<Class<T>> with count of elements
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<T> getInstance(int count) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        final List<T> ret = new ArrayList<T>(count);
        Object instance;
        for (int i = 0; i < count; i++) {
            instance = item.newInstance();
            List<Field> fields = Arrays.asList(instance.getClass().getDeclaredFields());
            fields = fields.stream().filter((field -> field.isAnnotationPresent(Fill.class))).collect(Collectors.toList());
            for(Field field : fields){
                field.setAccessible(true);
                setValue(instance, field);
            }
            ret.add((T) instance);
        }
        return ret;
    }

    private void setValue(Object instance, Field field) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Fill item = field.getAnnotation(Fill.class);
        Class<? extends BaseFiller> c = item.filler();
        Method m = Arrays.stream(c.getMethods()).filter((method) -> (
                method.getName().equals(item.method()) && method.getParameterCount() == item.params().length
                )).findFirst()
                .orElseThrow(() ->
                        new NoSuchMethodException(
                                c.getName() + "." + item.method() + "("
                                    + Arrays.stream(item.params()).map(x -> "\"" + x + "\"")
                                        .collect(Collectors.joining(", ")) + ")"
                        )
                );
        if(item.params().length == 0) {
            field.set(instance, m.invoke(c.newInstance()));
        } else {
            field.set(instance, m.invoke(c.newInstance(), item.params()));
        }
    }

    /**
     * wrapper for getInstance with default exception handling
     * @return Single filled object of Class<T>
     */
    public T single() {
        List<T> items = items(1);
        return items.size() == 0 ? null : items.get(0);
    }


    /**
     *
     * @param count
     * @return List<Class<T>> with count of elements
     */
    public List<T> items(int count) {
        try {
            return getInstance(count);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


}
