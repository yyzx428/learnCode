package scanner.annotation;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import scanner.annotation.config.SampleConfig;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("scanner.annotation.config");
        context.refresh();
        System.out.println(context.getBean(SampleConfig.class));
    }
}
