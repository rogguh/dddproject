package com.example.dddproject.entitiy;

import com.example.dddproject.domain.BoardType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoardEntity {

    //protected Board(){}                                                       // LINE :: 무자비한 인스턴스 생성 방지

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx")
    private Long idx;                                                           // LINE :: 고유값

    private String title;                                                       // LINE :: 제목
    private String contents;                                                    // LINE :: 내용

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    List<FileEntity> fileList = new ArrayList<>();                              // LINE :: 연관 파일 리스트

    @Embedded
    private BoardType boardType;                                                // LINE :: 게시판 타입(BASIC : 기본, IMAGE : 이미지)

    private Boolean delStatus = false;                                          // LINE :: 삭제상태
    private LocalDateTime regDateTime;                                          // LINE :: 등록일

    @Transient
    private List<MultipartFile> multipartFiles;                                 // LINE :: 연관 파일 업로드 객체 리스트


    /**
     * 생성 함수
     */

    // 비즈니스 로직 ---------------------------------------------------------------------------------------------------


    // -----------------------------------------------------------------------------------------------------------------
}