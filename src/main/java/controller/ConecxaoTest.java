package controller;

import java.sql.Connection;

public class ConecxaoTest {
    
    public static void main(String[] args) {
        //Conectar no SGBD
        Connection con = Conecxao.conectar();
        if ( con != null){
            System.out.println("Conexão realizada com sucesso!");
            Conecxao.desconectar(con);
        }
    }
}

