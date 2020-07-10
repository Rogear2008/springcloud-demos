package com.rogear.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rogear on 2020/7/9
 **/
@Configuration
public class PreLogFilter extends ZuulFilter {

    private Logger LOGGER = LoggerFactory.getLogger(PreLogFilter.class);

    /**
     * 过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否启用过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String method = request.getMethod();
        StringBuffer requestURL = request.getRequestURL();
        LOGGER.info("method:{} requestURL:{}",method,requestURL);
        return null;
    }
}
