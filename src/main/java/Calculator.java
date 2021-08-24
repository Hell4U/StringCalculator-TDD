
public class Calculator {
    public int add(String input){
        String delimiters="[,\n]";
        String[] nums=null;
        if(input.matches("//(.)\n(.*)")){

            char randomDelimiter=input.charAt(2);
            String newInput=input.substring(4);

            String[] vals=splitter(newInput,Character.toString(randomDelimiter));
            return sum(vals);
        }
        else if(empty(input)){
            return 0;
        } else {
            nums=splitter(input,delimiters);
            return sum(nums);
        }
    }

    private String[] splitter(String input, String delimiters){
        return input.split(delimiters);
    }

    private int sum(String[] nums){
        int sum=0;
        StringBuffer negativeNumber = new StringBuffer("");
        for(String values:nums){
            if(stringToInt(values)<0){
                if(negativeNumber.toString().isEmpty()){
                    negativeNumber.append(values);
                }else{
                    negativeNumber.append(","+values);
                }
            }else{
            sum+=stringToInt(values);
            }
        }
        if(!negativeNumber.toString().isEmpty()){
           throw new IllegalArgumentException("negative not allowed: "+negativeNumber);
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
