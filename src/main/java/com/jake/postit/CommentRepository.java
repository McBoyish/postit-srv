package com.jake.postit;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer>, CrudRepository<Comment, Integer> {
    List<Comment> findAllByPostId(Integer postId, Pageable page);
}
