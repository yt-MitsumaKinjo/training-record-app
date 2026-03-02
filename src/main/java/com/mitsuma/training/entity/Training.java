package com.mitsuma.training.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * 1日のトレーニング単位を表すエンティティ
 * users 1 : N trainings
 * trainings 1 : N training_details
 */
@Entity
@Table(name = "trainings")
public class Training {

    @Id //主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = MySQLのAUTO_INCREMENT(自動採番)
    private Long id;

    /**
     * 多対一（N側）
     * trainingsテーブルが外部キーを持つ
     * user_id カラムが生成される
     */
    @ManyToOne
    @JoinColumn(
            name = "user_id",      // カラム名
            nullable = false       // NOT NULL（必須）
    )
    private User user;

    /**
     * トレーニング日
     * MySQLでは DATE 型
     */
    @Column(nullable = false)
    private LocalDate trainingDate;

    /**
     * 開始時間
     * MySQLでは TIME 型
     */
    private LocalTime startTime;

    /**
     * 使用ジム名
     */
    @Column(length = 100)
    private String gymName;

    /**
     * メモ
     * 長文を想定でTEXT型にする
     */
    @Column(columnDefinition = "TEXT")
    private String memo;

    /**
     * trainings 1 : N training_details
     */
    @OneToMany(mappedBy = "training")
    private List<TrainingDetail> trainingDetails;


    // ===== getter / setter =====

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<TrainingDetail> getTrainingDetails() {
        return trainingDetails;
    }

    public void setTrainingDetails(List<TrainingDetail> trainingDetails) {
        this.trainingDetails = trainingDetails;
    }
}
