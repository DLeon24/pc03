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
//import cjava.util.Util;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author emaravi
// */
//public class CallableStatement implements CursoDao{
//
//    private Connection con;
//    private ResultSet  rs;
//    private CallableStatement cst;
//    
//    @Override
//    public void create(Curso t) {
//        try {
//            con = DBConn.getConnection();
//            con.setAutoCommit(false);
//            cst = con.prepareCall("{CALL sp_ins_curso(?,?,?)}");
//            cst.setString(1,t.getCodigo());
//            cst.setString(2,t.getNombre());
//            cst.setInt(3,t.getCreditos());
//            cst.executeUpdate();
//            update(null);
//            con.commit();
//            cst.close();
//            con.close();
//            System.out.println("grabo con callablestatement");
//        }catch(SQLException | NullPointerException ex){
//              try {
//                  con.rollback();
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.ERROR1);
//              }
//        }
//    }
//
//    @Override
//    public Curso find(Object id) {
//          Curso curso = null;
//        try{
//           con = DBConn.getConnection();
//           cst = con.prepareCall("{CALL sp_find_curso(?)}");
//           cst.setString(1,id.toString());
//           rs = cst.executeQuery();
//           if(rs.next()){
//               curso=new Curso();
//               curso.setCodigo(rs.getString(1));
//               curso.setNombre(rs.getString(2));
//               curso.setCreditos(3);
//           }
//            rs.close();
//            cst.close();
//            con.close();
//        }catch(SQLException ex){
//              try {
//                  rs.close();
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.ERROR1);
//              }
//        }
//        return curso;
//    }
//
//    @Override
//    public List<Curso> findAll() {
//        List<Curso> lCurso = new ArrayList<>();
//        Curso curso;
//        try {
//            con = DBConn.getConnection();
//            cst = con.prepareCall("{CALL sp_findAll_curso()}");
//            rs = cst.executeQuery();
//             while(rs.next()){
//               curso=new Curso();
//               curso.setCodigo(rs.getString(1));
//               curso.setNombre(rs.getString(2));
//               curso.setCreditos(3);
//               lCurso.add(curso);
//           }rs.close();
//            cst.close();
//            con.close();
//        }catch(SQLException ex){
//              try {
//                  rs.close();
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.ERROR1);
//              }
//        }
//        return lCurso;
//    }
//
//    @Override
//    public void update(Curso t) {
//        try {
//            con = DBConn.getConnection();
//            cst = con.prepareCall("{CALL sp_upd_curso(?,?,?)}");
//            cst.setString(1,t.getNombre());
//            cst.setInt(2,t.getCreditos());
//            cst.setString(3,t.getCodigo());
//            cst.executeUpdate();
//            cst.close();
//            con.close();
//        }catch(SQLException ex){
//              try {
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.ERROR1);
//              }
//        }
//    }
//
//    @Override
//    public void delete(Object id) {
//        try {
//            con = DBConn.getConnection();
//            cst = con.prepareCall("{CALL sp_del_curso(?)}");
//            cst.setString(1,id.toString());
//            cst.executeUpdate();
//            cst.close();
//            con.close();
//        }catch(SQLException ex){
//              try {
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.ERROR1);
//              }
//        }
//    }
//        @Override
//    public List<Curso> orderByNombre() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Curso> filterByCreditos(int min, int max) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
