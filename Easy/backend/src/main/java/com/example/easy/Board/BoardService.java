package com.example.easy.Board;

import com.example.easy.Entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시물 등록
    public void post(BoardDTO boardDTO) {
        //    유저 정보가 유효하면 저장
//            Optiinal<UserEntity> userEntity = userRepository.findById(boardDTO.getUserNo());
//        if(!userEntity.isPresent()) {
//            throw new IllegalArgumentException("유저 정보가 유효하지 않습니다.");
//        } else {
        BoardEntity boardEntity = new BoardEntity();
//            boardEntity.setUserEntity(userEntity);
        boardEntity.setBoardName(boardDTO.getBoardName());
        boardEntity.setBoardText(boardDTO.getBoardText());
        boardEntity.setCategoryName(boardDTO.getCategoryName());
        boardEntity.setBoardDate(ZonedDateTime.now());
        boardRepository.save(boardEntity);
//        }
    }
    
    // 게시물 수정
    public void put(BoardDTO boardDTO){
        // 유저 정보가 유효하면 수정
//        Optional<UserEntity> userEntity = userRepository.findById(boardDTO.getUserNo());
//        Optional<BoardEntity> boardEntity = boardRepository.findById(boardDTO.getBoardNo());
//        if(!userEntity.isPresent() || !boardEntity.isPresent()) {
//            throw new IllegalArgumentException("게시물 정보가 유효하지 않습니다.");
//        }
//        else {
//            BoardEntity newBoardEntity = boardEntity.get();
        BoardEntity newBoardEntity = new BoardEntity();
            newBoardEntity.setBoardName(boardDTO.getBoardName());
            newBoardEntity.setBoardText(boardDTO.getBoardText());
            newBoardEntity.setCategoryName(boardDTO.getCategoryName());
            newBoardEntity.setBoardDate(ZonedDateTime.now());
            boardRepository.save(newBoardEntity);
//        }
    }
    // 게시물 삭제
    public void delete(int boardNo) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardNo);
        if(!boardEntity.isPresent()) {
            throw new IllegalArgumentException("게시물 정보가 유효하지 않습니다.");
        } else {
            boardRepository.deleteById(boardNo);
        }
    }

    // 게시물 조회
    public BoardDTO get(int boardNo) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardNo);
        if(!boardEntity.isPresent()) {
            throw new IllegalArgumentException("게시물 정보가 유효하지 않습니다.");
        } else {
            BoardEntity result = boardEntity.get();
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardName(result.getBoardName());
            boardDTO.setBoardText(result.getBoardText());
            boardDTO.setCategoryName(result.getCategoryName());
            boardDTO.setBoardDate(result.getBoardDate());
            return boardDTO;
        }
    }

}
