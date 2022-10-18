package octsg_springcloud.service1;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("service1")
public class SampleController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("samplegettest")
    public String callAPI() {
        String Response = restTemplate.getForObject("http://localhost:8082/service2/sampleapi", String.class);
        System.out.println("Service: " +Response);
        return "OKAY";
    }

    private String getErrorMsg() {
        return "Error occured successfully.";
    }

    @GetMapping("/circuitbreaker")
    public String circuitBreakerMethod (){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
//        String url = "https://jsonplaceholder.typicode.com/albums";
        String url = "https://hellowWorld.url";

        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class), throwable -> getErrorMsg());
    }
    @GetMapping("sampleget")
    public String calAPI() {
//        String Response = restTemplate.getForObject("http://localhost:8081");
        System.out.println("Another Service Response is ");
        return "ok";
    }
}
