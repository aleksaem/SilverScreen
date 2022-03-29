package com.movieland.cinema.controller;

import com.movieland.cinema.domain.User;
import com.movieland.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.movieland.cinema.utils.FileReader.readUFromUrl;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e11/download/user.txt";

    @GetMapping("/add")
    public String addUser() {

        List<String> rows = readUFromUrl(fileName);
        List<User> users = new ArrayList<>();
        User user = new User();

        for (int i = 0; i < rows.size(); i++) {
            if (i % 3 == 0) {
                user = new User();
                user.setUserName(rows.get(i));
            } else if (i % 3 == 1) {
                user.setEmail(rows.get(i));
            } else if (i % 3 == 2) {
                user.setPassword(rows.get(i));
                users.add(user);
                log.info("user: {}", user);
                userService.addUser(user);
            }
        }
        return "redirect:/users";
    }

    @GetMapping()

    public Iterable<User> getAll(Model model) {

        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return users;
    }
}
