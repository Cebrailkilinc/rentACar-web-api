package restApiProject.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cars")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="plate")
    private String plate;

    @Column(name="modelYear")
    private String modelYear;

    @Column(name="dailyPrice")
    private int dailyPrice;

    @Column(name="state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
