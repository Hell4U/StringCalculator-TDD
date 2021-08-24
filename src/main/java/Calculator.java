public class Calculator {
    public int add(String input){

        if(empty(input)){
            return 0;
        } else if(input.length()==1){
            return stringToInt(input);
        } else{
            String[] nums=input.split(",");
            return Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
        }
    }

    private boolean empty(String input){
        return input.isEmpty();
    }

    private int stringToInt(String num){
        return Integer.parseInt(num);
    }
}
