package com.example.lesson2;

//import com.example.lesson2.ProductRecord.ProductRecord;
//import com.example.lesson2.ProductService.PgProductService;
//import com.example.lesson2.ProductService.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Lesson2Application {

	public static void main(String[] args) {

		SpringApplication.run(Lesson2Application.class, args);

//		ConfigurableApplicationContext context =
//				SpringApplication.run(Lesson2Application.class, args);
//		ProductService productService = context.getBean(PgProductService.class);

		//findAll
//		var list = productService.findAll();
//		System.out.println("-----findAll-----");
//		list.stream().forEach(System.out::println);
//
//		//findById
//		var user = productService.findById(1);
//		System.out.println("-----findById-----");
//		System.out.println(user);
//
//		//insert
//		var newRecord = new ProductRecord(4,"靴",8000);
//		productService.insert(newRecord);
//		var user2 = productService.findById(4);
//		System.out.println("-----insert-----");
//		System.out.println(user2);
//
//		//update
//		var updateRecord = new ProductRecord(1,"洋服",3000);
//		productService.update(updateRecord);
//		var updateUser = productService.findAll();
//		System.out.println("-----update-----");
//		updateUser.stream().forEach(System.out::println);
//		System.out.println("-----update(findById)-----");
//		var user3 = productService.findById(1);
//		System.out.println(user3);
//
//		//delete
//		var user4 = productService.delete(1);
//		System.out.println("-----delete-----");
//		System.out.println(user4);
//		System.out.println("-----delete(findAll)-----");
//		var deleteUser = productService.findAll();
//		deleteUser.stream().forEach(System.out::println);

	}


}
