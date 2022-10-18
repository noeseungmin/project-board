package com.seungmin.projectboard.service;

import com.seungmin.projectboard.domain.Article;
import com.seungmin.projectboard.domain.type.SearchType;
import com.seungmin.projectboard.dto.ArticleDto;
import com.seungmin.projectboard.dto.ArticleWithCommentsDto;
import com.seungmin.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
    }
    public void updateArticle(ArticleDto dto) {
    }

    public void deleteArticle(long articleId) {
    }

}