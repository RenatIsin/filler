import fillers.process.Filler;
import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by r.isin on 21.02.2017.
 */
public class SimpleTests {

    @Test
    public void simpleField() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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

        assertEquals(testObject.getParametrized().length(), Integer.parseInt(SimpleData.lengthParam));

        assertEquals(testObject.getCountAndNumeric().length(), Integer.parseInt(SimpleData.lengthParam));
        assertEquals(StringUtils.isNumeric(testObject.getCountAndNumeric()), true);

        assertEquals(testObject.getCountAndNotNumeric().length(), Integer.parseInt(SimpleData.lengthParam));
        assertEquals(StringUtils.isAlpha(testObject.getCountAndNotNumeric()), true);
    }

    @Test
    public void objectFiller() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        SimpleDataFields testObject = new Filler<SimpleDataFields>(SimpleDataFields.class).getInstance();
        SimpleDataFiller f = new SimpleDataFiller();
        SimpleData defaultObject = f.defaultFiller();

        assertEquals(testObject.getCustom(), SimpleDataFiller.custom);
        assertEquals(testObject.getDefaultData(), defaultObject);
    }

    @Test
    public void twoInstances() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<SimpleData> testObjects = new Filler<SimpleData>(SimpleData.class).getInstance(2);
        assertNotEquals(testObjects.get(0), testObjects.get(1));
    }

    @Test
    public void instanceException(){
        Filler<NoDefaultConstructor> noDefaultConstructorFiller = new Filler<>(NoDefaultConstructor.class);
        try {
            noDefaultConstructorFiller.getInstance();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(noDefaultConstructorFiller.single());

        Filler<IncorrectType> incorrectTypeFiller = new Filler<>(IncorrectType.class);
        try {
            incorrectTypeFiller.getInstance();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(incorrectTypeFiller.single());
    }
}
