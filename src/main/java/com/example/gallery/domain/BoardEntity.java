package com.example.gallery.domain;

import com.example.gallery.domain.GroupEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "board_tb")
@NoArgsConstructor
@ToString
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupname", referencedColumnName = "groupname", insertable = false, updatable = false)
    private GroupEntity groupEntity;

    public BoardEntity(String title, String userid, String content, String groupname) {
        this.title = title;
        this.userid = userid;
        this.content = content;
        this.groupname = groupname;
        this.readcount = 0L;
        this.time = LocalDateTime.now();
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
