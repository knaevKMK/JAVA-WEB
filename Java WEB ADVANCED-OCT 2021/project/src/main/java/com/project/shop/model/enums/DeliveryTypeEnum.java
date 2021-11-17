package com.project.shop.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DeliveryTypeEnum {
    DOMESTIC(Arrays.stream(DeliveryServiceEnum.values()).map(Enum::name).collect(Collectors.toList())),
    INTERNATIONAL(Arrays.stream(DeliveryServiceEnum.values()).map(Enum::name).collect(Collectors.toList()));

    private final List<String> services;

    DeliveryTypeEnum(List<String> services) {
        this.services = services;
    }

    public List<String> getServices() {
        return services;
    }
}
