package com.mikelduke.jtest.data;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JTestDataTest {

	@Before
	public void before() {
		JTestData.data.clear();
	}

	@Test
	public void nouns_notEmpty() {
		List<String> nouns = JTestData.get(DataType.NOUNS);

		Assert.assertFalse(nouns.isEmpty());
	}

	@Test
	public void nouns_firstHasValue() {
		List<String> nouns = JTestData.get(DataType.NOUNS);

		Assert.assertFalse(nouns.get(0).isEmpty());
	}

	@Test
	public void allTypes_notEmpty() {
		for (DataType t : DataType.values()) {
			Assert.assertFalse(JTestData.get(t).isEmpty());
		}
	}

	@Test
	public void loadAll() {
		JTestData.loadAll();

		Assert.assertFalse(JTestData.data.isEmpty());
	}
}