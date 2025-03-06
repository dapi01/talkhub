package org.codenova.talkhub.model.vo;

import java.util.Date;

public class Post {

    private String writer_id;
    private String category;
    private String title;
    private String content;
    private int views;
    private int likes;
    private Date writed_at;
    private Date modified_at;

    public Post() {
    }

    public Post(String writer_id, String category, String title, String content, int views, int likes, Date writed_at, Date modified_at) {
        this.writer_id = writer_id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.views = views;
        this.likes = likes;
        this.writed_at = writed_at;
        this.modified_at = modified_at;
    }

    public String getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(String writer_id) {
        this.writer_id = writer_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getWrited_at() {
        return writed_at;
    }

    public void setWrited_at(Date writed_at) {
        this.writed_at = writed_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }
}