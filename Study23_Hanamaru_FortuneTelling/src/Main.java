import com.sun.org.apache.xpath.internal.operations.Bool;

import java.text.Format;
import java.util.Scanner;

public class Main {

    final static String TITLE = "******************************************\r\n" +
            "*              はなまる占い              *\r\n" +
            "******************************************";
    final static String FORTUNE_TELLER = "占い師「%s」";
    final static String ENDDING_TEXT = "※あくまで独自で考えた占い結果です。\r\n" +
            "科学的な根拠はないためエンターテインメントとしてお楽しみください。\r\n";


    public static void main(String[] args) {
        Boolean appEnd = false;

        System.out.println(TITLE);
        System.out.println(ENDDING_TEXT);
        while(!appEnd){
            appEnd = Home();
        }
    }

    private static Boolean Home(){
        boolean result = false;
        FortuneTeller("何ヲ占ッテホシイ…？");
        System.out.println();
        System.out.println(" １．相性占い");
        System.out.println(" ０．終わる");
        System.out.println();

        Scanner inputStr = new Scanner(System.in);
        String selectMenu = inputStr.nextLine();
        System.out.println();

        switch (selectMenu){
            case "0":
                FortuneTeller("…ソウカ");
                result = true;
                break;
            case "1":
                FortuneTeller("ヨカロウ…");
                Fortune(selectMenu);
                break;
            default:
                FortuneTeller("………？");
                break;
        }

        return result;
    }

    private static void Fortune(String selectMenu) {
        String target01, target02;
//      １．相性占い
        String targetBirthday01, targetBirthday02;
        int targetBirthdayMonth01, targetBirthdayDate01, targetBirthdayMonth02, targetBirthdayDate02;

//        １．相性占い
        if (selectMenu.equals("1")) {

            System.out.println();
            System.out.println("******************************************\r\n" +
                    "*              １．相性占い              *\r\n" +
                    "******************************************\r\n");
            FortuneTeller("占ウ１人目ノ名前ハ？");
            target01 = new Scanner(System.in).nextLine();

            targetBirthday01 = "";
            targetBirthdayMonth01 = 0;
            targetBirthdayDate01 = 0;
            Boolean askTargetBirthday = true;
            while (askTargetBirthday) {
                System.out.println();
                FortuneTeller("占ウ１人目ノ誕生シタ日付ハ？(MM/DD)");
                targetBirthday01 = new Scanner(System.in).nextLine();
                String[] inputDates = targetBirthday01.split("/");
                if (inputDates.length == 2) {
                    targetBirthdayMonth01 = Integer.parseInt(inputDates[0]);
                    targetBirthdayDate01 = Integer.parseInt(inputDates[1]);
                    askTargetBirthday = false;
                } else if (inputDates.length == 3) {
                    targetBirthdayMonth01 = Integer.parseInt(inputDates[1]);
                    targetBirthdayDate01 = Integer.parseInt(inputDates[2]);
                    askTargetBirthday = false;
                } else {
                    System.out.println();
                    FortuneTeller("MM/DDデ日付ガ欲シイ");
                }
            }

            System.out.println();
            FortuneTeller("占ウ２人目ノ名前ハ？");
            target02 = new Scanner(System.in).nextLine();

            targetBirthday02 = "";
            targetBirthdayMonth02 = 0;
            targetBirthdayDate02 = 0;
            askTargetBirthday = true;
            while (askTargetBirthday) {
                System.out.println();
                FortuneTeller("占ウ２人目ノ誕生シタ日付ハ？(MM/DD)");
                targetBirthday02 = new Scanner(System.in).nextLine();
                String[] inputDates = targetBirthday02.split("/");
                if (inputDates.length == 2) {
                    targetBirthdayMonth02 = Integer.parseInt(inputDates[0]);
                    targetBirthdayDate02 = Integer.parseInt(inputDates[1]);
                    askTargetBirthday = false;
                } else if (inputDates.length == 3) {
                    targetBirthdayMonth02 = Integer.parseInt(inputDates[1]);
                    targetBirthdayDate02 = Integer.parseInt(inputDates[2]);
                    askTargetBirthday = false;
                } else {
                    System.out.println();
                    FortuneTeller("MM/DDデ日付ガ欲シイ");
                }
            }

            System.out.println();
            FortuneTeller("ヨカロウ…");
            System.out.println("……");

            int totalNumbers = targetBirthdayMonth01 + targetBirthdayDate01
                    + targetBirthdayMonth02 + targetBirthdayDate02;
            String compatibility = String.valueOf(totalNumbers);
            String[] compatibilityArray = compatibility.split("");
            int tensPlace = 0;
            int compatibilityPercent;
            if(compatibilityArray.length ==1){
                compatibilityPercent = Integer.valueOf(compatibilityArray[0]);
            }else{
                tensPlace = Integer.valueOf(compatibilityArray[0]);
                compatibilityPercent = Integer.valueOf(compatibilityArray[1]);
            }

            if(compatibilityPercent == 0 && tensPlace <= 40){
                compatibilityPercent = 100;
            }else if(compatibilityPercent == 0 && tensPlace >= 50){
                compatibilityPercent = 0;
            }else{
                compatibilityPercent = compatibilityPercent*10;
            }

            FortuneTeller(String.format(" %s ト %s ノ相性ガ出タゾ", target01, target02));
            String compatybilityResult = "------------------------------------------\r\n" +
                    "|                 %3d ％                 |\r\n" +
                    "------------------------------------------\r\n";
            System.out.println(String.format(compatybilityResult, compatibilityPercent));

        }
    }

    private static void CompatibilityFortune(){
        int targetBirthdayMonth01 = 0;
        int targetBirthdayDate01 = 0;
        int targetBirthdayMonth02 = 0;
        int targetBirthdayDate02 = 0;
        int totalNumbers = targetBirthdayMonth01 + targetBirthdayDate01
                + targetBirthdayMonth02 + targetBirthdayDate02;
        String compatibility = String.valueOf(totalNumbers);
        String[] compatibilityArray = compatibility.split("");
        int tensPlace = 0;
        int compatibilityPercent;
        if(compatibilityArray.length ==1){
            compatibilityPercent = Integer.valueOf(compatibilityArray[0]);
        }else{
            tensPlace = Integer.valueOf(compatibilityArray[0]);
            compatibilityPercent = Integer.valueOf(compatibilityArray[1]);
        }

        if(compatibilityPercent == 0 && tensPlace <= 40){
            compatibilityPercent = 100;
        }else if(compatibilityPercent == 0 && tensPlace >= 50){
            compatibilityPercent = 0;
        }else{
            compatibilityPercent = compatibilityPercent*10;
        }




    }


    private static void FortuneTeller(String lines){
        if(!lines.isEmpty()){
            System.out.println(String.format(FORTUNE_TELLER,lines));
        }
    }
}
