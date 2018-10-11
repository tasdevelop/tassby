package com.gorich.admin.tastruckingsby;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogTujuanList {
    String status;

    int count;

    @SerializedName("count_total")
    int totalCount;

    int pages;

    List<PostTujuanList> posttujuanlist;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<PostTujuanList> getPoststujuan() {
        return posttujuanlist;
    }

    public void setPoststujuan(List<PostTujuanList> posttujuanlist) {
        this.posttujuanlist = posttujuanlist;
    }
}
