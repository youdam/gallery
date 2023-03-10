package com.example.gallery.api;


import com.example.gallery.domain.Board;
import com.example.gallery.domain.Comment;
import com.example.gallery.dto.CommentDeleteDto;
import com.example.gallery.dto.CommentDto;
import com.example.gallery.service.BoardService;
import com.example.gallery.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MapsId;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    private final BoardService boardService;


    //READ-COMMENT : 해당 게시글에 달린 댓글이 전부 가야하니 list로 보내겠음
    @GetMapping("/api/comment-list/{boardId}")
    public WrapperClass comment_list(@PathVariable("boardId") Long boardId) {
        List<Comment> commentList = commentService.findByBoardId(boardId);
        List<CommentDto> commentDtoList = commentList.stream().map(b-> new CommentDto(b)).collect(Collectors.toList());

        return new WrapperClass(commentDtoList);
    }

    //CREATE-COMMENT
    @PostMapping("/api/create-comment")
    public ResponseEntity create_comment(@RequestBody CommentDto commentDto){
        System.out.println("1. 댓글달기기능 dto 는 도착했을까 : " + commentDto);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED;

        try {
            Comment comment = new Comment(
                    commentDto.getBoardId(),
                    commentDto.getUserId(),
                    commentDto.getContent_no(),
                    commentDto.getContent()
            );
            commentService.create(comment);
        }catch (Exception exception){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(body, headers, status);
    }


    //UPDATE-COMMENT
    @PostMapping("/api/update-comment")
    public ResponseEntity update_comment(@RequestBody CommentDto commentDto){
        System.out.println(" 백엔드 도착 댓글을 업데이트를 해보자 ! ");
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT;
        try {
            commentService.update(commentDto.getContent_no(), commentDto.getContent());

        }catch (Exception exception){
            status = HttpStatus.BAD_REQUEST;

        }
        System.out.println("댓글 업데이트 완료! 이제 프론트엔드로 보냅니다");
        return new ResponseEntity(body, headers, status);
    }


    //DELETE-COMMENT
    @DeleteMapping("/api/delete-comment")
    public ResponseEntity delete_comment(@RequestBody CommentDeleteDto commentDeleteDto){
        System.out.println("여기는 백엔드 댓글을 삭제해보자! ");
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT;
        try {
            Comment comment = commentService.findOne(commentDeleteDto.getContent_no());
            commentService.delete(comment);
        }catch (Exception exception){
            status = HttpStatus.BAD_REQUEST;

        }
        System.out.println("여기는백엔드 댓글삭제 완료!");
        return new ResponseEntity(body, headers, status);

    }

}
