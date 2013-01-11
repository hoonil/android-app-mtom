package com.hillssoft.mtom.db;

import java.util.HashMap;

public class AppDBQuery {
	
	public static enum AppDBQueryKeyType{
		CREATE_TABLE_POST,
		CREATE_TABLE_POST_COMMENT,
		INSERT_TABLE_POST,
		INSERT_TABLE_POST_COMMENT,
		UPDATE_TABLE_POST,
		UPDATE_TABLE_POST_COMMENT,
		DELETE_TABLE_POST,
		DELETE_TABLE_POST_COMMENT,
		DROP_TABLE_POST,
		DROP_TABLE_POST_COMMENT,
		SELECT_TABLE_POST,
		SELECT_TABLE_POST_COMMENT,
		ALTER_TABLE_POST_18,
		
			
		
	}
	
	private static final String DB_TABLE_POST = "tb_post";
	private static final String DB_TABLE_POST_COMMENT = "tb_post_comment";
	
	public static String getQuery(AppDBQueryKeyType key){
		return getQuery(key, null);
	}
	
	public static String getQuery(AppDBQueryKeyType key, HashMap<String, String> params){
		
		String sqlQuery = "";
		
		switch(key){
		
			case CREATE_TABLE_POST :
				sqlQuery = "" +
						"CREATE TABLE IF NOT EXISTS " + DB_TABLE_POST + "(" +
						"	post_id INTEGER PRIMARY KEY AUTOINCREMENT," +
						"	message TEXT," +
						"	create_at INTEGER," +
						"	state INTEGER," +
						"	is_del INTEGER" +
						");";
			break;
			
			case CREATE_TABLE_POST_COMMENT :
				sqlQuery = "" +
						"CREATE TABLE IF NOT EXISTS " + DB_TABLE_POST_COMMENT + "(" +
						"	post_comment_id INTEGER PRIMARY KEY AUTOINCREMENT," +
						"	post_id INTEGER," +
						"	message TEXT," +
						"	create_at INTEGER" +
						");";
			break;
			
			case INSERT_TABLE_POST :
				sqlQuery = "" +
						"INSERT INTO " + DB_TABLE_POST + "(" +
						"	message, create_at, state, is_del" +
						") VALUES(" +
						"	'AA', '10000', '10', '0'" +
						");";
			break;
				
			case UPDATE_TABLE_POST :
				sqlQuery = "" +
						"UPDATE " +
						" " + DB_TABLE_POST + " " +
						"SET " +
						"	message = 'bbbbbb' " +
						"WHERE " +
						"	post_id > 0";
			break;
			
			case DELETE_TABLE_POST :
				sqlQuery = "" +
						"DELETE FROM " + DB_TABLE_POST + " WHERE post_id > 0";
			break;
			
			case DROP_TABLE_POST :
				sqlQuery = "" +
						"DROP TABLE IF NOT EXISTS " + DB_TABLE_POST;
			break;
			
			
			case ALTER_TABLE_POST_18 :
				sqlQuery = "" +
						"ALTER TABLE " + DB_TABLE_POST + " ADD is_del INTEGER DEFAULT 1";
			break;
			
			case SELECT_TABLE_POST :
				sqlQuery = "" +
						"SELECT * FROM " + DB_TABLE_POST;
			break;
			
			
		}
		return sqlQuery;
	}
	
}
