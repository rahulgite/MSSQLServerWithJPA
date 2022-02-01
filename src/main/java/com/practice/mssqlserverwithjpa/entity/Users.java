package com.practice.mssqlserverwithjpa.entity;

public class Users {
    private int id;

    public int getId() {
        return id;
    }
    public Users(){

    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
