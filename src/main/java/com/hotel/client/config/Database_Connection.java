package com.hotel.client.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database_Connection {
	Database db=Database.getInstance();
	protected  Connection con=Database.getCon();
	protected  PreparedStatement pst=Database.getStatement();
	protected  ResultSet rs=Database.getResult();
	protected  CallableStatement cst=Database.getCall();
	
	
	
}
