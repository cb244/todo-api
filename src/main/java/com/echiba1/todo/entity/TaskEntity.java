package com.echiba1.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity extends AbstractEntity {
    /** タスク内容 */
    @Column(name = "content", nullable = false)
    private String content;

    /** 完了したか */
    @Column(name = "done", nullable = true)
    private Boolean done;
}
