///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cjava.dao.impl;
//
//import cjava.beans.Curso;
//import cjava.dao.CursoDao;
//import cjava.util.DBConn;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author emaravi
// */
//public class PreparedStatement implements CursoDao{
//    private Connection con;
//    private PreparedStatement pst;
//    private ResultSet  rs;
//      
//    @Override
//    public void create(Curso t) {
//        try {
//            String sql= "insert into curso values(?,?,?)";
//            con = DBConn.getConnection();
//            pst = con.prepareStatement(sql);
//            pst.setString(1,t.getCodigo());
//            pst.setString(2,t.getNombre());
//            pst.setInt(3,t.getCreditos());
//            pst.executeUpdate();
//            con.close();
//            System.out.println("grabo con preparedstatement");
//        } catch (SQLException ex) {
//            System.out.println("error");
//        }
//    }
//
//    @Override
//    public Curso find(Object id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Curso> findAll() {
//        List<Curso> lCurso = new ArrayList<>();
//        Curso curso;
//        try{
//           con = DBConn.getConnection();
//           pst = con.prepareStatement("select * from curso");
//           rs = pst.executeQuery();
//           while(rs.next()){
//               curso=new Curso();
//               curso.setCodigo(rs.getString(1));
//               curso.setNombre(rs.getString(2));
//               curso.setCreditos(rs.getInt(3));
//               lCurso.add(curso);
//           }
//           con.close();
//        }catch(SQLException ex){
//            System.out.println("error");
//        }
//        return lCurso;
//    }
//
//    @Override
//    public void update(Curso t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void delete(Object id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    @Override
//    public List<Curso> orderByNombre() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Curso> filterByCreditos(int min, int max) {
//        List<Curso> lCurso = new ArrayList<>();
//        Curso curso;
//        try{
//           con = DBConn.getConnection();
//           pst = con.prepareStatement("select * from curso");
//           rs = pst.executeQuery();
//           while(rs.next()){
//               curso=new Curso();
//               curso.setCodigo(rs.getString(1));
//               curso.setNombre(rs.getString(2));
//               curso.setCreditos(rs.getInt(3));
//               lCurso.add(curso);
//           }
//           con.close();
//        }catch(SQLException ex){
//            System.out.println("error");
//        }
//        
//        
//        return lCurso;
//    }
//    
//}
