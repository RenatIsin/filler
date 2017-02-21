package fillers;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by r.isin on 21.02.2017.
 */
public class StringFiller implements BaseFiller<String> {
    public String defaultFiller() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public String test(){
        return "3";
    }
}
