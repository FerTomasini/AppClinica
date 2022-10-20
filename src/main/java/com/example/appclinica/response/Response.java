package com.example.appclinica.response;

public record Response<T>(
		T object,
		String message) {
	public static String MSG_SUCCESS = "Operação realizada com sucesso.";

	public Response(String message) {
		this(null, message);
	}
}
