package com.LibTrack.interfaces.repository;

public interface IPasswordRepository {
	public String encodedPassword(String password);
	public boolean checkPassword(String hashedPassword, String password);
}
