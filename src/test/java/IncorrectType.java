import annotations.Fill;

/**
 * Created by r.isin on 28.02.2017.
 */
public class IncorrectType {

    @Fill(filler = TestStringConstantsFiller.class, method = "parametrizedIncorrectType", params = "5")
    private String parametrizedIncorrectType;

}
