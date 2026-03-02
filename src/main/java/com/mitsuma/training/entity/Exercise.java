package com.mitsuma.training.entity;

import jakarta.persistence.*;

/**
 * 種目マスタを表すエンティティ
 * 例：ベンチプレス、スクワット、デッドリフトなど
 * このクラス ＝ exercises テーブル
 */
@Entity
@Table(name = "exercises") //テーブル名を明示
public class Exercise {

    @Id //主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = MySQLのAUTO_INCREMENT(自動採番)
    private Long id;

    @Column(
            nullable = false, // NOT NULL制約
            length = 100      // VARCHAR(100)
    )
    private String name;

    /**
     * この種目が属する部位
     * 例：ベンチプレス → 胸
     */
    @ManyToOne //多対一の関係を表す
    @JoinColumn(
            name = "body_part_id", // カラム名
            nullable = false       // NOT NULL制約
    )
    private BodyPart bodyPart;

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

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }
}
