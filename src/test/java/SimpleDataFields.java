import annotations.Fill;

/**
 * Created by r.isin on 21.02.2017.
 */
public class SimpleDataFields {
    @Fill(filler = SimpleDataFiller.class)
    SimpleData defaultData;

    @Fill(filler = SimpleDataFiller.class, method = "customFiller")
    SimpleData custom;

    public SimpleData getDefaultData() {
        return defaultData;
    }

    public SimpleData getCustom() {
        return custom;
    }
}
