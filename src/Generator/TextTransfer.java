package Generator;

public class TextTransfer {
    public String convertStringArr(String[] arr){
        String storage = "";
        for (int i = 0; i < arr.length; i++) {
            storage = storage + arr[i];
            storage = storage + "\\\\";
        }

        return storage;
    }

}
