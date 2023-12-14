package com.vti.blogapp.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
@Getter
@Setter
public class CommentCreateForm {
    //@NotNull : khong null
    //@NotEmpty : vua khong null vua do do dai chuoi >0
    //@NotBlank : vua ko null, vua do dai chuoi >0, vua khong co khoang trang
    @NotBlank
    @Length(max = 50)
    private String name;

    @NotBlank
    @Length(max = 75)
    @Email
    private String email;

    @NotBlank
    @Length(max = 100)
    private String body;
}
