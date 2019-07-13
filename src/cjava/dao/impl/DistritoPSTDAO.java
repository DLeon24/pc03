//package cjava.dao.impl;
//
//import cjava.beans.DistritoTO;
//import cjava.service.DistritoService;
//import cjava.util.DBConn;
//import cjava.util.Util;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class DistritoPSTDAO implements DistritoService {
//    private Connection con;
//    private PreparedStatement pst;
//    private ResultSet  rs;
//    
//    @Override
//    public int crearDistrito(DistritoTO distrito) {
//        int filas=0;
//        try {
//            String sql= "insert into tb_distrito values(?,?,?)";
//            con = DBConn.getConnection();
//            pst = con.prepareStatement(sql);
//            pst.setString(1,distrito.getCodigo());
//            pst.setString(2,distrito.getNombre());
//            pst.setString(3,distrito.getVendendor());
//            filas = pst.executeUpdate();
//            con.close();
//            System.out.println("grabo con preparedstatement");
//        } catch (SQLException ex) {
//             System.out.println(Util.error1);
//        }
//        return filas;
//    }
//
//    @Override
//    public int eliminarDistrito(String codigo) {
//        int filas=0;
//        try {
//            String sql= "delete from tb_distrito where cod_dis=?";
//            con = DBConn.getConnection();
//            pst = con.prepareStatement(sql);
//            pst.setString(1,codigo);
//            filas = pst.executeUpdate();
//        } catch (SQLException ex) {
//             System.out.println(Util.error1);
//        }
//        return filas;
//    }
//
//    @Override
//    public int actualizarDistrito(DistritoTO distrito) {
//        int filas=0;
//        try {
//            String sql=  "update tb_distrito set nom_dis=?, cod_ven=? where cod_dis=?";
//            con = DBConn.getConnection();
//            pst = con.prepareStatement(sql);
//            pst.setString(1,distrito.getNombre());
//            pst.setString(2,distrito.getVendendor());
//            pst.setString(3,distrito.getCodigo());
//            filas = pst.executeUpdate();
//        } catch (SQLException ex) {
//             System.out.println(Util.error1);
//        }
//        return filas;
//    }
//
//    @Override
//    public List<DistritoTO> obtenerDistritos() {
//        List<DistritoTO> lDistrito = new ArrayList<>();
//        DistritoTO distrito;
//        try{
//           con = DBConn.getConnection();
//           pst = con.prepareStatement("select * from tb_distrito");
//           rs = pst.executeQuery();
//           while(rs.next()){
//               distrito=new DistritoTO();
//               distrito.setCodigo(rs.getString(1));
//               distrito.setNombre(rs.getString(2));
//               distrito.setVendendor(rs.getString(3));
//               lDistrito.add(distrito);
//           }
//           con.close();
//        }catch(SQLException ex){
//            System.out.println(Util.error1);
//        }
//        return lDistrito;
//    }
//
//    @Override
//    public DistritoTO buscarDistrito(String codigo) {
//         DistritoTO distrito = null;
//        try{
//           con = DBConn.getConnection();
//           pst = con.prepareStatement("select * from tb_distrito where cod_dis=?");
//           pst.setString(1,codigo);
//           rs = pst.executeQuery();
//           if(rs.next()){
//               distrito=new DistritoTO();
//               distrito.setCodigo(rs.getString(1));
//               distrito.setNombre(rs.getString(2));
//               distrito.setVendendor(rs.getString(3));
//           }
//           con.close();
//        }catch(SQLException ex){
//            System.out.println(Util.error1);
//        }
//        return distrito;
//        
//    }
//    
//}
