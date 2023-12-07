package com.vti.blogapp.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CommentCreateForm {

    private String name;
    private String email;
    private String body;
}
