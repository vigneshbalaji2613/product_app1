package com.chainsys.product.test;

import java.time.LocalDate;
import java.util.List;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args )throws ProductNotFoundException {

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		List<String> nameList;
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Update the Product Name Based on the Id");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			id = scanner.nextInt();
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 4:
			System.out.println("Adding a Product");
			System.out.println("product");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(2, "Pencil", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 5:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 6:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			 String name = scanner.next();
			try {
				Product product = service.findByname(name);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 7:
			System.out.println("Update the Product expairydate Based on the id");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updatedate = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			id = scanner.nextInt();
			try {
				service.update(updatedate);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 8:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Name");
			name = scanner.next();
			try {
				service.deletebyname(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		
		case 9:
			System.out.println("Display Name of All Products");
			nameList = service.findAllName();
			System.out.println(nameList);
			break;
				
			
		default:
			break;
		}
		scanner.close();
	}

}
