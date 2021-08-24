public class Calculator {
    public int add(String input){
        if(empty(input)){
        return 0;
        } else{
            return stringToInt(input);
        }
    }

    private boolean empty(String input){
        return input.isEmpty();
    }

    private int stringToInt(String num){
        return Integer.parseInt(num);
    }
}
