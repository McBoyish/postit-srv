package com.jake.postit;

import org.springframework.data.annotation.Id;

public class Post {
    public Post(String title, String content, String imgUrl) {
        this.setTitle(title);
        this.setContent(content);
        this.setImgUrl(imgUrl);
        this.setDatetime(System.currentTimeMillis());
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    @Id
    private Integer id;
    private String title;
    private String content;
    private String imgUrl;

    private long datetime;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }
}
