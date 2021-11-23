
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import java.sql.ResultSet;
import model.Curso;


public class CursoDAO {
    
    //estabelecer a conexão com o banco
    private final Connection con;
    
    //enviar o comando SQL para o banco
    private PreparedStatement cmd;
    
    public CursoDAO(){
        this.con = Conecxao.conectar();
    }
    public int inserir(Curso obj){
        try {
            String SQL = "insert into tb_curso "
                       + "(nome_curso,duracao_curso,nota_curso) values (?,?,?)";
            
            cmd = con.prepareStatement(SQL);
            //cmd.setInt(1, obj.getId_materia());
            cmd.setString(1, obj.getNome_curso());
            cmd.setString(2, obj.getDuracao_curso());
            cmd.setString(3, obj.getNota_curso());
                        
            
            
            if (cmd.executeUpdate() > 0){
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next()? rs.getInt(1) : 1;   //OK
            }else{
                return -1;  // ERRO
            }
            
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conecxao.desconectar(con);
        }
    }
    
    
    public List<Curso> listar(){
        try {
            String SQL = "select * from tb_curso";
            cmd = con.prepareStatement(SQL);
            
            //executar a consulta
            List<Curso> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Curso cli = new Curso();
                cli.setId(rs.getInt("id"));
                cli.setNome_curso(rs.getString("Nome_curso"));
                cli.setDuracao_curso(rs.getString("Duracao_curso"));
                cli.setNota_curso(rs.getString("Nota_curso"));
                lista.add(cli);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conecxao.desconectar(con);
        }
    }
    public Curso pesquisarPorId(String id){
        try {
            String SQL = "select * from tb_curso where id = ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Curso cat = new Curso();
                cat.setId(rs.getInt("id"));
                cat.setNome_curso(rs.getString("Nome disciplina"));
                cat.setDuracao_curso(rs.getString("Carga horaria"));
                cat.setNota_curso(rs.getString("Nota MEC"));
                return cat;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conecxao.desconectar(con);
        }
    }
    public int atualizar(Curso obj){
        try {
            String SQL = "update tb_curso set id=?, nome_curso=?, duracao_curso=?, where ";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1,obj.getId());
            cmd.setString(2, obj.getNome_curso());
            cmd.setString(3, obj.getDuracao_curso());
            cmd.setString(4, obj.getNota_curso());
            
            
            //envia a instrução SQL para o banco
            if (cmd.executeUpdate() > 0){
                //operação realizada com sucesso
                return 1;   //OK
            }else{
                return -1;  // ERRO
            }
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conecxao.desconectar(con);
        }
    }
    public List<Curso> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_curso where nome_curso ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1,"%" +nome+ "%");
            
            //executar a consulta
            List<Curso> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Curso cli = new Curso();
                cli.setId(rs.getInt("identificador do curso"));
                cli.setNome_curso(rs.getString("Nome da Disciplina"));
                cli.setDuracao_curso(rs.getString("Duração do curso"));
                cli.setNota_curso("Nota do curso MEC");
                lista.add(cli);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conecxao.desconectar(con);
        }
    }
    
}
