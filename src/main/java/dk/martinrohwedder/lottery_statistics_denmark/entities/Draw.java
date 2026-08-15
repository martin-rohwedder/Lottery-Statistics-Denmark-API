package dk.martinrohwedder.lottery_statistics_denmark.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(
        name = "draws",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_year_week",
                        columnNames = {"year", "week_number"}
                )
        }
)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Draw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "draw_date", nullable = false)
    private LocalDate date;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "week_number", nullable = false)
    private int weekNumber;

    @Builder.Default
    @OneToMany(mappedBy = "draw", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DrawNumber> numbers = new ArrayList<>();

    // Helper method
    public void addNumber(DrawNumber number) {
        numbers.add(number);
        number.setDraw(this);
    }
}
