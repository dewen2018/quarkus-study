package com.dewen.entity;

import javax.persistence.*;

@Entity
@Table(name = "known_fruits")
// 增加了一个自定义SQL，名为Fruits.findAll
@NamedQuery(name = "Fruits.findAll", query = "SELECT f FROM Fruit f ORDER BY f.name", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
// 缓存
@Cacheable(value = true)
public class Fruit {

    // 注解SequenceGenerator定义了known_fruits的自增主键的信息，初始值是10，也就是说通过当前应用新增的第一条记录，ID等于10
    @Id
    @SequenceGenerator(name = "fruitsSequence", sequenceName = "known_fruits_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "fruitsSequence")
    private Integer id;

    @Column(length = 40, unique = true)
    private String name;

    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
