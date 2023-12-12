package com.vti.blogapp.Specification;

import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form){
        // Dung de build menh de WHERE, dau vao la form, dau ra la dieu kien can generate
        // SELECT * FROM post WHERE title LIKE '%java%'
    return (root, query, builder) -> {
       var predicates  = new ArrayList<Predicate>();

       var search = form.getSearch();
       if (StringUtils.hasText(search)){
           var pattern = "%" + search.trim()+"%";
           var predicate = builder.like(root.get("title"), pattern);
           // FROM post WHERE title LIKE '%java%'
           predicates.add(predicate);
       }

       var minCreatedDate = form.getMinCreatedDate();
       if(minCreatedDate != null) {
           //FROM post WHERE created_at >= '2020-09-20  00:00:00'
           var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
           var predicate = builder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
           predicates.add(predicate);
       }
           var maxCreatedDate = form.getMaxCreatedDate();
           if (maxCreatedDate != null){
               var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
               var predicate = builder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
               predicates.add(predicate);
           }

        return builder.and(predicates.toArray(new Predicate[0]));
    };
    }
}
