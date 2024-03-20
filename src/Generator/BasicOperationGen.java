package Generator;

public class BasicOperationGen {
    /*
    public static void main(String[] args) {
        int total_n = 20;
        int highest_num = 10;
        int lowest_num = 2;

        String directory = "C:\\Desktop\\Gen\\";
        String fileName = "5";
        String fileType = ".tex";
        String pathname = directory+fileName+fileType;

        LaTeXGen laTeXGen = new LaTeXGen();
        laTeXGen.LaTeXFileBegin(pathname);

        BasicOperationGen test = new BasicOperationGen();

        String[] addition_contents = test.additionGen(lowest_num,highest_num);
        String[] subtract_contents = test.subtractGen(lowest_num,highest_num);

        String[] addition = test.randomFormula(addition_contents, total_n);
        String[] subtraction = test.randomFormula(subtract_contents, total_n);

        String[] multi_addition = new String[total_n];
        String[] add_sub_contents = new String[total_n];
        for (int i = 0; i < total_n; i++) {
            multi_addition[i] = test.addMultiGen(lowest_num,highest_num, 3);
            add_sub_contents[i] = test.addAndSubtractionGen(lowest_num, highest_num, (int) (highest_num * Math.random()));
        }

        TextTransfer converter = new TextTransfer();

        String texts = converter.convertStringArr(addition);
        texts += converter.convertStringArr(subtraction);
        texts += converter.convertStringArr(multi_addition);
        texts += converter.convertStringArr(add_sub_contents);

        ContentWriter writer = new ContentWriter();

        writer.LaTeXMultipleColumnBegin(pathname, 2);

        writer.LaTexNoIndent(pathname);

        writer.append(pathname, texts);

        writer.LaTeXMultipleColumnEnd(pathname);

        laTeXGen.LaTeXFileEnd(pathname);

    }

     */


    // generate a + b = sum;
    public String additionGen(int sum){
        int a = (int) (sum *Math.random());
        int b = sum - a;
        return "$"+a+"+"+b+"=$";
    }


    // generate a - b =
    public String subtractGen(int a){
        int b = (int) (a *Math.random());
        return "$"+a+"-"+b+"=$";
    }

    // a_1 + a_2 + ... + a_n = result;
    public String addMultiGen(int result, int num){
        if (num > result){
            System.out.println("the possible case is too small");
            return null;
        }

        String formula = "$";
        for (int i = 0; i < num - 1; i++) {
            int temp = (int) (result*Math.random());
            formula = formula + temp;
            result = result - temp;
            formula = formula +"+";
        }
        formula = formula + result+"=$";
        return formula;

    }

    // generate the non-negative result by given result from lowest to highest

    // a + b - c = result
    public String addAndSubtractionGen(int lowest, int highest, int result){
        int range = highest - lowest;
        int a = (int) (lowest + range *Math.random());
        int b = (int) (lowest + range *Math.random());

        while (a+b-result < 0 || a+b > highest){
            a = (int) (lowest + range * Math.random());
            b = (int) (lowest + range * Math.random());
        }
        return  "$"+ a + "+" + b + "-" + (a+b-result) +"=$";
    }

    //


}
