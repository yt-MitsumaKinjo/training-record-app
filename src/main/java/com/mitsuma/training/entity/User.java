package com.mitsuma.training.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ユーザー情報を管理するエンティティ
 * このクラス ＝ usersテーブル
 * 役割：
 * ・ログインユーザーの管理
 * ・トレーニング記録の所有者
 */
@Entity
@Table(name = "users") //テーブル名を明示
public class User {

    @Id //主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = MySQLのAUTO_INCREMENT(自動採番)
    private Long id;

    @Column(
            nullable = false,  // NOT NULL
            unique = true,     // 重複不可（ログインIDは一意）
            length = 50        // VARCHAR(50)
    )
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime createdAt; //MySQLでは DATETIME 型になる

    /**
     * ユーザーが持つトレーニング一覧
     * users 1 : N trainings の関係
     * mappedBy = "user"
     * → Trainingエンティティ側の
     *   private User user;
     *   を参照している
     */
    @OneToMany(mappedBy = "user")
    private List<Training> trainings;

    // ===== getter / setter =====

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
