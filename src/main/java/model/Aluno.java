
package model;


public class Aluno {
    
    private int cod;
    private int id_curso;
    private String nome;
    private String email;
    private String endereco;
    private String cidade;
    private String telefone;
    private String uf;
    private String cpf;
    private String semestre;
    

    public Aluno() {
    }

    public Aluno(int cod, int id_curso, String nome, String email, String endereco, String cidade, String telefone, String uf, String cpf, String semestre) {
        this.cod = cod;
        this.id_curso = id_curso;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.uf = uf;
        this.cpf = cpf;
        this.semestre = semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    

   

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

  
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

   

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
    
}
