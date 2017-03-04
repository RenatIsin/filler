package annotations;

import fillers.BaseFiller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by r.isin on 21.02.2017.
 *
 * Annotation for mark the specified field, and chose class and method for fill value
 *
 * @author MiF
 * @version $Id: $Id
 */
@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Fill {
    Class<? extends BaseFiller> filler();
    String method() default "defaultFiller";
    String [] params() default {};
}
