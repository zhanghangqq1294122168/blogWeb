package cn.zh.blog.pojo;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(indexes = {@Index(columnList = "ArticleId")})
public class Article {

    //    博文Id
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer articleId;
    //    标题
    private String articleTitle;
    //    内容
    private String articleContent;
    //    创建时间
    private String articleCreateTime;
    //    修改时间
    private String articleUpdateTime;
}
