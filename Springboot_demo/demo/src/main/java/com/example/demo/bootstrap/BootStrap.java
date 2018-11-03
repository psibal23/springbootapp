package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.model.Books;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRespository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRespository authorRespository;
	private BookRepository BookRepository;
	private PublisherRepository publisherRepository;
	
	public BootStrap (AuthorRespository authorRespository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		this.authorRespository=authorRespository;
		this.BookRepository= bookRepository;
		this.publisherRepository=publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
		
	}
	
	private void initData() {
		Author eric = new Author("Eric","Evans");
		Publisher p1 = new Publisher("Bllomsburry","No 4 Privet Drive");
		Books book1 = new Books("Domain Driven Design","Bloomsburry",p1);
		eric.getBooks().add(book1);
		book1.getAuthors().add(eric);
		
		authorRespository.save(eric);
		publisherRepository.save(p1);
		BookRepository.save(book1);
		
		Author jk = new Author("J K","Rowling");
		Publisher p2= new Publisher("Hellobloom","No 5 Mrauders Map");
		Books book2 = new Books("Harry Potter","134432",p2);
		eric.getBooks().add(book2);
		book1.getAuthors().add(jk);
		
		authorRespository.save(jk);
		publisherRepository.save(p2);
		BookRepository.save(book2);
		
		
	}

}
