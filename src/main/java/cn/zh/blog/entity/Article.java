package cn.zh.blog.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(indexes = {@Index(columnList = "id")})
public class Article extends BasePojo {

    private String title;

    private String classify;

    @Lob
    @Column(columnDefinition="TEXT")
    private String content;
}
