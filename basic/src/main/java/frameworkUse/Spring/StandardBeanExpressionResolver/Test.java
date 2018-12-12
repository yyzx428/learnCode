package frameworkUse.Spring.StandardBeanExpressionResolver;


import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {
    public static void main(String[] args) {
        StandardBeanExpressionResolver resolver = new StandardBeanExpressionResolver();
        resolver.setExpressionPrefix("${");
        resolver.setExpressionSuffix("}");
        resolver.setExpressionParser(new SpelExpressionParser());
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("user", "张三");
        Object value = resolver.evaluate("${ user }", new BeanExpressionContext(factory, null));
        System.out.println(value);
    }
}
