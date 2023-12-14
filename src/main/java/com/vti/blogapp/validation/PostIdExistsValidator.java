package com.vti.blogapp.validation;

import com.vti.blogapp.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostIdExistsValidator implements ConstraintValidator<PostIdExists, Long> {
   private final PostRepository postRepository;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {

        return postRepository.existsById(id);
    }
}
