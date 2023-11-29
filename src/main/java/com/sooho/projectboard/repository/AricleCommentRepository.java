package com.sooho.projectboard.repository;

import com.sooho.projectboard.domain.AricleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AricleCommentRepository extends JpaRepository<AricleComment, Long> {
}