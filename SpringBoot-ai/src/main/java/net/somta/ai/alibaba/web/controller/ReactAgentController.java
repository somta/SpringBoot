package net.somta.ai.alibaba.web.controller;

import com.alibaba.cloud.ai.graph.agent.ReactAgent;
import com.alibaba.cloud.ai.graph.exception.GraphRunnerException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.somta.ai.alibaba.pojo.Recipe;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "agent接口")
@RestController
@RequestMapping("/agent")
public class ReactAgentController {

    private final ChatModel chatModel;

    public ReactAgentController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Operation(summary = "reactAgent基础能力")
    @GetMapping("/base/reactAgent")
    public String reactAgent() throws GraphRunnerException {
        // 创建 Agent
        ReactAgent agent = ReactAgent.builder()
                .name("my_agent")
                .model(chatModel)
                .systemPrompt("你是一个生活助手。请准确、简洁地回答问题。")
                .build();
        AssistantMessage response = agent.call("给我一个适合35岁中年男人的一天的增肥食谱？");
        System.out.println(response.getText());
        return response.getText();
    }


    @Operation(summary = "结构化输出")
    @GetMapping("/senior/reactAgent")
    public String structuralOutput() throws GraphRunnerException {
        // 创建 Agent
        ReactAgent agent = ReactAgent.builder()
                .name("my_agent")
                .model(chatModel)
                .outputType(Recipe.class)
                .systemPrompt("你是一个生活助手。请准确、简洁地回答问题。")
                .build();
        AssistantMessage response = agent.call("给我一个适合35岁中年男人的一天的增肥食谱？");
        System.out.println(response.getText());
        return response.getText();
    }

}
