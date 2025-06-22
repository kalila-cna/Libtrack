package com.LibTrack.repository;

import org.mindrot.jbcrypt.BCrypt;

import com.LibTrack.interfaces.repository.IPasswordRepository;

public class PasswordRepositoryImpl implements IPasswordRepository{

	@Override
	public String encodedPassword(String password) {
		String hashedpw= BCrypt.hashpw(password, BCrypt.gensalt());
		return hashedpw;
	}

	@Override
	public boolean checkPassword(String hashedPassword, String password) {
		Boolean checkpw=BCrypt.checkpw(password,hashedPassword);
		return checkpw;
	}

}
