package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SaleLog {
    // three behaviours: supply, sell, and return
    // "supply" item_name number price
    // "sell" item_name number
    // "return" item_name number old_price new_price
    public int[] getLog(String[][] logs){
        int[] price_log = new int[logs.length];
        int log_index = 0;
        Map<String, Integer> priceMap = new HashMap<>();
        Map<String, Integer> storeMap = new HashMap<>();
        Map<String, int[]> returnMap = new HashMap<>();
        String[] itemList = new String[logs.length];
        for (int i = 0; i < logs.length; i++) {
            itemList = logs[i];
            int num = Integer.parseInt(itemList[2]);
            String name = itemList[1];
            String behaviour = itemList[0];
            if (behaviour.equals("supply")){
                int price = Integer.parseInt(itemList[3]);
                storeMap.put(name, num);
                priceMap.put(name, price);
            }
            if (behaviour.equals("sell")){
                int sell_price = 0;

                if (returnMap.containsKey(name)){
                    int store_num = returnMap.get(name)[0];
                    if (num >= store_num){
                        sell_price += store_num * returnMap.get(name)[1];
                        returnMap.remove(name);
                        num -= store_num;
                    }
                    else{
                        sell_price += store_num * returnMap.get(name)[1];
                        int[] arr = {store_num-num, returnMap.get(name)[1]};
                        returnMap.put(name, arr);
                        price_log[log_index++] = sell_price;
                        num = 0;
                    }
                }
                if (num >= 0 && num <= storeMap.get(name)){
                    sell_price += num * priceMap.get(name);
                    price_log[log_index++] = sell_price;
                }
            }
            if (behaviour.equals("return")){
                int new_price = Integer.parseInt(itemList[4]);
                int[] tuple = {num, new_price};
                returnMap.put(name, tuple);
            }
        }
        return price_log;
    }

    public static void main(String[] args) {
        SaleLog test = new SaleLog();
        String[][] logs = {{"supply", "A", "2", "60"}, {"sell", "A", "1"},{"return", "A", "2", "60", "40"},
                {"sell", "A", "2"}, {"sell", "A", "1"}};
        int[] arr = test.getLog(logs);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


}
