
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Materias;


public class MateriasDAO {
    
    
    private final Connection con;
    
    //enviar o comando SQL para o banco
    private PreparedStatement cmd;
    
    public MateriasDAO(){
        this.con = Conecxao.conectar();
    }
       
    public int inserir(Materias obj){
        try {
            String SQL = "insert into tb_disciplina "
                       + "(nome_materia,carga_horaria) values (?,?)";
            
            cmd = con.prepareStatement(SQL);
            //cmd.setInt(1, obj.getId_materia());
            cmd.setString(1, obj.getNome_materia());
            cmd.setString(2, obj.getCarga_horaria());
                        
            
            
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
    
    public int atualizar(Materias obj){
        try {
            String SQL = "update tb_disciplina set id=?, nome_materia=?, carga_horaria=? where ";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1,obj.getId());
            cmd.setString(2, obj.getNome_materia());
            cmd.setString(3, obj.getCarga_horaria());
            
            
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
    
    public List<Materias> listar(){
        try {
            String SQL = "select * from tb_disciplina";
            cmd = con.prepareStatement(SQL);
            
            //executar a consulta
            List<Materias> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Materias cli = new Materias();
                cli.setId(rs.getInt("id"));
                cli.setNome_materia(rs.getString("nome_materia"));
                cli.setCarga_horaria(rs.getString("carga_horaria"));
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
    
    
    public Materias pesquisarPorId(String id){
        try {
            String SQL = "select * from tb_disciplina where id = ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Materias cat = new Materias();
                cat.setId(rs.getInt("id"));
                cat.setNome_materia(rs.getString("nome_disciplina"));
                cat.setCarga_horaria(rs.getString("carga_horaria"));
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
    public List<Materias> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_disciplina where nome_disciplina ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1,"%" +nome+ "%");
            
            //executar a consulta
            List<Materias> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Materias cli = new Materias();
                cli.setId(rs.getInt("id"));
                cli.setNome_materia(rs.getString("nome_disciplina"));
                cli.setCarga_horaria(rs.getString("carga_horaria"));
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
    

