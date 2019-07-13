//package cjava.dao.impl;
//
//import cjava.beans.DistritoTO;
//import cjava.service.DistritoService;
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
//public class DistritoCSTDAO implements DistritoService{
//    
//    private Connection con;
//    private ResultSet  rs;
//    private CallableStatement cst;
//    
//    @Override
//    public int crearDistrito(DistritoTO distrito) {
//        int filas=0;
//        try {
//            con = DBConn.getConnection();
//            cst = con.prepareCall("{CALL ins_distrito(?,?,?)}");
//            cst.setString(1,distrito.getCodigo());
//            cst.setString(2,distrito.getNombre());
//            cst.setString(3,distrito.getVendendor());
//            filas = cst.executeUpdate();
//            cst.close();
//            con.close();
//            System.out.println("grabo con callablestatement");
//        }catch(SQLException ex){
//              try {
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.error1);
//              }
//        }
//        
//        return filas;
//    }
//
//    @Override
//    public int eliminarDistrito(String codigo) {
//        int filas=0;
//        try {
//            con = DBConn.getConnection();
//            cst = con.prepareCall("{CALL del_distrito(?)}");
//            cst.setString(1,codigo);
//            filas = cst.executeUpdate();
//            cst.close();
//            con.close();
//        }catch(SQLException ex){
//              try {
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.error1);
//              }
//        }
//        
//        return filas;
//    }
//
//    @Override
//    public int actualizarDistrito(DistritoTO distrito) {
//        int filas=0;
//        try {
//            con = DBConn.getConnection();
//            cst = con.prepareCall("{CALL upd_distrito(?,?,?)}");
//            cst.setString(1,distrito.getNombre());
//            cst.setString(2,distrito.getVendendor());
//            cst.setString(3,distrito.getCodigo());
//            filas = cst.executeUpdate();
//            cst.close();
//            con.close();
//        }catch(SQLException ex){
//              try {
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.error1);
//              }
//        }
//        
//        return filas;
//    }
//
//    @Override
//    public List<DistritoTO> obtenerDistritos() {
//        List<DistritoTO> lDistrito = new ArrayList<>();
//        DistritoTO distrito;
//        try {
//            con = DBConn.getConnection();
//            cst = con.prepareCall("{CALL findAll_distrito()}");
//            rs = cst.executeQuery();
//             while(rs.next()){
//               distrito=new DistritoTO();
//               distrito.setCodigo(rs.getString(1));
//               distrito.setNombre(rs.getString(2));
//               distrito.setVendendor(rs.getString(3));
//               lDistrito.add(distrito);
//           }rs.close();
//            cst.close();
//            con.close();
//        }catch(SQLException ex){
//              try {
//                  rs.close();
//                  cst.close();
//                  con.close();
//              } catch (SQLException ex1) {
//                  System.out.println(Util.error1);
//              }
//        }
//        return lDistrito;
//    }
//
//    @Override
//    public DistritoTO buscarDistrito(String codigo) {
//          DistritoTO distrito = null;
//        try{
//           con = DBConn.getConnection();
//           cst = con.prepareCall("{CALL find_distrito(?)}");
//           cst.setString(1,codigo);
//           rs = cst.executeQuery();
//           if(rs.next()){
//               distrito=new DistritoTO();
//               distrito.setCodigo(rs.getString(1));
//               distrito.setNombre(rs.getString(2));
//               distrito.setVendendor(rs.getString(3));
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
//                  System.out.println(Util.error1);
//              }
//        }
//        return distrito;
//        
//    }
//    
//}
