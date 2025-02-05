package com.lovesh.progress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/start")
    public void startTask() {

        ProgressContext.start("test", BigDecimal.valueOf(10L));
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            while (ProgressContext.exists("test")){
                executorService.submit(() -> ProgressContext.increase("test", BigDecimal.ONE));
            }
        }finally {
            ProgressContext.end("test");
        }



        new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000L);

                    ProgressContext.increase("test");
                } catch (InterruptedException e) {
                }
            }
            ProgressContext.end("test");
        }).start();
    }

    @GetMapping("/inquiry")
    public SseEmitter inquiryTask() {
        return ProgressContext.inquiry("test");
    }
}