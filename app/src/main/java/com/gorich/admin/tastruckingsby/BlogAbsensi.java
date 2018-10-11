package com.gorich.admin.tastruckingsby;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 5/8/2017.
 */

public class BlogAbsensi {
    String status;

    int count;

    @SerializedName("count_total")
    int totalCount;

    int pages;

    List<PostAbsensi> postsabsensi;

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

    public List<PostAbsensi> getPostsabsensi() {
        return postsabsensi;
    }

    public void setPostsabsensi(List<PostAbsensi> postsabsensi) {
        this.postsabsensi = postsabsensi;
    }
}
