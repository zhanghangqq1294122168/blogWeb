package cn.zh.blog.controller;

import cn.zh.blog.pojo.Article;
import cn.zh.blog.repository.ArticleRepository;
import cn.zh.blog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleJpa;

    @PostMapping("save")
    @ResponseBody
    public Result save(Article article) {
        return Result.ok(articleJpa.save(article));
    }

    @GetMapping("findArticleTitle")
    @ResponseBody
    public Result findArticleTitle() {
        return Result.ok(articleJpa.findClassify());
    }

    @ResponseBody
    @GetMapping("findList")
    public Result findList(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable) {
        return Result.ok(articleJpa.findAll(pageable));
    }


}
