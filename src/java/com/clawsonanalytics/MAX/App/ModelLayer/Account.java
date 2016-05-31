/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer;
import com.clawsonanalytics.MAX.App.ModelLayer.UserList;
import com.clawsonanalytics.MAX.App.ModelLayer.Interface.IValidatable;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.MySQLManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public class Account extends SQLModel {
    
    // member variables
    // static variables
    private static String tablename = "ACCOUNTS";
    private static String modelname = "Account";
    
    // non-static variables
    private int manager_id;
    private String name;
    private Date creation_date;
    private Date close_date;
    
    private User manager;
    private UserList userList;
    // Constructor
    public Account(){
        //this.setManager(managerID);
        //this.setManager(managerID);
        this.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
        

        
    }
    public static Account GetByID(int id){
        List<Account> allAccounts = Account.GetAll();
        for (Account account : allAccounts){
            if (account.getID() == id){
                return account;
            }
        }
        
        return null;
        
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    public void setManager(int managerID){
        this.manager_id = managerID;
        this.LoadManager();
    }
    
    public int getManagerID(){
        return this.manager_id;
    }
    
    public void LoadManager(){
        try{
            manager = User.GetByID(this.manager_id);
        }catch(Exception e){
            manager = null;
        }
        
    }
    
    public void setManager(User _manager){
        this.manager = _manager;
    }
    public User Manager(){
        return manager;
    }
    
    public void setName(String string){
        this.name = string;
    }
    
    public String getName(){
        return this.name;
    }
    private void setCreationDate(Date date){
        this.creation_date = date;
    }
    public Date getCreationDate(){
        return this.creation_date;
    }
    
    public void setCloseDate(Date date){
        this.close_date = date;
    }
    
    public Date getCloseDate(){
        return this.close_date;
    }
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        
        if (this.getName() == null){
            _validationErrors.add("Account must have a name.");
        }
        
        return _validationErrors;
    }
    public static int Count(){
        int count = 0;
        ResultSet results;
        Statement statement;
        String selectString = "SELECT * FROM " + Account.getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        
        //mysqlManager.PrepareStatement(selectString);
        try{
            statement = mysqlManager.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            
            while(results.next()){
                count = count+1;
            }
            
        }catch(SQLException e){
            
        }
        return count;
    }
    
    public static List<Account> GetAll(){
        List<Account> allAccounts = new ArrayList<Account>();
        String selectString = "SELECT * FROM " + Account.getTablename() +";";
        MySQLManager mysql = new MySQLManager();
        Statement statement;
        ResultSet results;
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while(results.next()){
                Account newAccount = MapRowToObject(results);
                allAccounts.add(newAccount);
            }
        }catch(SQLException e){
            
            
        }
        return allAccounts;
    }
    
    private static Account MapRowToObject(ResultSet result){
        Account newAccount = new Account();
        try{
            newAccount.setID(result.getInt("id"));
            newAccount.setManager(result.getInt("manager_id"));
            newAccount.setName(result.getString("name"));
            newAccount.setCreationDate(result.getDate("creation_date"));
            newAccount.setCloseDate(result.getDate("close_date"));
        }catch(SQLException e){
            
        }
        return newAccount;
    }
    @Override
    public void Insert(){
        if(this.IsValid()){
            String insertString = "INSERT INTO " + Account.getTablename()
                    + " VALUES (?,?,?,?,?);";
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            ResultSet keys;
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(insertString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForInsert(preparedStatement);
                int rowsInserted = preparedStatement.executeUpdate();
                keys = preparedStatement.getGeneratedKeys();
                keys.next();
                int id = keys.getInt(1);
                this.setID(id);
                mysql.Connector.CloseResources();
                
                
            }catch(SQLException e){
                e.getMessage();//e.printStackTrace();
            }
        }
        
    }
    
    @Override
    public void Update(){
        if(this.IsValid()){
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            String updateString = "UPDATE ACCOUNTS SET "
                    + "manager_id = ?, "
                    + "name = ?, "
                    + "creation_date = ?, "
                    + "close_date = ? WHERE id = ?;";
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(updateString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForUpdate(preparedStatement);
                preparedStatement.executeUpdate();
            }catch(SQLException e){
                e.getMessage();
            }
        }
    }
    
    private PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2,this.getManagerID());
            preparedStatement.setString(3, this.getName());
            preparedStatement.setDate(4,this.getCreationDate());
            preparedStatement.setDate(5,this.getCloseDate());
            //preparedStatement.setDate(5, this.getCloseDate());
        }catch(SQLException e){
            
        }
        return preparedStatement;
    }
    
    private PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1,this.getManagerID());
            preparedStatement.setString(2, this.getName());
            preparedStatement.setDate(3, this.getCreationDate());
            preparedStatement.setDate(4, this.getCloseDate());
            preparedStatement.setInt(5, this.getID());
        }catch(SQLException e){
            
        }
        return preparedStatement;
    }
    
    public List<User> UserList(){
        return UserList.ByAccount(this.getID());
    }
    
    
    
    
    
}