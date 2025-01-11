package org.borthick.neotracker.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.borthick.neotracker.service.NeoTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NeoTrackerController {
    private final NeoTrackerService neoTrackerService;

    @Autowired
    public NeoTrackerController(NeoTrackerService neoTrackerService) {
        this.neoTrackerService = neoTrackerService;
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        System.out.println(request.getScheme());
        System.out.println(request.getServerName());
        return "index";
    }
}
