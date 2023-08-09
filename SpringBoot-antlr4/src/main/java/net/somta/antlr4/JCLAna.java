package net.somta.antlr4;

import net.somta.antlr4.g4.HelloBaseListener;
import net.somta.antlr4.g4.HelloParser;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

public class JCLAna extends HelloBaseListener {

    private TokenStreamRewriter tokenStreamRewriter;

    public JCLAna(TokenStreamRewriter tokenStreamRewriter) {
        super();
        this.tokenStreamRewriter = tokenStreamRewriter;
    }

    @Override
    public void enterProg(HelloParser.ProgContext ctx) {
//        super.enterProg(ctx);
        System.out.println(">>>" + ctx.getText());

        HelloParser.Level_numContext level_numContext = ctx.level_num();
        TerminalNode num = level_numContext.NUM();
    }

    @Override
    public void exitLevel_num(HelloParser.Level_numContext ctx) {
//        super.exitLevel_num(ctx);

        String text = ctx.getText();

        Integer level_num = Integer.valueOf(text);
        level_num += 1;

        // 修改替换 level_num，
        tokenStreamRewriter.replace(ctx.getStart(), ctx.getStop(), String.valueOf(level_num));


    }
}

