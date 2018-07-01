package com.mikelduke.jtest.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JTestData {
	private static final ObjectMapper mapper = new ObjectMapper();

	static final Map<DataType, SimpleTestData> data = new HashMap<>();

	private JTestData() { }

	public static void loadAll() {
		synchronized(data) {
			for (DataType t : DataType.values()) {
				data.put(t, load(t));
			}
		}
	}

	public static List<String> get(DataType type) {
		SimpleTestData testData = data.get(type);

		if (testData == null) {
			synchronized(data) {
				testData = data.get(type);
				if (testData == null) {
					testData = load(type);
					testData.setData(
						Collections.unmodifiableList(
							testData.getData().stream().distinct().collect(Collectors.toList())));
					data.put(type, testData);
				}
			}
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
