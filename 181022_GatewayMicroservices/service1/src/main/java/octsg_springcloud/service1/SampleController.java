package octsg_springcloud.service1;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service1")
public class SampleController {

    @GetMapping("sampleget")
    public String callAPI() {
//        String Response = restTemplate.getForObject("http://localhost:8081");
        System.out.println("Another Service Response is ");
        return "ok";
    }
}
