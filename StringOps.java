import javax.sound.midi.Soundbank;

public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
        System.out.println(capVowelsLowRest("Yellow"));
        System.out.println(capVowelsLowRest("Hello World"));
        System.out.println(capVowelsLowRest("vowels are fun"));

        System.out.println(camelCase("Hello World"));
        System.out.println(camelCase("    tWo     wordS"));
        System.out.println(camelCase(" Intro to coMPUter sCIEncE "));
        System.out.println(camelCase("world"));

        int[] arr = allIndexOf("Hello World", 'd');
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }



    }

    public static String capVowelsLowRest (String string) {
        String newString = "";
        for (int i=0; i<string.length(); i++){
            if (string.charAt(i) == ' '){
                newString += string.charAt(i);
            }
            else if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u' ){
                newString += (char) (string.charAt(i) - 32);
            }
            else if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U'){
                newString += string.charAt(i);

            }
            else if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                newString += (char) (string.charAt(i) + 32);
            }
            else{
                newString += string.charAt(i);
            }
        }
        return newString;
    }

    public static String camelCase (String string) {
        String newString ="";
        boolean afterSpace = false;
        boolean firstWord = true;
        boolean firstSpace = false;
        int index = 0;
        for (int i=0; i<string.length(); i++){
            if(string.charAt(i) != ' '){
                index = i;
                break;
            }

        }
        for (int i=index; i<string.length() && firstWord; i++){
            if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                newString += (char) (string.charAt(i) + 32);
            }
            else if (string.charAt(i) == ' '){
                index = i;
                firstWord = false;
                afterSpace = true;
            }
            else newString += string.charAt(i);
        }
        if(firstWord == false){
        for (int j = (index+1); j<string.length(); j++){
            if(string.charAt(j) >= 'a' && string.charAt(j) <= 'z' && afterSpace){
                newString += (char) (string.charAt(j) - 32);
                afterSpace = false;
            }
            else if(string.charAt(j) >= 'A' && string.charAt(j) <= 'Z' && afterSpace){
                newString += string.charAt(j);
                afterSpace = false;
            }
            else if(string.charAt(j) == ' '){
                afterSpace = true;
            }
            else if(string.charAt(j) >= 'A' && string.charAt(j) <= 'Z'){
                newString += (char) (string.charAt(j) + 32);
            }
            else
                newString += string.charAt(j);
        }
        }
        return newString;
    }

    public static int[] allIndexOf (String string, char chr) {
        int counter = 0;
        int index = 0;
        for (int i=0; i<string.length(); i++){
            if(string.charAt(i) == chr)
                counter++;
        }

        int[] array = new int[counter];
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i) == chr){
                array[index] = i;
                index ++;
            }
        }
        return array;
    }
}
