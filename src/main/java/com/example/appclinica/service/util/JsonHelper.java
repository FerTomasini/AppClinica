package com.example.appclinica.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.util.stream.Collectors;

public class JsonHelper {

	public static <T> String toJson(ObjectMapper objectMapper, T object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T fromJson(ObjectMapper objectMapper, String payload, Class<T> clazz) {
		try {
			return objectMapper.readValue(payload, clazz);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T fromJson(ObjectMapper objectMapper, String payload, TypeReference<T> clazz) {
		try {
			return objectMapper.readValue(payload, clazz);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().findAndRegisterModules().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String converteJsonEmString(BufferedReader buffereReader) {
		return buffereReader.lines().collect(Collectors.joining());
	}

}

