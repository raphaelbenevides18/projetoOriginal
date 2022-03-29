package br.com.rlb.projetoOriginal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
class ProjetoOriginalApplicationTests {

	@Test
	public void testMain() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				ProjetoOriginalApplication.main(new String[]{});
			}
		};
		Thread thread = new Thread(runnable);
		thread.run();
		thread.interrupt();
	}

}
