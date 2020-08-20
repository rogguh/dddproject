package com.example.dddproject.entitiy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class FileEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_idx")
    private Long idx;                                                       // LINE :: 파일 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx")
    private BoardEntity board;                                              // LINE :: 연동 게시판

    private String filePath;                                                // LINE :: 파일 저장 경로
    private String uuid;                                                    // LINE :: 파일 UUID
    private String fileName;                                                // LINE :: 파일명
    private Long size;                                                      // LINE :: 파일 용량
    private String ext;                                                     // LINE :: 파일 확장자
    private LocalDateTime regDateTime;                                      // LINE :: 등록일

    /**
     * 생성 함수
     */
    private static FileEntity createFile(MultipartFile multipartFile){
        FileEntity fileEntity = new FileEntity();

        fileEntity.filePath = multipartFile.getOriginalFilename();

        return fileEntity;
    }
}