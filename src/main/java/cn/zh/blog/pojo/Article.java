package cn.zh.blog.pojo;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(indexes = {@Index(columnList = "id")})
public class Article {
    //    博文Id
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    //    标题
    private String title;
    //    分类
    private String classify;
    //    内容
    private String content;
    //    创建时间
    private String createTime;
    //    修改时间
    private String updateTime;
}
