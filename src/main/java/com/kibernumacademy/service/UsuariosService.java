package com.kibernumacademy.service;

import com.kibernumacademy.conexion.DBConnection;
import com.kibernumacademy.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuariosService {
    
    Connection conn;
    public List<Usuario> findAllUsers() {
        List<Usuario> usuarios = new ArrayList<>();
        DBConnection conexion = new DBConnection();
        
        String sql = "SELECT * FROM Usuarios";
        
        try  {
        	conn = conexion.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int estatus = rs.getInt("estatus");
                Date fechaRegistro = rs.getDate("fechaRegistro");
                
                Usuario usuario = new Usuario(id, nombre, email, username, password, estatus, fechaRegistro);
                usuarios.add(usuario);
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // It's better to log the exception rather than using printStackTrace
        }
        return usuarios;
    }
}
