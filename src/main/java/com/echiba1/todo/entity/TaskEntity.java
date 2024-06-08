package com.echiba1.todo.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.LinkedHashMap;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "tasks")
public class TaskEntity {
    /** タスクID */
    @Id
    @Column(name = "id")
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** タスク内容 */
    @Column(name = "content")
    @JsonProperty("content")
    @Setter
    private String content;

    /** 完了したか */
    @Column(name = "is_done")
    @JsonProperty("is_done")
    @Setter
    private boolean isDone;

    /** データ登録日時 */
    @Column(name = "created_at")
    @JsonProperty("created_at")
    private Date createdAt;

    /** データ更新日時 */
    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonValue
    public Map<String, Object> toJson() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("content", content);
        map.put("is_done", isDone);
        map.put("created_at", createdAt);
        map.put("updated_at", updatedAt);
        return map;
    }

    @JsonCreator
    public TaskEntity(int id, String content, boolean isDone, Date createdAt, Date updatedAt) {
        this.id = id;
        this.content = content;
        this.isDone = isDone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
