package com.example.gallery.repository;

import com.example.gallery.domain.Board;
import com.example.gallery.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
/* JpaRepository옆에 보면
    JpaRepository<T, ID> 이렇게 되어있음. Type 은 board(게시글이니까)
    id  는 뭐였노 long이였제?

    git !!
* */


public interface BoardRepository extends JpaRepository<Board, Long> {

}

