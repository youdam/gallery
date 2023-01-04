package com.example.gallery.domain;

import com.example.gallery.domain.GroupEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*  해당 오류 발생으로 인해서
 : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception
  [Handler dispatch failed; nested exception is java.lang.StackOverflowError] with root cause

java.lang.StackOverflowError: null
	at com.example.gallery.domain.BoardEntity.toString(BoardEntity.java:16) ~[classes/:na]
	at java.base/java.lang.String.valueOf(String.java:2951) ~[na:na]
	at com.example.gallery.domain.FileEntity.toString(FileEntity.java:13) ~[classes/:na]
 */
@Entity
@Data
@Table(name = "board_tb")
@NoArgsConstructor
@ToString(exclude = {"files", "groupEntity"}) //이거 추가했음. fileentity 도 또까또까 -> 블로그
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "no", nullable = false )
    private Long no;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "userid", nullable = false)
    private String userid;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "readcount", nullable = false)
    private Long readcount;

    @Column(name = "groupname")
    private String groupname;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    private List<FileEntity> files;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupname", referencedColumnName = "groupname", insertable = false, updatable = false)
    private GroupEntity groupEntity;

    public BoardEntity(Long no, String title, String userid, String content, Long readcount, String groupname, LocalDateTime time) {
        this.no = no;
        this.title = title;
        this.userid = userid;
        this.content = content;
        this.groupname = groupname;
        this.readcount = readcount;
        this.time = time;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be null or empty");
        }
        this.title = title;
    }

    public void setContent(String content) {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content must not be null or empty");
        }
        this.content = content;
    }
}
