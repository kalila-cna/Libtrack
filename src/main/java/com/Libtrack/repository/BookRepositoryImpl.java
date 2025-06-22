package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.IBookRepository;
import com.LibTrack.model.Book;
import com.LibTrack.model.EditBook;

public class BookRepositoryImpl implements IBookRepository {

	@Override
	public void addBook(Book book) throws SQLException {
		String query = "INSERT INTO book (book_name, quantity, category) VALUES (?, ?, ?);";

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setString(1, book.getBookName());
			pst.setInt(2, book.getQuantity());
			pst.setString(3, book.getCategory());

			pst.executeUpdate();
		}
	}

	@Override
	public List<EditBook> getAllBooks() throws SQLException {
		String query = "SELECT * FROM book";
		List<EditBook> bookDetails = new ArrayList<>();

		try (Connection conn = DbConnection.getConection(); Statement st = conn.createStatement()) {

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				EditBook model = new EditBook();
				model.setBook_id(rs.getInt(1));
				model.setBookName(rs.getString(2));
				model.setQuantity(rs.getInt(3));
				model.setCategory(rs.getString(4));

				bookDetails.add(model);
			}
		}

		return bookDetails;
	}

	@Override
	public List<EditBook> getBookById(int bookId) throws SQLException {
		String query = "SELECT * FROM book where book_id=?";
		List<EditBook> bookDetails = new ArrayList<>();

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			try(ResultSet rs = pst.executeQuery();){
			
			while (rs.next()) {
				EditBook model = new EditBook();
				model.setBook_id(rs.getInt(1));
				model.setBookName(rs.getString(2));
				model.setQuantity(rs.getInt(3));
				model.setCategory(rs.getString(4));

				bookDetails.add(model);
			}
			}
		}

		return bookDetails;
	}

	@Override
	public boolean updateBookById(EditBook editBook) throws SQLException {
		String query = "UPDATE book SET book_name=?, quantity=? , category=? where book_id=?";

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setString(1, editBook.getBookName());
			pst.setInt(2, editBook.getQuantity());
			pst.setString(3, editBook.getCategory());
			pst.setInt(4, editBook.getBook_id());
			
			int rows=pst.executeUpdate();
			
			if(rows > 0) return true;
			return false;
		}
		
	}

	@Override
	public boolean deleteBookById(int bookId) throws SQLException {
		String query = "DELETE FROM book where book_id=?";

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
		
			
			int rows=pst.executeUpdate();
			
			if(rows > 0) return true;
			return false;
		}
	}

	@Override
	public boolean reduceQuantity(int bookId) throws SQLException {
		String query = "UPDATE book AS b"
				+ " JOIN (SELECT quantity FROM book WHERE book_id = ?) AS subquery"
				+ " ON b.book_id = ?"
				+ " SET b.quantity = subquery.quantity - 1;";

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			pst.setInt(2, bookId);
		
			
			int rows=pst.executeUpdate();
			
			if(rows > 0) return true;
			return false;
		}
	}

	@Override
	public boolean increaseQuantity(int bookId) throws SQLException {
		String query = "UPDATE book AS b"
				+ " JOIN (SELECT quantity FROM book WHERE book_id = ?) AS subquery"
				+ " ON b.book_id = ?"
				+ " SET b.quantity = subquery.quantity + 1;";

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			pst.setInt(2, bookId);
		
			
			int rows=pst.executeUpdate();
			
			if(rows > 0) return true;
			return false;
		}
	}

}
