package com.example.dddproject.service;

import com.example.dddproject.domain.Board;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BoardService {

    /**
     * 리스트
     * @param model
     * @return
     */
    public String list(Model model){
        return "/list";
    }

    /**
     * 등록
     * @return
     */
    public String regis(Board board){
        return "/regis";
    }
}