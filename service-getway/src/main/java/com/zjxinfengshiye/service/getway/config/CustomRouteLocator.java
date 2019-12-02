package com.zjxinfengshiye.service.getway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    @Value("${spring.application.name}")
    private String appId;

    @Autowired
    DiscoveryClient discoveryClient;


    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        List<String> serviceIds = discoveryClient.getServices()
                .stream()
                .filter(s -> !s.toLowerCase().equals(appId))
                .collect(Collectors.toList());

        LinkedHashMap<String, ZuulProperties.ZuulRoute> routeHashMap = new LinkedHashMap<>();

        int id = 0;

        for (int i = 0; i < serviceIds.size(); i++) {
            String serviceId = serviceIds.get(i);
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            for (int j = 0; j < instances.size(); j++) {
                ServiceInstance serviceInstance = instances.get(j);
                ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
                zuulRoute.setId(id + "");
                zuulRoute.setServiceId(serviceInstance.getServiceId());
                zuulRoute.setUrl(serviceInstance.getUri().toString());
                zuulRoute.setRetryable(false);
                String path = "/" + serviceId.substring(8).toLowerCase() + "/**";
                zuulRoute.setPath(path);
                routeHashMap.put(path, zuulRoute);
                id++;
            }
        }
        return routeHashMap;
    }



    @Override
    public void refresh() {
        doRefresh();
    }
}
