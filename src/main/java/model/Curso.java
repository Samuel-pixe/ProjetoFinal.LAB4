
package model;


public class Curso {
    private int id;
    private String nome_curso;
    private String duracao_curso;
    private String nota_curso;

    public Curso() {
    }

    public Curso(int id, String nome_curso, String duracao_curso, String nota_curso) {
        this.id = id;
        this.nome_curso = nome_curso;
        this.duracao_curso = duracao_curso;
        this.nota_curso = nota_curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getDuracao_curso() {
        return duracao_curso;
    }

    public void setDuracao_curso(String duracao_curso) {
        this.duracao_curso = duracao_curso;
    }

    public String getNota_curso() {
        return nota_curso;
    }

    public void setNota_curso(String nota_curso) {
        this.nota_curso = nota_curso;
    }
    
    
    
    
}
