package com.gildata.quote.client;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gildata.quote.config.CacheConfig;
import com.gildata.quote.config.NettyConfig;
import com.gildata.quote.config.RootConfig;
import com.gildata.quote.config.WebSocketConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, NettyConfig.class,
		CacheConfig.class, WebSocketConfig.class })
public class QuoteClientTest {

	@Autowired
	private QuoteClient client;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		try {
			client.run();
		} catch (Exception e) {
			fail("Exception");
			e.printStackTrace();
		}
	}

}
