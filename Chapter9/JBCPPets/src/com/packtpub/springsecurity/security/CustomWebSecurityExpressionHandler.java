package com.packtpub.springsecurity.security;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

public class CustomWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {
    public EvaluationContext createEvaluationContext(Authentication authentication, FilterInvocation fi) {
    	StandardEvaluationContext ctx = (StandardEvaluationContext) super.createEvaluationContext(authentication, fi);
        SecurityExpressionRoot root = new CustomWebSecurityExpressionRoot(authentication, fi);
        ctx.setRootObject(root);
        return ctx;
    }
}
