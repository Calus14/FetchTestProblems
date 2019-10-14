package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import service.TestFetchService;

import java.util.List;

@RestController
@RequestMapping("/testFetch")
public class TestFetchController {

    @Autowired
    protected TestFetchService myService;

    @RequestMapping(value = "/checkPyramidWord",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean pyramidWord(String word) {
        return myService.isWordPyramid(word);
    }

    public int countUniqueEmails(List<String> emails) {
        System.out.println("hit postUserInfo");
        return myService.getUniqueEmailCount(emails);
    }

}
