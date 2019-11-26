package com.example.myblog.Repositories;

import com.example.myblog.Domain.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BlogRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BlogPost> fetchAllBlogPosts() {

        return jdbcTemplate.query(
                "select * from posts",
                (resultSet, rowNum) ->
                        new BlogPost(
                                resultSet.getInt("id"),
                                resultSet.getString("content"))
        );
    }

    public int save(BlogPost blogPost) {

        return jdbcTemplate.update(
                "insert into posts (content) values(?,?)",
                blogPost.getContent());
    }

}
