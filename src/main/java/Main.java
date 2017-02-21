import fillers.process.AnnotationProcessor;

/**
 * Created by r.isin on 21.02.2017.
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SimpleData d = new AnnotationProcessor<SimpleData>(SimpleData.class).getInstance();
        System.out.println(d.getName());
        System.out.println(d.getLast());
    }
}
