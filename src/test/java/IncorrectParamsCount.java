import annotations.Fill;

/**
 * Created by r.isin on 28.02.2017.
 */
public class IncorrectParamsCount {

    @Fill(filler = TestStringConstantsFiller.class, method = "countAndNumeric", params = "5")
    private String incorrectParametersCount;

}
