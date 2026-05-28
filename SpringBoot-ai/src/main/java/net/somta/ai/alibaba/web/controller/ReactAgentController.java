package net.somta.ai.alibaba.web.controller;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.graph.agent.ReactAgent;
import com.alibaba.cloud.ai.graph.exception.GraphRunnerException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "agent接口")
@RestController
@RequestMapping("/agent")
public class ReactAgentController {

    @Operation(summary = "reactAgent接口")
    @GetMapping("/reactAgent")
    public String reactAgent() throws GraphRunnerException {
        DashScopeApi dashScopeApi = DashScopeApi.builder()
                .build();

        // 创建 ChatModel
        ChatModel chatModel = DashScopeChatModel.builder()
                .dashScopeApi(dashScopeApi)
                .build();

        // 创建 Agent
        ReactAgent agent = ReactAgent.builder()
                .name("my_agent")
                .model(chatModel)
                .systemPrompt("你是一个专业的技术助手。请准确、简洁地回答问题。")
                .build();
        AssistantMessage response = agent.call("杭州的天气怎么样？");
        System.out.println(response.getText());
        return response.getText();
    }
}
