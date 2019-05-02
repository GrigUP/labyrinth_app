package ru.grig.labyrinth_app.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "labyrinth")
public class Labyrinth extends AbstractEntity {

    @Column(name = "labyrinth_name", nullable = false)
    private String name;

    @Column(name = "route_color", nullable = false)
    private String routeColor;

    @Column(name = "wall_color", nullable = false)
    private String wallColor;

    @Column(nullable = false)
    private Integer x;

    @Column(nullable = false)
    private Integer y;

    @Column(nullable = false)
    private String map;

    @OneToMany(mappedBy = "labyrinth")
    @JsonIgnore
    private Set<Robot> robot;

    public Labyrinth() {
    }

    public Labyrinth(String name, String routeColor, String wallColor, Integer x, Integer y, String map) {
        this.name = name;
        this.routeColor = routeColor;
        this.wallColor = wallColor;
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public String getWallColor() {
        return wallColor;
    }

    public void setWallColor(String wallColor) {
        this.wallColor = wallColor;
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

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Set<Robot> getRobot() {
        return robot;
    }

    public void setRobot(Set<Robot> robot) {
        this.robot = robot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Labyrinth)) return false;
        if (!super.equals(o)) return false;
        Labyrinth labyrinth = (Labyrinth) o;
        return Objects.equals(name, labyrinth.name) &&
                Objects.equals(routeColor, labyrinth.routeColor) &&
                Objects.equals(wallColor, labyrinth.wallColor) &&
                Objects.equals(x, labyrinth.x) &&
                Objects.equals(y, labyrinth.y) &&
                Objects.equals(map, labyrinth.map) &&
                Objects.equals(robot, labyrinth.robot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, routeColor, wallColor, x, y, map, robot);
    }
}
