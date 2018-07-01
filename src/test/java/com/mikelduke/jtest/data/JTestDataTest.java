package com.mikelduke.jtest.data;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JTestDataTest {

	JTestData jTestData = new JTestData();
	
	@Test
	public void nouns_notEmpty() {
		List<String> nouns = jTestData.get(DataType.NOUNS);

		Assert.assertFalse(nouns.isEmpty());
	}

	@Test
	public void nouns_firstHasValue() {
		List<String> nouns = jTestData.get(DataType.NOUNS);

		Assert.assertFalse(nouns.get(0).isEmpty());
	}

	@Test
	public void allTypes_notEmpty() {
		for (DataType t : DataType.values()) {
			Assert.assertFalse(jTestData.get(t).isEmpty());
		}
	}
}