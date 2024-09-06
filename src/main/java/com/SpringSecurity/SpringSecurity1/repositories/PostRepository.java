package com.SpringSecurity.SpringSecurity1.repositories;
import com.SpringSecurity.SpringSecurity1.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
