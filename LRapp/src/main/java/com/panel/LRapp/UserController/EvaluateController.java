package com.panel.LRapp.UserController;

import com.panel.LRapp.Service.EvaluateService;
import com.panel.LRapp.response.EvaluateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;
    @GetMapping("/getEvaluate")
    public EvaluateResponse getEvaluate(){
        return evaluateService.getEvaluate();
    }
}
