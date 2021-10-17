package com.app.controller;

import com.app.entity.supervisors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping()
    public String displayIndex(Model model) throws URISyntaxException {
        RestTemplate restTemplate=new RestTemplate();
        URI uri = new URI("http://localhost:8080/api/supervisors");
        ResponseEntity<supervisors[]> responseEntity = restTemplate.getForEntity(uri, supervisors[].class);
        List<supervisors> object1 = Arrays.asList(responseEntity.getBody());
        System.out.println(object1.toString());
        System.out.println(supervisors.sortTheList(object1).toString());
        model.addAttribute("lists", supervisors.RemoveNumber( supervisors.sortTheList(object1)));
        return "index";
    }

}
