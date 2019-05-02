package ru.grig.labyrinth_app.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "robot")
public class Robot extends AbstractEntity {

    @Column(name = "robot_name", nullable = false)
    private String name;

    @Column
    private String color;

    @Column(nullable = false)
    private Integer x;

    @Column(nullable = false)
    private Integer y;

    @ManyToOne
    @JoinColumn(name = "labyrinth_id", referencedColumnName = "id")
    private Labyrinth labyrinth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;
        if (!super.equals(o)) return false;
        Robot robot = (Robot) o;
        return Objects.equals(name, robot.name) &&
                Objects.equals(color, robot.color) &&
                Objects.equals(x, robot.x) &&
                Objects.equals(y, robot.y) &&
                Objects.equals(labyrinth, robot.labyrinth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, color, x, y, labyrinth);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", labyrinth=" + labyrinth +
                '}';
    }
}
