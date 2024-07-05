package com.echiba1.todo.entity;

import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity {
    /** タスクID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** タスク内容 */
    @Column(name = "title")
    private String title;

    public BookEntity(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
