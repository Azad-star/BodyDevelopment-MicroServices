package com.yusuf.WorkOutNutritionService.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workout_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Boolean isRestDay; 

    // Bu seans (gün) hangi genel programa ait?
    @ManyToOne
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlan;

    // Seansın Adı (Örn: "1. Gün: İtme (Push)", "Sırt ve Biceps")
    @Column(nullable = false)
    private String sessionName;

    // Haftanın kaçıncı günü yapılmalı? (Örn: 1, 2, 3...)
    private Integer dayNumber;


    // Bir seansın (günün) içinde birden fazla egzersiz (Exercise) olur.
    // Ancak daha önce Exercise sınıfını sadece "hareketler sözlüğü" gibi bağımsız kurmuştuk.
    // İlişkiyi sağlamak için araya @ManyToMany kurmalıyız.
 
    // @ManyToMany YERİNE AŞAĞIDAKİNİ KULLAN:
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "session_id") // Egzersiz tablosuna session_id kolonu ekler
    private List<Exercise> exercises;
    
    
    
    
}


