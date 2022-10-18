package com.seungmin.projectboard.service;

import com.seungmin.projectboard.domain.Article;
import com.seungmin.projectboard.domain.ArticleComment;
import com.seungmin.projectboard.dto.ArticleCommentDto;
import com.seungmin.projectboard.repository.ArticleCommentRepository;
import com.seungmin.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
public class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingC_thenReturnC(){

        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title", "content", "#java"))
        );

        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void givenArticleId_whenSearchingC1_thenReturnC(){

        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title", "content", "#java"))
        );

        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }
}
