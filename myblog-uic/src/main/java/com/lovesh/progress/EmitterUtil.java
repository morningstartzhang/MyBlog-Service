package com.lovesh.progress;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class EmitterUtil {
    private static final Logger log = LoggerFactory.getLogger(EmitterUtil.class);

    private EmitterUtil() {
    }

    public static boolean send(SseEmitter sender, String name, Object data) {
        boolean value = false;

        try {
            sender.send(JSONUtil.parseObj(data));
            value = true;
        } catch (IllegalStateException | IOException var5) {
            Exception ex = var5;
            // log.error("[{}] Send back response failed", name, ExceptionUtils.getStackTrace(ex));
            sender.completeWithError(ex);
        }

        return value;
    }
}
