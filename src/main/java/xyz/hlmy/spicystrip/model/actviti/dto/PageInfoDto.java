package xyz.hlmy.spicystrip.model.actviti.dto;

public class PageInfoDto {

    private int index;
    private int pageSize;

    public int getIndex() {
        return index;
    }

    public PageInfoDto setIndex(int index) {
        this.index = index;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageInfoDto setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
