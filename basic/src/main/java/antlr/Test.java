package antlr;

import antlr.antlrcode.hello.HelloLexer;
import antlr.antlrcode.hello.HelloParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream("Hello sssasd".getBytes()));
        HelloLexer lexer = new HelloLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        HelloParser parser = new HelloParser(tokens);

        ParseTree tree = parser.r();

        System.out.println(tree.toStringTree(parser));
    }
}
