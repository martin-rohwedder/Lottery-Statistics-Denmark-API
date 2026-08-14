package dk.martinrohwedder.lottery_statistics_denmark;

import org.springframework.boot.SpringApplication;

public class TestLotteryStatisticsDenmarkApplication {

	public static void main(String[] args) {
		SpringApplication.from(LotteryStatisticsDenmarkApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
