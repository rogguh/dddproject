package com.example.dddproject.controller;

import com.example.dddproject.domain.Board;
import com.example.dddproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * 리스트
     * @param model
     * @return
     */
    @GetMapping(value = "/list")
    public String list(Model model){
        return boardService.list(model);
    }

    /**
     * 등록
     * @return
     */
    @GetMapping(value = "/regis")
    public String regis(Board board){
        return boardService.regis(board);
    }
}