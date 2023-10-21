package io.getmedusa.demo.model;

import jakarta.persistence.*;

@Entity
public class DogsInHouse {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long number;
    @Enumerated(EnumType.STRING)
    private Lang lang;

    protected DogsInHouse(){}
    public DogsInHouse(String name, Lang lang, Long number) {
        this.name = name;
        this.lang = lang;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public Long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "%s has %s dogs in house with lang %s".formatted(name,number,lang);
    }
}