public class Calculator {
    private final String delimiters="[,\n]";

    public int add(String input){
        String[] nums=null;
        if(input.matches("//(.)\n(.*)")){
            char randomDelimiter=input.charAt(2);
            String newInput=input.substring(4);
            String[] vals=newInput.split(Character.toString(randomDelimiter));
            return sum(vals);
        }
        else if(empty(input)){
            return 0;
        } else {
            nums=splitter(input);
            return sum(nums);
        }
    }

    private String[] splitter(String input){
        return input.split(delimiters);
    }

    private int sum(String[] nums){
        int sum=0;
        for(String values:nums){
            sum+=stringToInt(values);
        }
        return sum;
    }

    private boolean empty(String input){
        return input.isEmpty();
    }

    private int stringToInt(String num){
        return Integer.parseInt(num);
    }
}
