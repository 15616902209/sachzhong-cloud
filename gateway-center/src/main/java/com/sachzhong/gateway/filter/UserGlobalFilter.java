package com.sachzhong.gateway.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.RouteMatcher;
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
        System.out.println("-----------------------come in MyLogGateWayFilter: "+route);
        System.out.println("-----------------------come in MyLogGateWayFilter: "+new Date());
        //每次进来后判断带不带uname这个key
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if(name == null){
            System.out.println("-----------------------用户名为null ，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        System.out.println("-----------------------验证成功继续吧！<!V!>");
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
}
