package net.somta.springboot.sse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SseEmitterServer {
    private static final Logger logger = LoggerFactory.getLogger(SseEmitterServer.class);

    private static Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    public static SseEmitter connect(String clientId) throws IOException {
        // 设置超时时间，0表示不过期。默认30秒，超过时间未完成会抛出异常：AsyncRequestTimeoutException
        SseEmitter sseEmitter = new SseEmitter(40000L);
        sseEmitter.send(SseEmitter.event().reconnectTime(1000).data("连接成功"));
        sseEmitter.onCompletion(completionCallBack(clientId));
        //连接超时的回调
        sseEmitter.onTimeout(timeoutCallBack(clientId));
        sseEmitterMap.put(clientId, sseEmitter);
        return sseEmitter;
    }

    /**
     * 向所有客户端群发消息
     * @param message
     */
    public static void batchSendMessage(String message) {
        logger.info("本次批量发送的客户端数量：" + sseEmitterMap.size());
        sseEmitterMap.forEach((clientId, sseEmitter) -> {
            try {
                sseEmitter.send(message, MediaType.APPLICATION_JSON);
                sseEmitter.onCompletion(completionCallBack(clientId));
            } catch (IOException e) {
                logger.error("客户端[{}]推送异常:{}", clientId, e.getMessage());
                sseEmitter.completeWithError(e);
                removeClient(clientId);
            }
        });
    }

    private static Runnable completionCallBack(String clientId) {
        return () -> {
            logger.info("结束sse用户连接：{}", clientId);
            removeClient(clientId);
        };
    }

    private static Runnable timeoutCallBack(String clientId) {
        return () -> {
            logger.info("连接sse用户超时：{}", clientId);
            removeClient(clientId);
        };
    }

    private static Throwable errorCallBack(String clientId) {
        logger.info("sse用户连接异常：{}", clientId);
        removeClient(clientId);
        return new Throwable();
    }

    private static void removeClient(String clientId) {
        SseEmitter emitter = sseEmitterMap.get(clientId);
        if(emitter != null){
            emitter.complete();
        }
        sseEmitterMap.remove(clientId);
        logger.info("移除sse用户：{}", clientId);
    }


}
