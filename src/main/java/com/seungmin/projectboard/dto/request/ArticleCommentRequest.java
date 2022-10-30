package com.seungmin.projectboard.dto.request;

import com.seungmin.projectboard.dto.ArticleCommentDto;
import com.seungmin.projectboard.dto.UserAccountDto;



/**
 * A DTO for the {@link com.seungmin.projectboard.domain.ArticleComment} entity
 */
public record ArticleCommentRequest(Long articleId, String content){

    public static ArticleCommentRequest of(Long articleId, String content){
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto){
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }

}