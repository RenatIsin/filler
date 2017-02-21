import fillers.BaseFiller;

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
}
