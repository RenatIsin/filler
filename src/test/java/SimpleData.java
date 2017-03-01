import annotations.Fill;
import fillers.StringFiller;

import java.util.Map;

/**
 * Created by r.isin on 21.02.2017.
 */
public class SimpleData {

    private int id;

    @Fill(filler = StringFiller.class)
    private String name;

    @Fill(filler = StringFiller.class, method = "random")
    private String last;

    Map<String, String> properties;

    @Fill(filler = TestStringConstantsFiller.class)
    private String defaultFiller;

    @Fill(filler = TestStringConstantsFiller.class, method = "constantStringFiller")
    private String constantStringFiller;

    @Fill(filler = TestStringConstantsFiller.class, method = "constantInt")
    private int constantInt;

    @Fill(filler = TestStringConstantsFiller.class, method = "newInteger")
    private Integer newInteger;

    @Fill(filler = TestStringConstantsFiller.class, method = "nullString")
    private String nullString;

    @Fill(filler = TestStringConstantsFiller.class, method = "emptyString")
    private String emptyString;

    public final static String lengthParam = "4";

    @Fill(filler = TestStringConstantsFiller.class, method = "parametrized", params = lengthParam)
    private String parametrized;

    public final static String type = "Numeric";

    @Fill(filler = TestStringConstantsFiller.class, method = "countAndNumeric", params = {lengthParam, type})
    private String countAndNumeric;

    @Fill(filler = TestStringConstantsFiller.class, method = "countAndNumeric", params = {lengthParam, "asd"})
    private String countAndNotNumeric;

    public SimpleData(){}

    public SimpleData(int id, String name, String last) {
        this.id = id;
        this.name = name;
        this.last = last;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLast() {
        return last;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getDefaultFiller() {
        return defaultFiller;
    }

    public String getConstantStringFiller() {
        return constantStringFiller;
    }

    public int getConstantInt() {
        return constantInt;
    }

    public Integer getNewInteger() {
        return newInteger;
    }

    public String getNullString() {
        return nullString;
    }

    public String getEmptyString() {
        return emptyString;
    }

    public String getParametrized() {
        return parametrized;
    }

    public String getCountAndNumeric() {
        return countAndNumeric;
    }

    public String getCountAndNotNumeric() {
        return countAndNotNumeric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleData that = (SimpleData) o;

        if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getLast() != null ? getLast().equals(that.getLast()) : that.getLast() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLast() != null ? getLast().hashCode() : 0);
        return result;
    }
}
