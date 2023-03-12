package com.example.dormitory.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
