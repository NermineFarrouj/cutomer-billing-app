package net.supervision.customerservice.config;

import net.supervision.customerservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
//preuve de recuperation de config : customer service a contacter config service et a recuperer la config
@RestController
@RefreshScope //configuration a chaud
public class ConfigTestRestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;

@Autowired
    private CustomerConfigParams customerConfigParams;
    @GetMapping("/test1")
    public Map<String, String> configTest() {
        return Map.of("p1", p1, "p2", p2);
    }

    @GetMapping("/test2")
    public CustomerConfigParams ConfigTest2() {
        return customerConfigParams;
    }
}
