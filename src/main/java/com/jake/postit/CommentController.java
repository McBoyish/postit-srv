package com.jake.postit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
public class CommentController {

    @Autowired
    CommentRepository comments;

    @PostMapping("/comment/save")
    public void saveComment(@RequestBody Comment comment) {
        comments.save(comment);
    }

    @PostMapping("/comment/find-all-by-post-id")
    public List<Comment> findComments(@PathVariable Integer postId, @RequestParam Integer page) {
        Pageable p = PageRequest.of(page, 20, Sort.by("id").descending());
        return comments.findAllByPostId(postId, p);
    }

}