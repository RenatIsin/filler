import fillers.process.Filler;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by r.isin on 21.02.2017.
 */
public class SimpleTests {

    @Test
    public void simpleField() throws InstantiationException, IllegalAccessException {
        SimpleData testObject = new Filler<SimpleData>(SimpleData.class).getInstance();
        TestStringConstantsFiller filler = new TestStringConstantsFiller();
        assertEquals(testObject.getDefaultFiller(), filler.defaultFiller());
        assertEquals(testObject.getConstantStringFiller(), filler.constantStringFiller());
        assertEquals(testObject.getConstantInt(), filler.constantInt());
        assertEquals(testObject.getNewInteger(), filler.newInteger());
        assertEquals(testObject.getNullString(), filler.nullString());
        assertEquals(testObject.getNullString(), null);
        assertEquals(testObject.getEmptyString(), filler.emptyString());
        assertEquals(testObject.getEmptyString(), "");
    }

    @Test
    public void objectFiller() throws InstantiationException, IllegalAccessException {
        SimpleDataFields testObject = new Filler<SimpleDataFields>(SimpleDataFields.class).getInstance();
        SimpleDataFiller f = new SimpleDataFiller();
        SimpleData defaultObject = f.defaultFiller();

        assertEquals(testObject.getCustom(), SimpleDataFiller.custom);
        assertEquals(testObject.getDefaultData(), defaultObject);
    }
}
