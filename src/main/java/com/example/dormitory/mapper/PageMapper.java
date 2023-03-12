package com.example.dormitory.mapper;

import com.example.dormitory.dto.Pages;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {
    public <T,D> Pages<D> mapToPage(Page<T> pages) {
        Pages<D> localPages = new Pages<>();
        localPages.setTotalPages(pages.getTotalPages());
        localPages.setTotalElements(pages.getTotalElements());

        return localPages;
    }
}
