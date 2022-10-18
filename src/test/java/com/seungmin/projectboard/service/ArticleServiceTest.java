package com.seungmin.projectboard.service;

import com.seungmin.projectboard.domain.Article;
import com.seungmin.projectboard.domain.type.SearchType;
import com.seungmin.projectboard.dto.ArticleDto;
import com.seungmin.projectboard.dto.ArticleUpdateDto;
import com.seungmin.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchP_whenSearchA_thenReturnA(){

     Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문, ID, 닉네임, 해시태그
     assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchA_thenReturnA(){

        ArticleDto articles = sut.searchArticle(1L);
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleInfo_whenSavingA_thenSavesA(){

        given(articleRepository.save(any(Article.class))).willReturn(null);

        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "Uno", "title", "content", "#java"));

        then(articleRepository).should().save(any(Article.class));

    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다")
    @Test
    void givenArticleId_whenUpdatingA_thenUpdatingA(){

        given(articleRepository.save(any(Article.class))).willReturn(null);

        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));

        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다")
    @Test
    void givenArticleId_whenDeletingA_thenDeletesA(){

        willDoNothing().given(articleRepository).delete(any(Article.class));

        sut.deleteArticle(1L);

        then(articleRepository).should().delete(any(Article.class));
    }
}