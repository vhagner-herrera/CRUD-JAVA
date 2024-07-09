package DAO;

import config.conexion;
import interfacee.personaInter;
import modelo.persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class personaDAO implements personaInter {
    Scanner sc= new Scanner(System.in);
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    private List<persona> personas = new ArrayList<>();
    private int nextId = 1;

    @Override
    public persona findById(int id) {
        persona per = new persona();
        String sql = "SELECT * FROM persona WHERE id=?";
        try {
            con= conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs= ps.executeQuery();
            while(rs.next()){
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                per.setApellidopa(rs.getString("apellidopa"));
                per.setApellidoma(rs.getString("apellidoma"));
                per.setEmail(rs.getString("email"));
                per.setSueldo(rs.getDouble("sueldo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  per;
    }

    @Override
    public List<persona> findAll() {
        List<persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                persona per = new persona();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                per.setApellidopa(rs.getString("apellidopa"));
                per.setApellidoma(rs.getString("apellidoma"));
                per.setEmail(rs.getString("email"));
                per.setSueldo(rs.getDouble("sueldo"));

                personas.add(per);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    @Override
    public void save(persona persona) {
        String sql = "INSERT INTO persona (nombre, apellidopa, apellidoma, email, sueldo) VALUES (?, ?, ?, ?, ?)";


        try{
            con=conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellidopa());
            ps.setString(3, persona.getApellidoma());
            ps.setString(4, persona.getEmail());
            ps.setDouble(5,persona.getSueldo());
            int rowsafected=ps.executeUpdate();
            if(rowsafected>0){
                System.out.println("datos agregados");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(persona persona) {
        int datos=0;

        String sql ="UPDATE persona SET nombre =?, apellidopa=?, apellidoma=?, email=?, sueldo=? WHERE id=?";
        try {
            con=conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellidopa());
            ps.setString(3, persona.getApellidoma());
            ps.setString(4, persona.getEmail());
            ps.setDouble(5,persona.getSueldo());
            ps.setInt(6,persona.getId());
            datos=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(persona persona) {
        String sql="DELETE FROM persona WHERE id=?";
        int dato=0;

        try{
            con=conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, persona.getId());
            dato=ps.executeUpdate();
            System.out.println("usuario eliminado: "+dato);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
