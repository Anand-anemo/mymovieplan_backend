package com.mymovieplan.project.exception;

public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException() {
		super("User with this name already exsits please try another username");
	}
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
