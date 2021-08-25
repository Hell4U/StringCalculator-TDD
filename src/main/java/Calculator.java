import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public int add(String input){

        if(empty(input)) return 0;

        String[] nums=null;
        String delimiter="";
        String newInput=input;

        if(input.startsWith("//")){
            if(delimiterLengthChecker(input)){
                delimiter=charToString(input.charAt(2));
                newInput=input.substring(4);
            }else {
                List<Integer> opening=openingBracket(input);
                List<Integer> closing=closingBracket(input);
                int n=opening.size();
                int end=closing.get(n-1);
                delimiter=allPurposeLengthSplitter(opening,closing,input);
                newInput=allPurposeNumberExtractor(end,input);
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

    private List<Integer> openingBracket(String input){
        List<Integer> opening=new ArrayList<>();
        int n=input.length();
        int openingIndex=input.indexOf('[');
        while(openingIndex>=0){
            opening.add(openingIndex);
            openingIndex=input.indexOf('[',openingIndex+1);

        }
        return opening;
    }

    private List<Integer> closingBracket(String input){
        List<Integer> closing=new ArrayList<>();
        int end=input.indexOf(']');
        while(end>=0){
            closing.add(end);
            end=input.indexOf(']',end+1);
        }
        return closing;
    }

    private String allPurposeLengthSplitter(List<Integer> opening, List<Integer> closing, String input){
        String s="";
        int n=opening.size();
        for(int i=0;i<n;i++){
            int start=opening.get(i);
            int end=closing.get(i);
            String tmp=input.substring(start+1,end);
            if(isDangerous(tmp.charAt(0))){
                s+=makeSafe(tmp);
            }else
                s+=tmp;
            if(i<n-1)
                s+="|";
        }
        return s;
    }

    private String allPurposeNumberExtractor(int end, String input){
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
        if(isDangerous(c)){
            return "\\"+Character.toString(c);
        }
        return Character.toString(c);
    }

    private Boolean isDangerous(char c){
        switch (c){
            case '$':
            case '.':
            case '+':
            case '?':
            case '^':
            case '*':
                return true;

        }
        return false;
    }

    private String makeSafe(String delimiter){
        int n=delimiter.length();
        String s="";
        for(int i=0;i<n;i++){
            s = s + ("\\" + delimiter.charAt(i));
        }
        return s;
    }
}
