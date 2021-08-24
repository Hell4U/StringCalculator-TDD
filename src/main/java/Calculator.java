public class Calculator {
    private final String delimiters="[,\n]";

    public int add(String input){
        String[] nums=splitter(input);
        if(empty(input)){
            return 0;
        } else {
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
