package com.jake.postit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
public class PostController {
    @Autowired
    PostRepository posts;

    @PostMapping("/post/save")
    public Post savePost(@RequestBody Post post) {
        return posts.save(post);
    }

    @PostMapping("/post/find-all")
    public Page<Post> findPosts(@RequestBody PostFindAllRequestBody body) {
        Pageable p = PageRequest.of(body.page, body.pageSize, Sort.by("id").descending());
        return posts.findAll(p);
    }

    @GetMapping("/post/{id}")
    public Post findPost(@PathVariable Integer id) {
        return posts.findById(id).orElse(null);
    }

}

 class PostFindAllRequestBody {
    public PostFindAllRequestBody(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
    public Integer page;
    public Integer pageSize;
}