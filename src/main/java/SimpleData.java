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

    @Fill(filler = StringFiller.class, method = "test")
    private String last;
    Map<String, String> properties;

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
}
