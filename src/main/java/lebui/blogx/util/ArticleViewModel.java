package lebui.blogx.util;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import lebui.blogx.shared.entity.Article;
import lebui.blogx.shared.entity.Tag;

public class ArticleViewModel {

    private Integer id;

    private String title;

    private String content;

    private Date createdTime;

    private Date lastEdited;

    private String author;

    private Collection<String> tags;

    public ArticleViewModel(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdTime = article.getCreatedTime();
        this.lastEdited = article.getLastEdited();
        this.tags = article.getTags().stream().map(Tag::getName).collect(Collectors.toList());
        this.author = article.getAccount().getUsername();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void setTags(Collection<String> tags) {
        this.tags = tags;
    }

}
