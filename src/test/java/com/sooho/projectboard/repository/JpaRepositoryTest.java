package com.sooho.projectboard.repository;

import com.sooho.projectboard.config.JpaConfig;
import com.sooho.projectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;


import java.util.List;

import static org.assertj.core.api.Assertions.*;



@DisplayName("Jpa 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private  final ArticleRepository articleRepository;
    private final AricleCommentRepository  articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired AricleCommentRepository aricleCommentRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = aricleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();
        // Then
        assertThat(articles)
                .isNotNull()
                .hasSize(123);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_wheninserting_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();


        // When
        Article savedArticle = articleRepository.save(Article.of("new article","new content", "#spring"));
        // Then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);

    }

    @DisplayName("Update 테스트")
    @Test
    void givenTestData_whenUpdateing_thenWorksFine() {
        // Given
        Article article  =  articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "springboot";
        article.setHashtag(updatedHashtag);


        // When
        Article savedArticle = articleRepository.saveAndFlush(article);
        articleRepository.flush();

        // Then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);

    }


    @DisplayName("Delete 테스트")
    @Test
    void givenTestData_whenDeleteing_thenWorksFine() {
        // Given
        Article article  =  articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        long deletedCommentsSize = article.getAricleComments().size();



        // When
        articleRepository.delete(article);


        // Then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentsSize);

    }

}