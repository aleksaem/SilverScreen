package com.machkur.movieland.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @NotNull
    @Valid
    private SortingStrategy sortingStrategy;
}
