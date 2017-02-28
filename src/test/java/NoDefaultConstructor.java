import annotations.Fill;

/**
 * Created by r.isin on 28.02.2017.
 */
public class NoDefaultConstructor {
    public NoDefaultConstructor(char c){}

    @Fill(filler = SimpleDataFiller.class, method = "getNumeric")
    private String number;
}
