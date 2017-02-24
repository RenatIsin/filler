package fillers;


import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by r.isin on 21.02.2017.
 *
 * Example default and random String filler
 */
public class StringFiller implements BaseFiller<String> {
    public String defaultFiller() {
        return "default string";
    }

    public String random() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

}
