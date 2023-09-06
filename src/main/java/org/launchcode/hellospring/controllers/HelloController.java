package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    public static String createMessage(String name, String language) {
        if (language.equals("English")) {
            return "Hello, " + name + "!";
        } else if (language.equals("Spanish")) {
            return "¡Hola " + name + "!";
        } else if (language.equals("French")) {
            return "Bonjour " + name + "!";
        } else if (language.equals("Italian")) {
            return "Ciao, " + name + "!";
        } else if (language.equals("German")) {
            return "Hallo, " + name + "!";
        } else {
            return "Greetings" + name + "!";
        }
    }

    @RequestMapping(value="hello",method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null || name.isEmpty()) {
            name = "World";
        }
        return "<em><font color='purple'>" +
                createMessage(name, language) +
                "</color></em>";
    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='French'>French</option>" +
                "<option value='Italian'>Italian</option>" +
                "<option value='German'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
