package com.project.shop.model;

public class Page  {
private Integer page;
private Integer totalPages;
private Integer limit;

    public Page() {
    }

    public Page(Integer page, Integer limit,int totalPage) {
        this.page = page;
        this.limit = limit;
        this.totalPages = totalPage;
    }

    public Integer getPage() {
        return page;
    }

    public Page setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Page setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public Page setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }
}
