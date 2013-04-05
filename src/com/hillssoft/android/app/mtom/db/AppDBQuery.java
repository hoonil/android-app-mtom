package com.hillssoft.android.app.mtom.db;

import java.util.HashMap;

public class AppDBQuery {
	
	public static enum QueryKey{
		CREATE_TABLE_CATEGORY_LIST,
		CREATE_TABLE_FRIEND_LIST,
		CREATE_TABLE_INVITE,
		CREATE_TABLE_POST,
		CREATE_TABLE_POST_COMMENT,
		
		INSERT_TABLE_CATEGORY_LIST,
		
		
		
		
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
	
	private static final String DB_TABLE_CATEGORY_LIST = "tb_category_list";
	private static final String DB_TABLE_FRIEND_LIST = "tb_friend_list";
	private static final String DB_TABLE_POST = "tb_post";
	private static final String DB_TABLE_POST_COMMENT = "tb_post_comment";
	
	public static String getQuery(QueryKey key){
		return getQuery(key, null);
	}
	
	public static String getQuery(QueryKey key, HashMap<String, String> params){
		
		String sqlQuery = "";
		
		switch(key){
			case CREATE_TABLE_CATEGORY_LIST :
				sqlQuery = "" +
						"CREATE TABLE IF NOT EXISTS " + DB_TABLE_CATEGORY_LIST + "(" +
						"	user_id INTEGER UNSIGNED NOT NULL," +
						"	category_id INTEGER UNSIGNED NOT NULL," +
						"	category_name TEXT NOT NULL," +
						"	date_create DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00'," +
						"	state INTEGER UNSIGNED NOT NULL DEFAULT '0'," +
						"	PRIMARY KEY (`category_id`,`user_id`)" +
						");";
			break;
		
			case CREATE_TABLE_FRIEND_LIST :
				sqlQuery = "" +
						"CREATE TABLE IF NOT EXISTS " + DB_TABLE_FRIEND_LIST + "(" +
						"	friend_user_id INTEGER UNSIGNED NOT NULL," +
						"	friend_user_name TEXT NOT NULL," +
						"	friend_user_type INTEGER UNSIGNED NOT NULL," +
						"	date_create DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00'," +
						"	state INTEGER UNSIGNED NOT NULL DEFAULT '0'," +
						"	PRIMARY KEY (`friend_user_id`,`friend_user_type`)" +
						");";
			break;
			
			case CREATE_TABLE_INVITE :
				sqlQuery = "" +
						"CREATE TABLE IF NOT EXISTS " + DB_TABLE_FRIEND_LIST + "(" +
						"	friend_user_id INTEGER UNSIGNED NOT NULL," +
						"	friend_user_name TEXT NOT NULL," +
						"	friend_user_type INTEGER UNSIGNED NOT NULL," +
						"	category_id INTEGER UNSIGNED NOT NULL," +
						"	category_name TEXT NOT NULL," +
						"	date_create DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00'," +
						"	date_accept DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00'," +
						"	state INTEGER UNSIGNED NOT NULL DEFAULT '0'," +
						"	PRIMARY KEY (`friend_user_id`,`friend_user_type`, `category_id`)" +
						");";
			break;
			
			case CREATE_TABLE_POST :
				sqlQuery = "" +
						"CREATE TABLE IF NOT EXISTS " + DB_TABLE_POST + "(" +
						"	post_id INTEGER UNSIGNED NOT NULL," +
						"	user_id INTEGER UNSIGNED NOT NULL," +
						"	category_id INTEGER UNSIGNED NOT NULL," +
						"	content TEXT NOT NULL," +
						"	date_create DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00'," +
						"	date_update DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00'," +
						"	desc_date_update INTEGER NOT NULL," +
						"	is_public INTEGER UNSIGNED NOT NULL DEFAULT '0'," +
						"	state INTEGER UNSIGNED NOT NULL DEFAULT '0'," +
						"	PRIMARY KEY (`post_id`)" +
						");";
			break;
			
			case CREATE_TABLE_POST_COMMENT :
				sqlQuery = "" +
						"CREATE TABLE IF NOT EXISTS " + DB_TABLE_POST_COMMENT + "(" +
						"	post_comment_id INTEGER UNSIGNED NOT NULL," +
						"	post_id INTEGER UNSIGNED NOT NULL," +
						"	user_id INTEGER UNSIGNED NOT NULL," +
						"	comment TEXT NOT NULL," +
						"	date_create DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00'," +
						"	state INTEGER unsigned NOT NULL DEFAULT '0'," +
						"	PRIMARY KEY (`post_comment_id`)" +
						");";
			break;
			
			case INSERT_TABLE_CATEGORY_LIST :
				sqlQuery = "" +
						"INSERT INTO " + DB_TABLE_CATEGORY_LIST + "(" +
						"	user_id, " +
						"	category_id, " +
						"	date_create, " +
						"	state" +
						") VALUES(" +
						"	'" + params.get("user_id") + "', " +
						"	'" + params.get("category_id") + "', " +
						"	'" + params.get("date_create") + "', " +
						"	'" + params.get("state") + "'" +
						");";
			break;
			
			
			
			
			
			
			
			
			
			case INSERT_TABLE_POST :
				
				sqlQuery = "" +
						"INSERT INTO " + DB_TABLE_POST + "(" +
						"	message, " +
						"	create_at, " +
						"	state, " +
						"	is_del" +
						") VALUES(" +
						"	'" + params.get("message") + "', " +
						"	'" + params.get("create_at") + "', " +
						"	'" + params.get("state") + "', " +
						"	'" + params.get("is_del") + "'" +
						");";
			break;
				
			case UPDATE_TABLE_POST :
				sqlQuery = "" +
						"UPDATE " +
						" " + DB_TABLE_POST + " " +
						"SET " +
						"	message = '" + params.get("message") + "' " +
						"WHERE " +
						"	post_id > " + params.get("post_id") + "";
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
