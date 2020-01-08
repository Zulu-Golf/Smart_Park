package com.sm.mongo;


import com.mongodb.*;

public class JavaMongoConnection {
	
	public static void main(String args[]) throws Exception{
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		System.out.println("MongoDB is connected !");
		
		mongoClient.getDatabaseNames().forEach(System.out::println);
		DB db = mongoClient.getDB("SmartParking");
		db.getCollectionNames().forEach(System.out::println);
		
		}
}
