package net.devple.api.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class RootController {

  @GetMapping("/hello")
  public Map<String,String> hello() {
    return Map.of("hello","hi");
  }
}