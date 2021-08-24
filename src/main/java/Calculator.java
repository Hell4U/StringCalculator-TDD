public class Calculator {
    public int add(String input){

        if(empty(input)){
            return 0;
        } else {
            String[] nums=input.split(",");
            return sum(nums);
        }
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
