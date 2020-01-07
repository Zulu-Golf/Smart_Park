package com.sm.mongo;


import com.mongodb.*;

public class JavaMongoConnection {
	
	public static void main(String args[]) throws Exception{
		MongoClient mongo = new MongoClient("localhost", 27017);
		System.out.println("MongoDB is connected !");
}
}