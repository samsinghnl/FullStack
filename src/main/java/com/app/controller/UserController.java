package com.app.controller;

import com.app.entity.MyResponse;
import com.app.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/submit")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        if (user.getFirstname().trim().isEmpty() || user.getLastname().trim().isEmpty() || user.getLastname().trim().isEmpty() || user.getSupervisor().trim().isEmpty()){
            System.out.println("Invalid that not will be null "+user.toString());
            MyResponse<User> response = new MyResponse<>("First name and Last Name and supervisor can not be empty", user);
            return new ResponseEntity<Object>(response, HttpStatus.NO_CONTENT);
        }
        System.out.println("success "+user.toString());
        MyResponse<User> response = new MyResponse<>("success", user);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/supervisors")
    public List<supervisors> suo() throws URISyntaxException {
        RestTemplate restTemplate=new RestTemplate();
        URI uri = new URI("https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers");
        ResponseEntity<supervisors[]> responseEntity = restTemplate
                .getForEntity(uri, supervisors[].class);

        System.out.println(responseEntity.getBody().toString() );
        List<supervisors> object1 = Arrays.asList(responseEntity.getBody());
        System.out.println(object1.toString());


        return object1;
    }

}
