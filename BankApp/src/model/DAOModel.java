package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOModel 
{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	private int accno;
	private int custid;
	private String cname;
	private int balance;
	private String password;
	private String email;
	
	public int getAccno() 
	{
		return accno;
	}
	public void setAccno(int accno) 
	{
		this.accno = accno;
	}
	public int getCustid() 
	{
		return custid;
	}
	public void setCustid(int custid)
	{
		this.custid = custid;
	}
	public String getCname() 
	{
		return cname;
	}
	public void setCname(String cname) 
	{
		this.cname = cname;
	}
	public int getBalance() 
	{
		return balance;
	}
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public DAOModel()
	{
		DBConnector dbc=new DBConnector();
		con=dbc.giveConnection();
	}
	
	public boolean login()
	{
		try
		{
			pstmt=con.prepareStatement("SELECT * FROM BANK_PROJECT WHERE CUSTOMER_ID=? AND PASSWORD=?");
			pstmt.setInt(1,custid);
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			
			if(res==null)
			{
				return false;
			}
			else
			{
				while(res.next()==true)
				{
					accno=res.getInt("ACCOUNT_NO");
					cname=res.getString("CUSTOMER_ID");
					return true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean checkBalance()
	{
		try
		{
			pstmt=con.prepareStatement("SELECT BALANCE FROM BANK_PROJECT WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			
			if(res==null)
			{
				return false;
			}
			else
			{
				//to get the balance value from dao to session
				while(res.next()==true)
				{
					res.getInt("BALANCE");
					return true;
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean fundTransfer(int amount)
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE BANK_PROJECT SET BALANCE=BALANCE-? WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, amount);
			pstmt.setInt(2, accno);
			int num=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("INSERT INTO FM_FUND_TRANSFER VALUES(?,?)" );
			pstmt.setInt(1,amount);
			pstmt.setInt(2, accno);
			pstmt.executeUpdate();
			
			if(num==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean changePassword(String npw)
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE BANK_PROJECT SET PASSWORD=? WHERE ACCOUNT_NO=? AND PASSWORD=?");
			pstmt.setString(1, npw);
			pstmt.setInt(2, accno);
			pstmt.setString(3, password);
			int num=pstmt.executeUpdate();
			
			if(num>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	public ArrayList getStatement() 
	{
		ArrayList al=new ArrayList();
		try
		{
			pstmt=con.prepareStatement("SELECT * FROM FM_FUND_TRANSFER WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				al.add(res.getInt("ACCNO"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean homeLoan(int amount,String addr,String type,int income,String city,String state)
	{
		try
		{
			pstmt=con.prepareStatement("INSERT INTO HOME_LOAN VALUES(?,?,?,?,?,?)");
			pstmt.setInt(1, amount);
			pstmt.setString(2, addr);
			pstmt.setString(3,type);
			pstmt.setInt(4, income);
			pstmt.setString(5, city);
			pstmt.setString(6, state);
			
			res=pstmt.executeQuery();
			
			if(res==null)
			{
				return false;
			}
			else
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean resetPassword()
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE BANK_PROJECT SET PASSWORD=? WHERE EMAIL=?");
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			int num=pstmt.executeUpdate();
			
			if(num==0) 
			{
				return false;
			}
			else
				
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
}
