package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Obe_observacaoexclusaoDAO extends ObjectDAO { 
	 public Obe_observacaoexclusaoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Obe_observacaoexclusaoT obe_observacaoexclusaoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into i9im.obe_observacaoexclusao  ( arq_nr_id, cd_produto, obe_tx_texto) values ( ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obe_observacaoexclusaoT.getArq_nr_id());
			 pStmt.setObject(2, obe_observacaoexclusaoT.getCd_produto());
			 pStmt.setObject(3, obe_observacaoexclusaoT.getObe_tx_texto());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Obe_observacaoexclusaoT obe_observacaoexclusaoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update i9im.obe_observacaoexclusao set  obe_tx_texto=?  where  arq_nr_id=? and obe_nr_id=? and cd_produto=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obe_observacaoexclusaoT.getObe_tx_texto());
			 pStmt.setObject(2, obe_observacaoexclusaoT.getArq_nr_id());
			 pStmt.setObject(3, obe_observacaoexclusaoT.getObe_nr_id());
			 pStmt.setObject(4, obe_observacaoexclusaoT.getCd_produto());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Obe_observacaoexclusaoT obe_observacaoexclusaoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from i9im.obe_observacaoexclusao where  arq_nr_id=? and obe_nr_id=? and cd_produto=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obe_observacaoexclusaoT.getArq_nr_id());
			 pStmt.setObject(2, obe_observacaoexclusaoT.getObe_nr_id());
			 pStmt.setObject(3, obe_observacaoexclusaoT.getCd_produto());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Obe_observacaoexclusaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Obe_observacaoexclusaoT> objs = new Vector();
		 while (rs.next()) { 
 			 Obe_observacaoexclusaoT obe_observacaoexclusaoT = new Obe_observacaoexclusaoT();
			 obe_observacaoexclusaoT.setArq_nr_id(rs.getInt("arq_nr_id"));
			 obe_observacaoexclusaoT.setObe_nr_id(rs.getInt("obe_nr_id"));
			 obe_observacaoexclusaoT.setCd_produto(rs.getInt("cd_produto"));
			 obe_observacaoexclusaoT.setObe_tx_texto(rs.getString("obe_tx_texto"));
			 objs.add(obe_observacaoexclusaoT);
 		 }
 		 return objs; 
 	 }
	 public List<Obe_observacaoexclusaoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.obe_observacaoexclusao"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Obe_observacaoexclusaoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Obe_observacaoexclusaoT> getByPK(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.obe_observacaoexclusao where  arq_nr_id=? and obe_nr_id=? and cd_produto=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obe_observacaoexclusaoT.getArq_nr_id());
			 pStmt.setObject(2, obe_observacaoexclusaoT.getObe_nr_id());
			 pStmt.setObject(3, obe_observacaoexclusaoT.getCd_produto());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Obe_observacaoexclusaoT> getByArq_nr_id(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.obe_observacaoexclusao where  arq_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obe_observacaoexclusaoT.getArq_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Obe_observacaoexclusaoT> getByObe_nr_id(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.obe_observacaoexclusao where  obe_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obe_observacaoexclusaoT.getObe_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Obe_observacaoexclusaoT> getByCd_produto(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.obe_observacaoexclusao where  cd_produto = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obe_observacaoexclusaoT.getCd_produto());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Obe_observacaoexclusaoT> getByObe_tx_texto(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.obe_observacaoexclusao where  Upper(obe_tx_texto) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + obe_observacaoexclusaoT.getObe_tx_texto()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
	/** M�todos FK */
	 public List<Obe_observacaoexclusaoT> getByArq_arquivo(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.obe_observacaoexclusao where arq_arquivo.arq_nr_id=? and arq_arquivo.cd_produto=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, obe_observacaoexclusaoT.getArq_nr_id());
		 pStmt.setObject(2, obe_observacaoexclusaoT.getCd_produto());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
 }