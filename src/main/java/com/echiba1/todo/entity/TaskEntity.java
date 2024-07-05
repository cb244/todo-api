package com.echiba1.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
// @NoArgsConstructor
@Table(name = "tasks")
public class TaskEntity extends AbstractEntity {
    /** タスクID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    TaskEntity() {
        this.content = "none";
        this.isDone = false;
    }

    /** タスク内容 */
    @Column(name = "content")
    private String content;
    /** 完了したか */
    @Column(name = "is_done")
    private boolean isDone;

    @Builder
    public TaskEntity(Integer id, String content, boolean isDone) {
        this.id = id;
        this.content = content;
        this.isDone = isDone;
    }

    public void update(String context, boolean isDone) {
        this.content = context;
        this.isDone = isDone;
    }
}
