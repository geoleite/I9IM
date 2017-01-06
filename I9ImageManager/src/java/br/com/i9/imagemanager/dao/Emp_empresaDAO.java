package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Emp_empresaDAO extends ObjectDAO { 
	 public Emp_empresaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Emp_empresaT emp_empresaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into i9im.emp_empresa  ( emp_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, emp_empresaT.getEmp_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Emp_empresaT emp_empresaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update i9im.emp_empresa set  emp_tx_nome=?  where  emp_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, emp_empresaT.getEmp_tx_nome());
			 pStmt.setObject(2, emp_empresaT.getEmp_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Emp_empresaT emp_empresaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from i9im.emp_empresa where  emp_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, emp_empresaT.getEmp_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Emp_empresaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Emp_empresaT> objs = new Vector();
		 while (rs.next()) { 
 			 Emp_empresaT emp_empresaT = new Emp_empresaT();
			 emp_empresaT.setEmp_nr_id(rs.getInt("emp_nr_id"));
			 emp_empresaT.setEmp_tx_nome(rs.getString("emp_tx_nome"));
			 objs.add(emp_empresaT);
 		 }
 		 return objs; 
 	 }
	 public List<Emp_empresaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.emp_empresa"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Emp_empresaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Emp_empresaT> getByPK(Emp_empresaT emp_empresaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.emp_empresa where  emp_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, emp_empresaT.getEmp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Emp_empresaT> getByEmp_nr_id(Emp_empresaT emp_empresaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.emp_empresa where  emp_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, emp_empresaT.getEmp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Emp_empresaT> getByEmp_tx_nome(Emp_empresaT emp_empresaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.emp_empresa where  Upper(emp_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + emp_empresaT.getEmp_tx_nome()+'%' );
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