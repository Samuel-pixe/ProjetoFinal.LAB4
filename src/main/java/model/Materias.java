
package model;


public class Materias {

private int id;
private String nome_materia;
private String carga_horaria;

    public Materias() {
    }

    public Materias(int id, String nome_materia, String carga_horaria) {
        this.id = id;
        this.nome_materia = nome_materia;
        this.carga_horaria = carga_horaria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_materia() {
        return nome_materia;
    }

    public void setNome_materia(String nome_materia) {
        this.nome_materia = nome_materia;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }



}
