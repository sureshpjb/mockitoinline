package com.suresh;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.hamcrest.CoreMatchers.*;

public class PowerMockRuleServiceTest {

	private AppService appService;

	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() {
		appService = PowerMockito.spy(new AppService());
	}

	@Test
	public void testPrivateMethod() throws Exception {

		expectedException.expectCause(isA(ServiceTestException.class));

		AppService spy = PowerMockito.spy(appService);
		Method method = AppService.class.getDeclaredMethod("testPrivateMethod", String.class);
		method.setAccessible(true);
		method.invoke(spy, "testparam");
	}

}
