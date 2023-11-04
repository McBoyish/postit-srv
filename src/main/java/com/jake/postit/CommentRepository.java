package com.jake.postit;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer>, CrudRepository<Comment, Integer> {
    @Query("SELECT * FROM comment WHERE post_id = :postId AND id < :cursor ORDER BY id DESC LIMIT 100")
    Iterable<Comment> findAllByPostId(@Param("postId") Integer postId, @Param("cursor") Integer cursor);

    @Query("SELECT * FROM comment WHERE post_id = :postId ORDER BY id DESC LIMIT 100")
    Iterable<Comment> findAllByPostIdNoCursor(@Param("postId") Integer postId);
}
