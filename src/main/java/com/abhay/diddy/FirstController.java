package com.abhay.diddy;

import com.abhay.diddy.data.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/")
    public String home(){
        return "Hello world";
    }

    @GetMapping("/meboy/{no}")
    public String me(@RequestParam String name, @PathVariable int no){
        return "this is about me! and i am " + name + " " + no;
    }

    @GetMapping("/path/{n}")
    public int pathVar(@PathVariable int n){
        return n;
    }

    @PostMapping("postone")
    public Person gettingIn(){

        Person person = new Person();

        return person;
    }

    @PostMapping("/person")
    public String json_data(@RequestBody Person person){
        return "Hello " + person.getName() + " of " + person.getAge();
    }

}