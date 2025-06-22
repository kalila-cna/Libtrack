package com.LibTrack.interfaces.repository;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.Book;
import com.LibTrack.model.EditBook;

public interface IBookRepository {
	
	public void addBook(Book book) throws SQLException;
	public List<EditBook> getAllBooks() throws SQLException;
	public List<EditBook> getBookById(int bookId) throws SQLException;
	public boolean updateBookById(EditBook editBook) throws SQLException;
	public boolean deleteBookById(int bookId) throws SQLException;
	public boolean reduceQuantity(int bookId) throws SQLException;
	public boolean increaseQuantity(int bookId) throws SQLException;
	
	
}
