package com.sooho.projectboard.domain;

import java.time.LocalDateTime;

public class AricleComment {

    private Long id;
    private Article article; //게시글 (ID)
    private String title; // 해시태그

    private LocalDateTime createAt; // 생서일시
    private String createdBy; // 생성자
    private LocalDateTime modifiedAt; //수정일시
    private String modifiedBy; // 수정자
}
