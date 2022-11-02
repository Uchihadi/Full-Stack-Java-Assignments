package octsg_springcloud.service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service2")
public class SampleController {
    @GetMapping("sampleapi")
    public String getName() {
        return "Sample Response from Client 2";
    }
}
