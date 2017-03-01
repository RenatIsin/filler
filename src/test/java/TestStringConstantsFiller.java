import fillers.BaseFiller;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by r.isin on 21.02.2017.
 */
public class TestStringConstantsFiller implements BaseFiller<String> {
    @Override
    public String defaultFiller() {
        return "default";
    }

    public String constantStringFiller(){
        return "string";
    }

    public int constantInt(){
        return 567;
    }

    public Integer newInteger(){
        return Integer.MIN_VALUE;
    }

    public String nullString(){
        return null;
    }

    public String emptyString(){
        return "";
    }

    public String parametrized(String count){
        return RandomStringUtils.random(Integer.parseInt(count));
    }

    public String countAndNumeric(String count, String type){
        if(type.equals("Numeric")) {
            return RandomStringUtils.randomNumeric(Integer.parseInt(count));
        } else {
            return RandomStringUtils.randomAlphabetic(Integer.parseInt(count));
        }
    }

    public String parametrizedIncorrectType(Integer count){
        return RandomStringUtils.random(count);
    }
}
