package cn.zh.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Data
@Table(indexes = {@Index(columnList = "id")})
public class UpFile extends BasePojo {

    public String fileName;

    public String url;

}
