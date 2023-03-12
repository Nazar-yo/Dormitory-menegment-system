package com.example.dormitory.dto;

import java.util.List;
import lombok.Data;

@Data
public class Pages<T> {
    private List<T> content;
    private Long totalElements;
    private Integer totalPages;
}
