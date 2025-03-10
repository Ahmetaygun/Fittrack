package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "diet_lists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name; // Diyetin adı

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description; // Diyet hakkında açıklama

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dietitian_id", nullable = false)
    private Dietitian dietitian; // Diyeti veren diyetisyen

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client; // Diyet listesine sahip olan danışan

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diet_type_id", nullable = false)
    private DietType dietType; // Diyet tipi

    @Column(nullable = false)
    private String menu; // Diyet menüsü

    @Column(nullable = false)
    private String forbiddens;  // Yasaklar

    @Column(nullable = false)
    private LocalDateTime createdAt; // Diyetin oluşturulma tarihi

    @Column(nullable = false)
    private int duration; // Diyetin süresi (gün veya hafta)
}
