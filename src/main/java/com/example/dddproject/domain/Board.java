package com.example.dddproject.domain;

import com.example.dddproject.entitiy.FileEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Board {

    private Long idx;                                                           // LINE :: 고유값
    private String title;                                                       // LINE :: 제목
    private String contents;                                                    // LINE :: 내용
    List<FileEntity> fileList = new ArrayList<>();                              // LINE :: 연관 파일 리스트

    private BoardType boardType;                                                // LINE :: 게시판 타입(BASIC : 기본, IMAGE : 이미지)

    private Boolean delStatus = false;                                          // LINE :: 삭제상태
    private LocalDateTime regDateTime;                                          // LINE :: 등록일

    private List<MultipartFile> multipartFiles;                                 // LINE :: 연관 파일 업로드 객체 리스트
}
