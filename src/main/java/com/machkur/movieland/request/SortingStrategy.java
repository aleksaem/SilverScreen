package com.machkur.movieland.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortingStrategy {
    @NotNull
    private SortBy sortBy;
    @NotNull
    private SortingRoute sortingRoute;
}
