package com.suresh;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class AppServiceTest {

	@Test
	public void testGetAppendedString() {
		AppUtil appUtil = mock(AppUtil.class);
		when(appUtil.getStr()).thenReturn("mocked string");

		AppService appService = new AppService();

		assertEquals("mocked string service", appService.getAppendedString(appUtil));

	}
}
