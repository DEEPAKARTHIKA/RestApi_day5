package com.skcet.day5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.day5.model.Book;
import com.skcet.day5.service.ApiService;

@RestController
@RequestMapping("api/v1/book")
public class ApiController {
         @Autowired
         private ApiService apiservice;
         
         @GetMapping("/getBook")
         public ResponseEntity<List<Book>>getBook(){
        	 return ResponseEntity.status(200).body(apiservice.getBook());
         }
         
         @PostMapping("/addBook")
         public ResponseEntity<String> addBook(@RequestBody Book book){
        	 boolean dataSaved=apiservice.addBook(book);
        	 if(dataSaved) {
        		 return ResponseEntity.status(200).body("Book added successfully");
        	 }
        	 else {
        		 return ResponseEntity.status(404).body("not added");
        	 }
         }
         @PutMapping("/updateBook/{id}")
         public ResponseEntity<String>updateUser(@PathVariable Long id,@RequestBody Book book){
        	 boolean userData=apiservice.updateBook(id,book);
        	 if(userData) {
        		 return ResponseEntity.status(200).body("Book updated successfully");
        	 }
        	 else {
        		 return ResponseEntity.status(404).body("No record found to be updated");
        	 }
         }
         @DeleteMapping("/deleteBook")
 	 	public ResponseEntity<String> deleteBook(@RequestParam Long id){
 	 		boolean userDeleted =apiservice.deleteBook(id);
 	 		if(userDeleted) { 
 	 			return ResponseEntity.status(200).body("Book deleted successfully");
 	 		} else {
 	 			return ResponseEntity.status(404).body("No record found to be updated");
 	 		}
 	 	}
}
