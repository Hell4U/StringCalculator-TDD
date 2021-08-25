import java.util.ArrayList;
import java.util.List;

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
                List<Integer> opening=openingBracket(input);
                if(opening.size()>1){
                    int n=opening.size();
                    int end=opening.get(n-1)+4;
                    delimiter="["+multiSingleLengthSplitter(opening,n,input)+"]";
                    newInput=multiSingleSubstringNumberExtractor(input,end);
                }else{
                    delimiter= singleMultiLengthSplitter(input);
                    newInput= multiSubstringNumberExtractor(input);
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

    private String singleMultiLengthSplitter(String input){
        int start=input.indexOf('[');
        int end=input.indexOf(']');
       return input.substring(start+1,end);
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

    private String multiSingleLengthSplitter(List<Integer> opening,int n,String input){
        String s="";
        for(int i=0;i<n;i++){
            int start=opening.get(i);
            s+=input.substring(start+1,start+2);
        }
        return s;
    }


    private String multiSubstringNumberExtractor(String input){
        int end=input.indexOf(']');
        return input.substring(end+2);
    }

    private String multiSingleSubstringNumberExtractor(String input, int end){
        return input.substring(end);
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
