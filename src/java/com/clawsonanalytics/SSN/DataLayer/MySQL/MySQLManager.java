/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL;

/**
 *
 * @author andrewclawson
 */
public class MySQLManager {
    private MySQLDataSource Source;
    public MySQLDataConnector Connector;
    
    
    public void setDataSource(MySQLDataSource dataSource){
        this.Source = dataSource;
    }
}