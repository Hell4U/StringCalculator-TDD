import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {
    public int add(String input){
        if(empty(input)) return 0;

        String[] nums=null;
        String delimiter=null;
        String newInput=input;

        if(input.startsWith("//")){
            if(delimiterLengthChecker(input)){
                delimiter=charToString(input.charAt(2));
                newInput=input.substring(4);
            }else {
                List<Integer> opening=new ArrayList<>();
                int n=input.length();
                int openingIndex=input.indexOf('[');
                while(openingIndex>=0){
                    opening.add(openingIndex);
                    openingIndex=input.indexOf('[',openingIndex+1);

                }
                if(opening.size()>1){
                    delimiter="[";
                    n=opening.size();
                    for(int i=0;i<n;i++){
                        int start=opening.get(i);
                        delimiter+=input.substring(start+1,start+2);
                    }
                    delimiter+="]";
                    int end=opening.get(n-1);
                    newInput=input.substring(end+4);
                }else{
                    delimiter=multiLengthSplitter(input);
                    newInput=substringNumberExtractor(input);
                }
            }
        }
        else {
            delimiter="[,\n]";
        }

        nums=splitter(newInput,delimiter);
        return sum(nums);
    }

    private int sum(String[] nums){
        int sum=0;
        negativeFiltering(nums);
        for(String values:nums){
            if(stringToInt(values)<=1000){
            sum+=stringToInt(values);
            }
        }
        return sum;
    }

    private void negativeFiltering(String[] nums){
        String areNegative=negativeFinder(nums);
        if(!empty(areNegative)){
            throw new IllegalArgumentException("negative not allowed: "+areNegative);
        }
    }

    private String negativeFinder(String[] nums){
        List<String> numberHolder=new ArrayList<String>();
        for(String val:nums){
            if(stringToInt(val)<0){
                numberHolder.add(val);
            }
        }
        return listToString(numberHolder);
    }

    private Boolean delimiterLengthChecker(String input){
        if(input.charAt(2)=='['){
            return false;
        }else{
            return true;
        }

    }

    private String multiLengthSplitter(String input){
        int start=input.indexOf('[');
        int end=input.indexOf(']');
       return input.substring(start+1,end);
    }

    private String substringNumberExtractor(String input){
        int end=input.indexOf(']');
        return input.substring(end+2);
    }

    private String[] splitter(String input, String delimiters){
        return input.split(delimiters);
    }

    private String listToString(List<String> numbers){
        return String.join(",",numbers);
    }

    private boolean empty(String input){
        return input.isEmpty();
    }

    private int stringToInt(String num){

        return Integer.parseInt(num);
    }

    private String charToString(Character c){
        return Character.toString(c);
    }
}
