package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Gru_grupoDAO extends ObjectDAO { 
	 public Gru_grupoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Gru_grupoT gru_grupoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into i9im.gru_grupo  ( gru_nr_id, ses_nr_id, gru_tx_nome) values ( ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, gru_grupoT.getGru_nr_id());
			 pStmt.setObject(2, gru_grupoT.getSes_nr_id());
			 pStmt.setObject(3, gru_grupoT.getGru_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Gru_grupoT gru_grupoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update i9im.gru_grupo set  gru_tx_nome=?  where  gru_nr_id=? and ses_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, gru_grupoT.getGru_tx_nome());
			 pStmt.setObject(2, gru_grupoT.getGru_nr_id());
			 pStmt.setObject(3, gru_grupoT.getSes_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Gru_grupoT gru_grupoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from i9im.gru_grupo where  gru_nr_id=? and ses_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, gru_grupoT.getGru_nr_id());
			 pStmt.setObject(2, gru_grupoT.getSes_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Gru_grupoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Gru_grupoT> objs = new Vector();
		 while (rs.next()) { 
 			 Gru_grupoT gru_grupoT = new Gru_grupoT();
			 gru_grupoT.setGru_nr_id(rs.getInt("gru_nr_id"));
			 gru_grupoT.setSes_nr_id(rs.getInt("ses_nr_id"));
			 gru_grupoT.setGru_tx_nome(rs.getString("gru_tx_nome"));
			 objs.add(gru_grupoT);
 		 }
 		 return objs; 
 	 }
	 public List<Gru_grupoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.gru_grupo order by gru_tx_nome";
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Gru_grupoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Gru_grupoT> getByPK(Gru_grupoT gru_grupoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.gru_grupo where  gru_nr_id=? and ses_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, gru_grupoT.getGru_nr_id());
			 pStmt.setObject(2, gru_grupoT.getSes_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Gru_grupoT> getByGru_nr_id(Gru_grupoT gru_grupoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.gru_grupo where  gru_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, gru_grupoT.getGru_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Gru_grupoT> getBySes_nr_id(Gru_grupoT gru_grupoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.gru_grupo where  ses_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, gru_grupoT.getSes_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Gru_grupoT> getByGru_tx_nome(Gru_grupoT gru_grupoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.gru_grupo where  Upper(gru_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + gru_grupoT.getGru_tx_nome()+'%' );
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
	 public List<Gru_grupoT> getBySes_sessao(Gru_grupoT gru_grupoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from i9im.gru_grupo where ses_sessao.ses_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, gru_grupoT.getSes_nr_id());
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