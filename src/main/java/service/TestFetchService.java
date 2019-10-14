package service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class TestFetchService {

    // Note: I could use IntIntMaps as Baeuldung shoes but including eclipse libaries seems like overkill
    public boolean isWordPyramid(String word){
        if(word == null || word.length() == 0)
            return false;
        HashMap<Character, Integer> characterCountMap = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            Character c = new Character(word.charAt(i));
            if(characterCountMap.containsKey(c))
                characterCountMap.put(c, new Integer(characterCountMap.get(c).intValue() + 1) );
            else
                characterCountMap.put(c, new Integer(1) );
        }

        int nextCount = 1;
        for( int i = 1; i <= characterCountMap.keySet().size(); i++)
        {
            if(!characterCountMap.containsValue(new Integer(nextCount)))
                return false;
            nextCount += 1;
        }

        return true;
    }

    // there are 3rd party libraries that do the gmail uniquness for you but i assume we dont want me using them
    public int getUniqueEmailCount(List<String> emails){
        HashSet<String> uniqueEmails = new HashSet<>();
        emails.forEach( email -> {
            try {
                String userName = email.split("@")[0];
                String domain = email.split("@")[1];
                userName = userName.replaceAll("\\.", "");
                userName = userName.split("\\+")[0];
                userName = userName.trim();
                uniqueEmails.add(userName+domain);
            }
            catch(Exception e){
                System.out.println("invalid email.");
            }
        });
        return uniqueEmails.size();
    }
}
