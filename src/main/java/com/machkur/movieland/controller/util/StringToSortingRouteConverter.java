package com.machkur.movieland.controller.util;

import com.machkur.movieland.request.SortingRoute;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToSortingRouteConverter implements Converter<String, SortingRoute> {
    @Override
    public SortingRoute convert(String source) {
        return SortingRoute.valueOf(source.toUpperCase());
    }
}
