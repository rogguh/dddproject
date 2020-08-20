package com.example.dddproject.entitiy;

import com.example.dddproject.domain.BoardType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class BoardEntity {

    //protected Board(){}                                                       // LINE :: 무자비한 인스턴스 생성 방지

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx")
    private Long idx;                                                           // LINE :: 고유값

    private String title;                                                       // LINE :: 제목
    private String contents;                                                    // LINE :: 내용

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<FileEntity> fileList = new ArrayList<>();                      // LINE :: 연관 파일 리스트

    @Enumerated(EnumType.STRING)
    private BoardType boardType;                                                // LINE :: 게시판 타입(BASIC : 기본, IMAGE : 이미지)
    private int hits;                                                           // LINE :: 조회수

    private Boolean delStatus = false;                                          // LINE :: 삭제상태
    private LocalDateTime regDateTime;                                          // LINE :: 등록일

    @Transient
    private List<MultipartFile> multipartFiles;                                 // LINE :: 연관 파일 업로드 객체 리스트

    /**
     * 연관 관계 편의 메서드
     */
    public void addFileEntity(FileEntity fileEntity){
        fileList.add(fileEntity);
        fileEntity.setBoard(this);
    }

    /**
     * 생성 메서드
     */
    public static BoardEntity createBoardEntity(FileEntity... fileEntities){
        BoardEntity boardEntity = new BoardEntity();
        for(FileEntity fileEntity : fileEntities){  // LINE :: 파일 셋팅
            boardEntity.addFileEntity(fileEntity);
        }
        boardEntity.setBoardType(BoardType.BASIC);  // LINE :: 게시판 타입(기본)
        boardEntity.setRegDateTime(LocalDateTime.now()); // LINE :: 등록일
        return boardEntity;
    }

    // 비즈니스 로직 ---------------------------------------------------------------------------------------------------
    /**
     * 상세
     */
    public void view(){
        if(idx == null){
            throw new IllegalStateException("게시물이 없습니다.");
        }
        hits++; // LINE :: 조회수 증가
    }
    // -----------------------------------------------------------------------------------------------------------------
}