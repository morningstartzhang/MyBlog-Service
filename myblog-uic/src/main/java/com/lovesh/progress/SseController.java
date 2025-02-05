package com.lovesh.progress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseController {

    @GetMapping({"inquiry"})
    public SseEmitter inquiry(@RequestParam String name) {
        return ProgressContext.inquiry(name);
    }

    @GetMapping({"exists"})
    public Boolean exists(@RequestParam String name) {
        return ProgressContext.exists(name);
    }

}
