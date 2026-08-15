package dk.martinrohwedder.lottery_statistics_denmark.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(
        name = "draw_numbers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_draw_numbers",
                        columnNames = {"draw_id", "number", "is_bonus"}
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class DrawNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "draw_id", referencedColumnName = "id", nullable = false)
    private Draw draw;

    @Column(name = "number", nullable = false)
    private int number;

    @Builder.Default
    @Column(name = "is_bonus", nullable = false)
    private boolean isBonus = false;
}
