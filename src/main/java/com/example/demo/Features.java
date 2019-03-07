package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


//This class provides all the properties related to the feature.*
@Component
@ConfigurationProperties("feature")
public class Features {

    private Map<String, Boolean> toggles = new HashMap<>();

    //This method will get all the toggles that provided with the feature flags
    public Map<String, Boolean> getToggles() {
        return toggles;
    }
    // this method will return  the property value of feature.toggles.update
    public boolean updateFeatureEnabled() {
        return toggles.get("update");
    }
    // this method will return  the property value of feature.toggles.save
    public boolean SaveFeatureEnabled() {
        return toggles.get("save");
    }
    // this method will return  the property value of feature.toggles.delete
    public boolean DeleteFeatureEnabled() {
        return toggles.get("delete");
    }
}
