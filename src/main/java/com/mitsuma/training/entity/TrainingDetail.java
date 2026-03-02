package com.mitsuma.training.entity;

import jakarta.persistence.*;

/**
 * 1日のトレーニング内の「種目単位」の記録 (「橋渡し」的存在)
 * trainings 1 : N training_details
 * exercises 1 : N training_details
 */
@Entity
@Table(name = "training_details") //テーブル名を明示
public class TrainingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = MySQLのAUTO_INCREMENT(自動採番)
    private Long id;

    /**
     * 多対一（N側）
     */
    @ManyToOne
    @JoinColumn(
            name = "training_id",
            nullable = false
    )
    private Training training;

    /**
     *多対一（N側）
     */
    @ManyToOne
    @JoinColumn(
            name = "exercise_id",
            nullable = false
    )
    private Exercise exercise;

    /**
     * 使用重量（kg）
     */
    private Integer weight;

    /**
     * 回数
     */
    private Integer reps;

    /**
     * セット数
     */
    private Integer sets;

    // ===== getter / setter =====

    public Long getId() {
        return id;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }
}
