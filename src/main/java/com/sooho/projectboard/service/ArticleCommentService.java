package com.sooho.projectboard.service;

import com.sooho.projectboard.domain.Article;
import com.sooho.projectboard.domain.ArticleComment;
import com.sooho.projectboard.domain.UserAccount;
import com.sooho.projectboard.dto.ArticleCommentDto;
import com.sooho.projectboard.repository.ArticleCommentRepository;
import com.sooho.projectboard.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;


    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto of) {
    }
}