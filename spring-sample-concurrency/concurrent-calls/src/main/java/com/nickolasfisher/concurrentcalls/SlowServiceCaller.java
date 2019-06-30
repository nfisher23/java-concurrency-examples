package com.nickolasfisher.concurrentcalls;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class SlowServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public CompletableFuture<JsonNode> callOtherService() {
        String localSlowServiceEndpoint = "http://localhost:9000/slow";
        JsonNode responseObj = restTemplate.getForObject(localSlowServiceEndpoint, JsonNode.class);
        return CompletableFuture.completedFuture(responseObj);
    }
}
