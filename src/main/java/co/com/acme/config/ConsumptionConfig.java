package co.com.acme.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumptionConfig {
	
	@Value("${consumption.threshold}")
    private double consumptionThreshold;

    public double getConsumptionThreshold() {
        return consumptionThreshold;
    }    

}
