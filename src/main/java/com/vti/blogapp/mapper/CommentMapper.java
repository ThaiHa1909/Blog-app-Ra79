package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentUpdateForm;
import com.vti.blogapp.form.PostCreateForm;
import org.springframework.stereotype.Service;


public class CommentMapper {
    public static Comment map(CommentCreateForm form){
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }

    public static Comment map(CommentUpdateForm form, Comment comment){
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }




    public static CommentDto map (Comment comment){
        var dto = new CommentDto();
       dto.setId(comment.getId());
       dto.setName(comment.getName());
       dto.setEmail(comment.getEmail());
       dto.setBody(comment.getBody());
       dto.setCreatedAt(comment.getCreatedAt());
       dto.setUpdatedAt(comment.getUpdatedAt());
        return dto.withSelfRel();
    }

}
