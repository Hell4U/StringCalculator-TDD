public class Calculator {
    public int add(String input){

        if(empty(input)){
            return 0;
        } else if(input.length()==1){
            return stringToInt(input);
        } else{
            String[] nums=input.split(",");
            return sum(nums);
        }
    }

    private int sum(String[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=stringToInt(nums[i]);
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
