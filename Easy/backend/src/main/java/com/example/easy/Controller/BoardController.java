package com.example.easy.Controller;

import com.example.easy.DTO.BoardDTO;
import com.example.easy.Service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시물 등록
    @PostMapping
    public void post(@RequestParam BoardDTO boardDTO) {
        boardService.post(boardDTO);
    }

    // 게시물 조회
    @GetMapping
    public BoardDTO get(@RequestParam int boardNo) {
        return boardService.get(boardNo);
    }

    // 게시물 수정
    @PutMapping
    public void put(@RequestParam BoardDTO boardDTO) {
        boardService.put(boardDTO);
    }

    // 게시물 삭제
    public void delete(@RequestParam int boardNo) {
        boardService.delete(boardNo);
    }
}
