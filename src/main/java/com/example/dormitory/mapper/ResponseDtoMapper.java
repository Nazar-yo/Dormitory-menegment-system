package com.example.dormitory.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
