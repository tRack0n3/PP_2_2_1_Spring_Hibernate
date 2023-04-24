package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "model")
    private String model;

    @Column (name = "series")
    private int series;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private User user;


    public Car() {}


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public User setUser(User user) {
        this.user = user;
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
