
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;


public class UsuarioDAO {
 
    private Connection con;
    private PreparedStatement cmd;
    
    public UsuarioDAO(){
    this.con = Conecxao.conectar();
    }
     public boolean login(Usuario u){
        try {
            
            String SQL="select * from tb_usuario where "
                    + "usuario=? and senha=md5(?)";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getUsuario());
            cmd.setString(2, u.getSenha());
           
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return false;
        }
    }
     
     public int inserir(Usuario obj){
        try {
            String SQL = "insert into tb_funcionario "
                       + "(id,usuario,senha) values (?,?,?)";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, obj.getId());
            cmd.setString(2, obj.getUsuario());
            cmd.setString(3, obj.getSenha());
                        
            
            
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
    
}
/*
public boolean Login(Usuario u){
    try {
        String SQL ="select * from tb_usuario" +
                        "where usuario=? and senha=md5(?)";
        cmd = con.prepareStatement(SQL);
        cmd.setString(1,u.getUsuario());
        cmd.setString(2,u.getSenha());
        
        ResultSet rs = cmd.executeQuery();
        if(rs.next()){
            return true;
        }else{
            return false;
        }
        
      //if(cmd.executeUpdate()>0){return true
       // }else
    //return true;
    }catch(Exception e){
    System.err.println("ERRO: " + e.getMessage());
    return false;
    }
   }
*/