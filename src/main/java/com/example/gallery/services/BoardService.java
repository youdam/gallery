package com.example.gallery.services;

import com.example.gallery.domain.BoardEntity;
import com.example.gallery.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    public List<BoardEntity> findBoards() {
        return boardRepository.findAll();
    }


    public BoardEntity findOne(Long no) {
        return boardRepository.findById(no).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public void create(BoardEntity board) {

        boardRepository.save(board);

        //여기부터 추가


    }

    @Transactional
    public void update(Long no, String title, String content) {
        BoardEntity findBoard = boardRepository.findById(no).orElseThrow(NullPointerException::new);
        findBoard.setTitle(title);
        findBoard.setContent(content);
    }


    @Transactional
    public void delete(BoardEntity board) {

        boardRepository.delete(board);
    }
}
