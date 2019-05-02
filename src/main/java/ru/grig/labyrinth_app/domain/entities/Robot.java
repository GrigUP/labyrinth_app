package ru.grig.labyrinth_app.domain.entities;

import javax.persistence.*;

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
    @JoinColumn(name = "column_id", referencedColumnName = "id")
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
}
