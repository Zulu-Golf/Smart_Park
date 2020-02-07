package com.sm.mongo;


import java.util.*;

import com.mongodb.*;

public class JavaMongoConnection {
	
	public static void main(String args[]) throws Exception{
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		System.out.println("MongoDB is connected !");
		DB db = mongoClient.getDB("SmartParking");
		db.getName();
		System.out.println(db.getName());
		db.getCollectionNames().forEach(System.out::println);
		
		}
}
