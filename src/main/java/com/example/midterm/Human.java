package com.example.midterm;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "people")
public class Human {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "human_id")
    private Long humanId;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "sex")
    private String sex;

    @Override
    public String toString() {
        return "Human{" +
                "humanId=" + humanId +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
