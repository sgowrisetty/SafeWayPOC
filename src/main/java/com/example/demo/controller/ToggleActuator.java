package com.example.demo.controller;

import com.example.demo.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.lang.reflect.MalformedParametersException;
import java.util.Map;

@Component
@Endpoint(id = "feature-toggles")
class ToggleActuator {

    @Autowired
    private Features featureDecisions;

    ToggleActuator(Features featureDecisions) {
        this.featureDecisions = featureDecisions;
    }

    @ReadOperation
    public Map<String, Boolean> featureToggles() {
        return featureDecisions.getToggles();
    }

    @ReadOperation
    public String getfeatureToggle(@Selector String name) {
        return String.valueOf(featureDecisions.getToggles().get(name));
    }
    //Post Call to update the Feature Flag on runtime
    // by calling http://localhost:8008/actuator/feature-toggles/{"name":"update","value":true}
    @WriteOperation
    public void setfeatureToggle(@Selector String name, Boolean value) throws MalformedParametersException{
        featureDecisions.getToggles().put("update",value);
    }
}
