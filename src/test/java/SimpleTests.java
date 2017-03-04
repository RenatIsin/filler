import fillers.process.Filler;
import fillers.process.SilentFiller;
import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by r.isin on 21.02.2017.
 */
public class SimpleTests {

    @Test
    public void simpleField() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        SimpleData testObject = Filler.of(SimpleData.class).single();
        TestStringConstantsFiller filler = new TestStringConstantsFiller();

        assertEquals(testObject.getDefaultFiller(), filler.defaultFiller());

        assertEquals(testObject.getConstantStringFiller(), filler.constantStringFiller());

        assertEquals(testObject.getConstantInt(), filler.constantInt());

        assertEquals(testObject.getNewInteger(), filler.newInteger());

        assertEquals(testObject.getNullString(), filler.nullString());
        assertEquals(testObject.getNullString(), null);

        assertEquals(testObject.getEmptyString(), filler.emptyString());
        assertEquals(testObject.getEmptyString(), "");

        assertEquals(testObject.getParametrized().length(), Integer.parseInt(SimpleData.lengthParam));

        assertEquals(testObject.getCountAndNumeric().length(), Integer.parseInt(SimpleData.lengthParam));
        assertEquals(StringUtils.isNumeric(testObject.getCountAndNumeric()), true);

        assertEquals(testObject.getCountAndNotNumeric().length(), Integer.parseInt(SimpleData.lengthParam));
        assertEquals(StringUtils.isAlpha(testObject.getCountAndNotNumeric()), true);
    }

    @Test
    public void silentField() {
        SimpleData testObject = SilentFiller.of(SimpleData.class).single();
        TestStringConstantsFiller filler = new TestStringConstantsFiller();

        assertEquals(testObject.getDefaultFiller(), filler.defaultFiller());

        assertEquals(testObject.getConstantStringFiller(), filler.constantStringFiller());

        assertEquals(testObject.getConstantInt(), filler.constantInt());

        assertEquals(testObject.getNewInteger(), filler.newInteger());

        assertEquals(testObject.getNullString(), filler.nullString());
        assertEquals(testObject.getNullString(), null);

        assertEquals(testObject.getEmptyString(), filler.emptyString());
        assertEquals(testObject.getEmptyString(), "");

        assertEquals(testObject.getParametrized().length(), Integer.parseInt(SimpleData.lengthParam));

        assertEquals(testObject.getCountAndNumeric().length(), Integer.parseInt(SimpleData.lengthParam));
        assertEquals(StringUtils.isNumeric(testObject.getCountAndNumeric()), true);

        assertEquals(testObject.getCountAndNotNumeric().length(), Integer.parseInt(SimpleData.lengthParam));
        assertEquals(StringUtils.isAlpha(testObject.getCountAndNotNumeric()), true);
    }

    @Test
    public void objectFiller() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        SimpleDataFields testObject = Filler.of(SimpleDataFields.class).single();
        SimpleDataFiller f = new SimpleDataFiller();
        SimpleData defaultObject = f.defaultFiller();

        assertEquals(testObject.getCustom(), SimpleDataFiller.custom);
        assertEquals(testObject.getDefaultData(), defaultObject);
    }

    @Test
    public void twoInstances() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<SimpleData> testObjects = Filler.of(SimpleData.class).items(2);
        assertNotEquals(testObjects.get(0), testObjects.get(1));
    }

    @Test
    public void instanceException(){
        Filler<NoDefaultConstructor> noDefaultConstructor = Filler.of(NoDefaultConstructor.class);
        SilentFiller<NoDefaultConstructor> noDefaultConstructorSilent = SilentFiller.of(NoDefaultConstructor.class);
        try {
            noDefaultConstructor.single();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(noDefaultConstructorSilent.single());
        assertEquals(noDefaultConstructorSilent.items(2), Collections.EMPTY_LIST);

        Filler<IncorrectType> incorrectType = Filler.of(IncorrectType.class);
        SilentFiller<IncorrectType> incorrectTypeSilent = SilentFiller.of(IncorrectType.class);
        try {
            incorrectType.single();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(incorrectTypeSilent.single());
        assertEquals(incorrectTypeSilent.items(5), Collections.EMPTY_LIST);

        Filler<IncorrectParamsCount> incorrectParamsCount = Filler.of(IncorrectParamsCount.class);
        SilentFiller<IncorrectParamsCount> incorrectParamsCountSilent = SilentFiller.of(IncorrectParamsCount.class);
        try {
            incorrectParamsCount.single();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(incorrectParamsCountSilent.single());
        assertEquals(incorrectParamsCountSilent.items(33), Collections.EMPTY_LIST);
    }
}
