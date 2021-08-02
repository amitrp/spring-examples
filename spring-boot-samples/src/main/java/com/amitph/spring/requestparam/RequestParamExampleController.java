package com.amitph.spring.requestparam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class RequestParamExampleController {

    @GetMapping("/data1")
    public String singleParam(@RequestParam String id) {
        return "id: " + id;
    }

    @GetMapping("/data2")
    public String multiParam(
            @RequestParam String id,
            @RequestParam String name) {

        return "id: " + id + ", name: " + name;
    }

    @GetMapping("/data3")
    public String typedParam(@RequestParam Long id) {
        return "id: " + id;
    }

    @GetMapping("/data4")
    public String multiValueParams(@RequestParam List<String> id) {
        return "id: " + id;
    }

    @GetMapping("/data5")
    public String optionalParams
            (@RequestParam(required = false) Long id) {
        return "id: " + id;
    }

    @GetMapping("/data6")
    public String javaOptionalParams(@RequestParam Optional<String> id) {
        return "id: " + id.orElseGet(() -> "Unknown");
    }

    @GetMapping("/data7")
    public String defaultParams
            (@RequestParam(defaultValue = "Unknown") String id) {
        return "id: " + id;
    }

    @GetMapping("/data8")
    public String namedParams
            (@RequestParam(name = "id") String dataId) {
        return "dataId: " + dataId;
    }

    @GetMapping("/data9")
    public String mappedParams
            (@RequestParam Map<String, String> dataQuery) {

        return dataQuery.toString();
    }
}