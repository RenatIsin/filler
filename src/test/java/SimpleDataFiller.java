import fillers.BaseFiller;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by r.isin on 21.02.2017.
 */
public class SimpleDataFiller implements BaseFiller<SimpleData> {
    public static SimpleData custom;

    @Override
    public SimpleData defaultFiller() {
        return new SimpleData(1, "test", "last");
    }

    public String getNumeric(){
        return RandomStringUtils.randomNumeric(10);
    }

    public SimpleData customFiller() {
        custom = new SimpleData(56, RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphanumeric(3));
        return custom;
    }
}
