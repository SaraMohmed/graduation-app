package com.panel.LRapp.Service;

import com.panel.LRapp.response.EvaluateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateServiceImp implements EvaluateService{

    @Autowired
    private feelingsService feel;
    @Autowired
    private AdminCService adminCService;
    @Override
    public EvaluateResponse getEvaluate() {
        return new EvaluateResponse(adminCService.findAll().size(),feel.findAll().size());
    }
}
