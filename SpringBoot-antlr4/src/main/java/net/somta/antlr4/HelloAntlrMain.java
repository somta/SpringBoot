package net.somta.antlr4;

import net.somta.antlr4.g4.HelloLexer;
import net.somta.antlr4.g4.HelloParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 *
 * https://blog.csdn.net/qq_41886200/article/details/124061110
 * @author yz
 * @version 1.0
 * TODO
 * @date 2022/3/24 19:18
 */
public class HelloAntlrMain {
    public void execMath(String str) {
        CharStream input = CharStreams.fromString(str);

        // 将内容传递到词法解析器
        HelloLexer lexer = new HelloLexer(input);
        //getAllTokens() 行为会取出字符，导致后续无法解析
//        lexer.getAllTokens().forEach(token -> System.out.println(token.toString()));

        // 传递到流
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        //获取到g4捕获到所有内容
        TokenStreamRewriter tokenStreamRewriter = new TokenStreamRewriter(tokenStream);

        //将流传递到语法解析器
        HelloParser parser = new HelloParser(tokenStream);

        //两个方法都能生成树，但是prog会报结尾错误，具体原因不详
//        ParseTree tree = parser.prog();
        ParseTree tree = parser.compilation_unit();

        System.out.println(tree.toStringTree());

        //创建树遍历器
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();

        //添加自定义解析器
        JCLAna jclAna = new JCLAna(tokenStreamRewriter);

        // 添加树和自定义解析器到
        parseTreeWalker.walk(jclAna, tree);

        // 输出打印最终的内容
        System.out.println(tokenStreamRewriter.getText());
    }

    public static void main(String[] args) throws IOException {
        HelloAntlrMain antlrMain = new HelloAntlrMain();
        String str = "01 9 Hello world!";
        antlrMain.execMath(str);
    }
}

