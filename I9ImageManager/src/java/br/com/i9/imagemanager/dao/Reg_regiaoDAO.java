package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Reg_regiaoDAO extends ObjectDAO { 
	 public Reg_regiaoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Reg_regiaoT reg_regiaoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into i9im.reg_regiao  ( reg_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, reg_regiaoT.getReg_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Reg_regiaoT reg_regiaoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update i9im.reg_regiao set  reg_tx_nome=?  where  reg_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, reg_regiaoT.getReg_tx_nome());
			 pStmt.setObject(2, reg_regiaoT.getReg_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Reg_regiaoT reg_regiaoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from i9im.reg_regiao where  reg_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, reg_regiaoT.getReg_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Reg_regiaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Reg_regiaoT> objs = new Vector();
		 while (rs.next()) { 
 			 Reg_regiaoT reg_regiaoT = new Reg_regiaoT();
			 reg_regiaoT.setReg_nr_id(rs.getInt("reg_nr_id"));
			 reg_regiaoT.setReg_tx_nome(rs.getString("reg_tx_nome"));
			 objs.add(reg_regiaoT);
 		 }
 		 return objs; 
 	 }
	 public List<Reg_regiaoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.reg_regiao";
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Reg_regiaoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Reg_regiaoT> getByPK(Reg_regiaoT reg_regiaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.reg_regiao where  reg_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, reg_regiaoT.getReg_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Reg_regiaoT> getByReg_nr_id(Reg_regiaoT reg_regiaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.reg_regiao where  reg_nr_id = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, reg_regiaoT.getReg_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Reg_regiaoT> getByReg_tx_nome(Reg_regiaoT reg_regiaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.reg_regiao where  Upper(reg_tx_nome) like Upper(?) ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + reg_regiaoT.getReg_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 

 }