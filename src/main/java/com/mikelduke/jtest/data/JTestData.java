package com.mikelduke.jtest.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JTestData {
	private static ObjectMapper mapper = new ObjectMapper();

	private Map<DataType, SimpleTestData> data = new HashMap<>();

	public List<String> get(DataType type) {
		SimpleTestData testData = data.get(type);

		if (testData == null) {
			testData = load(type);
			data.put(type, testData);
		}

		return testData.getData();
	}

	private static SimpleTestData load(DataType t) {
		return load(t.getFileName(), SimpleTestData.class);
	}

	private static <T> T load(String file, Class<T> clazz) {
		try (InputStream is = JTestData.class.getClassLoader().getResourceAsStream(file)) {
			return mapper.readValue(is, clazz);
		} catch (IOException e) {
			throw new RuntimeException("Error loading json", e);
		}
	}
}
