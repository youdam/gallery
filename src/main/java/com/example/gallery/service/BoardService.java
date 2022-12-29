package com.example.gallery.service;

import com.example.gallery.domain.Board;
import com.example.gallery.domain.Image;
import com.example.gallery.repository.BoardRepository;
import com.example.gallery.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// db를 갔다 오는거니까 Repository랑 연동이 되어야함

/*
    private final BoardRepository boardRepository;
    Auto wired로 스프링 빈에 등록. 즉 autowired없이 autowired된..
    그니까 spring ionic(?) container 에서 관여할 수 있게
    등록 해주는 과정을 private final 로 해준거임
 */

@Service
@Transactional(readOnly = true)  //repository 에 접근할떄 (db에 접글할떄) 좀더 안전하게 접근하기위해, 접근할거란 명시
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; // Auto wired로 스프링 빈에 등록.

    private final ImageRepository imageRepository;


    public List<Board> findBoards() {
        return boardRepository.findAll();   // findAll은 boardREpository의 부모클래스거임. 그래서 걍 쓸수잇는거
    }

    public Board findOne(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(NullPointerException::new);
    }
    // findAllById또한 부모 메소드 그대로 가져온거임. 다만 boardId가 null일 수도 있기 떄문에 (그 경우 서버가 죽어버림)
    // 서버가 죽지않고 핸들링 하기 위하여 .뒤에 어쩌고 붙임


    // github 확인용  (master)

    @Transactional //DB에 작용하는 거니까 안전하게 작동을 해야하니까. 생성이나 삭제등 DB에 직접 영향주는건 이거로 감싸주는게 좋음
    public void create(Board board) {
        boardRepository.save(board);

    }
    //save도 내부 메서드임. board 저장하겠다 !

    @Transactional
    public void createpics(Image image){

        imageRepository.save(image);
    }


    @Transactional //db저장이니까
    public void update(Long id, String title, String content) {
        Board findBoard = boardRepository.findById(id).orElseThrow(NullPointerException::new);
        findBoard.setTitle(title);  //Dirty Checking
        findBoard.setContent(content);
    }
    //이게 음......... 본래 commit 시점마다 db에 쿼리를 쏘는거라 굉장히 느림 즉 settitle때 커밋 한번
    // setcontent때 커밋 또 한번 이래서 엄청 느린데,
    //         Board findBoard = boardRepository.findById(id).orElseThrow(NullPointerException::new);
    // 이게 영속성 컨텍스트로 (?) 영속성을 부여해서 좀더 빠르게 해준다...그걸 dirty checking 으로 업데이트를 수행한다고
    // 표현함.

    @Transactional
    public void delete(Board board) {
        boardRepository.delete(board);
    }


}
