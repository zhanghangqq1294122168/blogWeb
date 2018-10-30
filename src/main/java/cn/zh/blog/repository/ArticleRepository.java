package cn.zh.blog.repository;

import cn.zh.blog.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select classify from Article")
    List<String> findClassify();
}
