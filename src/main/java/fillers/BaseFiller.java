package fillers;

/**
 * Created by r.isin on 21.02.2017.
 *
 * Use for creating custom filler classes
 *
 * @author MiF
 * @version $Id: $Id
 */
public interface BaseFiller<T> {
    /**
     * <p>defaultFiller.</p>
     *
     * @return a T object.
     */
    public T defaultFiller();
}
