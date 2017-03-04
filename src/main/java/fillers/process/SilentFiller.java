package fillers.process;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

/**
 * Created by r.isin on 21.02.2017.
 *
 * Wrapper for Filler class, with wrapped exceptions
 *
 * @author MiF
 * @version $Id: $Id
 */
public class SilentFiller<T>{
    private Filler<T> base;

    /**
     * <p>of.</p>
     *
     * @param type a {@link java.lang.Class} object.
     * @param <T> a T object.
     * @return a {@link fillers.process.SilentFiller} object.
     */
    public static <T> SilentFiller<T> of(Class<T> type){
        return new SilentFiller<T>(type);
    }

    private SilentFiller(Class<T> item) {
        base = Filler.of(item);
    }

    /**
     * wrapper for single with default exception handling
     *
     * @return Single filled object
     */
    public T single() {
        List<T> items = items(1);
        return items.size() == 0 ? null : items.get(0);
    }


    /**
     * <p>items.</p>
     *
     * @param count single of filled objects
     * @return List with count of elements
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
