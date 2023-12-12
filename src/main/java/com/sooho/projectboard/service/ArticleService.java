package com.sooho.projectboard.service;

import com.sooho.projectboard.domain.type.SearchType;
import com.sooho.projectboard.dto.ArticleDto;
import com.sooho.projectboard.dto.ArticleUpdateDto;
import com.sooho.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeywoard) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return  null;
    }




    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(long article, ArticleUpdateDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
