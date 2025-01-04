package com.pablopafundi.site.config;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimitingFilter implements Filter {

    private static final int MAX_REQUESTS = 60;
    private static final long TIME_WINDOW = 60 * 1000L;

    private final ConcurrentHashMap<String, RateLimitInfo> requestCounters = new ConcurrentHashMap<>();


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String clientIp = request.getRemoteAddr();


        RateLimitInfo rateLimitInfo = requestCounters.compute(clientIp, (key, value) -> {
            if (value == null || System.currentTimeMillis() - value.timestamp > TIME_WINDOW) {

                return new RateLimitInfo(System.currentTimeMillis(), new AtomicInteger(1));
            } else {

                value.requestCount.incrementAndGet();
                return value;
            }
        });


        if (rateLimitInfo.requestCount.get() > MAX_REQUESTS) {
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Too many requests\"}");
            return;
        }


        chain.doFilter(request, response);
    }

    private static class RateLimitInfo {
        long timestamp;
        AtomicInteger requestCount;

        public RateLimitInfo(long timestamp, AtomicInteger requestCount) {
            this.timestamp = timestamp;
            this.requestCount = requestCount;
        }
    }
}
