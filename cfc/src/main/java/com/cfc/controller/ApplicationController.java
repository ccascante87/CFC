/**
 * 
 */
package com.cfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JIO
 *
 */
@Controller
public class ApplicationController {
	@RequestMapping("/dash")
    public String greeting() {
        return "dashboard";
    }

	@RequestMapping("/")
    public String index() {
        return "index";
    }
}
