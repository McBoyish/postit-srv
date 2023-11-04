package com.jake.postit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Comment saveComment(@RequestBody Comment comment) {
        return comments.save(comment);
    }

    @PostMapping("/comment/find-all-by-post-id")
    public Iterable<Comment> findComments(@RequestBody CommentFindAllByPostIdRequestBody body) {
        if (body.cursor == null) {
            return comments.findAllByPostIdNoCursor((body.postId));
        }
        return comments.findAllByPostId(body.postId, body.cursor);
    }
}

class CommentFindAllByPostIdRequestBody {
    public CommentFindAllByPostIdRequestBody(Integer postId, Integer cursor) {
        this.postId = postId;
        this.cursor = cursor;
    }
    public Integer postId;
    public Integer cursor;

    public Integer limit;
}