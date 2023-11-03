package com.jake.postit;

import org.springframework.data.annotation.Id;

public class Comment {
    @Id
    private Integer id;
    private Integer postId;
    private String content;

    private long datetime;

    public Comment(Integer postId, String content) {
        setPostId(postId);
        setContent(content);
        this.setDatetime(System.currentTimeMillis());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }
}
