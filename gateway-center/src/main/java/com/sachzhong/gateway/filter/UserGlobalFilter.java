package com.sachzhong.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.Date;

/**
 @Author: SachZhong
 @Description:
 @Date Created in 2021/5/31 14:25
 */
@Component
public class UserGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Route route =  (Route)exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        System.out.println("\n----------------------------网关拦截器启动-------------------\n");
        System.out.println("请求信息: "+route);
        System.out.println("请求时间："+new Date());
        //每次进来后判断带不带uname这个key
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(!checkToken(name,token)){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            System.out.println("\n----------------------------网关拦截结束-------------------\n");
            return exchange.getResponse().setComplete();
        }
        System.out.println("\n----------------------------网关拦截结束-------------------\n");
        return chain.filter(exchange);
    }

    private boolean checkToken(String name,String token){
        if (null == name){
            System.out.println("网关校验失败：用户名为null,o(╥﹏╥)o");
            return false;
        }
        if (null == token){
            System.out.println("网关校验失败：Token为null,o(╥﹏╥)o");
            return false;
        }
        System.out.println("网关校验成功：继续吧。。。<!V!>");
        return true;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
