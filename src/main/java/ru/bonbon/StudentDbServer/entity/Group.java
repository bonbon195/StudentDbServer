package ru.bonbon.StudentDbServer.entity;

public class Group {
    private int id;

    private String name;
    private int id_faculty;

    public int getId() {
        return id;
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

    public int getIdFaculty() {
        return id_faculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.id_faculty = idFaculty;
    }
}
