package fillers;


import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by r.isin on 21.02.2017.
 *
 * Example default and random String filler
 *
 * @author MiF
 * @version $Id: $Id
 */
public class StringFiller implements BaseFiller<String> {
    /**
     * <p>defaultFiller.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String defaultFiller() {
        return "default string";
    }

    /**
     * <p>random.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String random() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

}
