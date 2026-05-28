package net.somta.springboot.sse.web.controller;

import net.somta.springboot.sse.service.SseEmitterServer;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Random;

@RestController
public class StockController {

    /**
     * 连接客户端
     * @param clientId
     * @return
     */
    //@Async
    @GetMapping("/connect/{clientId}")
    public SseEmitter connect(@PathVariable String clientId) throws IOException {
        return SseEmitterServer.connect(clientId);
    }

    @GetMapping("/push/{message}")
    public Boolean push(@PathVariable(name = "message") String message) {
        Random random = new Random();
        // 生成随机的股票价格
        double price = 100 + random.nextDouble() * 10;
        // 构造股票价格的消息
        String priceMsg = String.format("%.2f", price);
        SseEmitterServer.batchSendMessage(priceMsg);
        return true;
    }

}