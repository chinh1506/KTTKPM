package com.example.springretry2.config;

import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

public class RetryConfig {
    public void test(){
        RetryTemplate template = new RetryTemplate();

        TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
        policy.setTimeout(30000L);

        template.setRetryPolicy(policy);

        Foo result = template.execute(new RetryCallback<Foo>() {

            public Foo doWithRetry(RetryContext context) {
                // Do stuff that might fail, e.g. webservice operation
                return result;
            }

        });
    }
}
