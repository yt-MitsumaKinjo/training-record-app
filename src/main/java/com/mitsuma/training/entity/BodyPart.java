package com.mitsuma.training.entity;

import jakarta.persistence.*;

/**
 * 部位マスタを表すエンティティ
 * 例：胸・背中・脚・肩・腕 など
 * このクラス ＝ body_parts テーブル
 */
@Entity
@Table(name = "body_parts") //テーブル名を明示
public class BodyPart {

    @Id //主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = MySQLのAUTO_INCREMENT(自動採番)
    private Long id;

    @Column(
            nullable = false,   // NOT NULL制約
            unique = true,      // 重複禁止（胸が2つは不要）
            length = 50         // VARCHAR(50)
    )
    private String name;

    // ===== getter / setter =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
