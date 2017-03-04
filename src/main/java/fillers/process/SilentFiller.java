package fillers.process;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

/**
 * Created by r.isin on 21.02.2017.
 *
 * Wrapper for Filler class, with wrapped exceptions
 */
public class SilentFiller<T>{
    private Filler<T> base;

    public static <T> SilentFiller<T> of(Class<T> type){
        return new SilentFiller<T>(type);
    }

    private SilentFiller(Class<T> item) {
        base = Filler.of(item);
    }

    /**
     * wrapper for single with default exception handling
     * @return Single filled object of Class<T>
     */
    public T single() {
        List<T> items = items(1);
        return items.size() == 0 ? null : items.get(0);
    }


    /**
     *
     * @param count single of filled objects
     * @return List<Class<T>> with count of elements
     */
    public List<T> items(int count) {
        try {
            return base.items(count);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
