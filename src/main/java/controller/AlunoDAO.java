
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Aluno;
import model.Materias;


public class AlunoDAO {
 
    private final Connection con;
    
    //enviar o comando SQL para o banco
    private PreparedStatement cmd;
    
    public AlunoDAO(){
        this.con = Conecxao.conectar();
    }
       
    public int inserir(Aluno obj){
        try {
            String SQL = "insert into tb_aluno"
                       + "(cod,nome_aluno,email,endereco,cidade,telefone,cpf) values (?,?,?,?,?,?,?)";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, obj.getCod());
            cmd.setString(2, obj.getNome());
            cmd.setString(3, obj.getEmail());
            cmd.setString(4, obj.getEndereco());
            cmd.setString(5, obj.getCidade());
            cmd.setString(6, obj.getTelefone());
            cmd.setString(7, obj.getCpf());
            
            
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
    public int atualizar(Aluno obj){
        try {
            String SQL = "update tb_aluno set cod=?,nome_aluno=?,email=?,endereco=?,cidade=?,telefone=?,cpf=? where ";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, obj.getCod());
            cmd.setString(2, obj.getNome());
            cmd.setString(3, obj.getEmail());
            cmd.setString(4, obj.getEndereco());
            cmd.setString(5, obj.getCidade());
            cmd.setString(6, obj.getTelefone());
            cmd.setString(7, obj.getCpf());
   
            
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
    public Aluno pesquisarPorId(String id){
        try {
            String SQL = "select * from tb_aluno where id = ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Aluno cat = new Aluno();
                cat.setCod(rs.getInt("cod"));
                cat.setId_curso(rs.getInt("id curso"));
                cat.setNome(rs.getString("nome aluno"));
                cat.setEmail(rs.getString("email"));
                cat.setEndereco(rs.getString("endereço"));
                cat.setCidade(rs.getString("cidade"));
                cat.setTelefone(rs.getString("teelfone"));
                cat.setCpf(rs.getString("cpf"));
                
                
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
}
