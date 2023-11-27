package com.sooho.projectboard.domain;

import java.time.LocalDateTime;

public class AricleComment {

    private Long id;
    private Article article;
    private String title;

    private LocalDateTime createAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
