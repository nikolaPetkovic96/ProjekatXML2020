package com.example.commentandrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commentandrating.model.Komentar;

@Repository
public interface CommentRepoitory extends JpaRepository<Komentar, Long> {

}
