public class Zero {
    public int solution_01(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for(char x : str.toCharArray()) {
            if(x == t) answer++;
        }
        return answer;
    }

    public String solution_02(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
            if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
            else answer += Character.toLowerCase(x);
        }
        return answer;
    }

    public String solution03(String str) {
        int longLetterCnt = 0;
        String token = " ";
        String word = "";
        String[] tokenizedStr = str.split(token);
        for(String element : tokenizedStr) {
            int wordCnt = element.length();
            if(longLetterCnt < wordCnt) { 
                longLetterCnt = wordCnt; 
                word = element;
            }
        }
        return word;
    }

    public String solution04(String str) {
        String myStr = new StringBuilder(str).reverse().toString();
        return myStr;
    }

    public String solution04_2(String str) {
        int left = 0;
        int right = str.length() - 1;

        char[] strCharArr = str.toCharArray();
        while(left < right) {
            char temp = strCharArr[left];
            strCharArr[left] = strCharArr[right];
            strCharArr[right] = temp;
            left++;
            right--;
        }

        return new String(strCharArr);
    }

    public String solution05(String str) {
        int left = 0, right = str.length() - 1;
        char[] strCharArr = str.toCharArray();
        while(left < right) {
            if(!Character.isAlphabetic(strCharArr[left])) left++;
            else if(!Character.isAlphabetic(strCharArr[right])) right--;
            else {
                char temp = strCharArr[left];
                strCharArr[left] = strCharArr[right];
                strCharArr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(strCharArr);
    }

    public String solution06(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            if(i == str.indexOf(str.charAt(i))) answer += str.charAt(i);
        }
        return answer;
    }

    // 회문 문자열, i < str.length / 2
    public String solution07(String str) {
        boolean isHoemoon = true;
        str = str.toUpperCase();
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isHoemoon = false;
                break;
            }
        }
        return isHoemoon ? "YES" : "NO";
    }

    // 회문, 알파벳 아닌것들은 제외시키기
    public String solution08(String str) {
        boolean isHoemoon = true;
        str = str.replaceAll("[^a-zA-Z]", "");
        System.out.println(str);
        str = str.toUpperCase();
        System.out.println(str);
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isHoemoon = false;
                break;
            }
        }
        return isHoemoon ? "YES" : "NO";
    }

    public int solution09(String str) {
        str = str.replaceAll("[a-zA-Z]", "");
        return Integer.parseInt(str);
    }

    // 
    public int[] solution10(String str, char c) {
        int[] result = new int[str.length()];
        int p = 1001;
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) == c) {
                p = 0;
                result[i] = p;
            } else {
                p++;
                result[i] = p;
            }
        }
        
        p = 1001;
        for(int j = str.length() - 1; j >= 0; j--) {
            if(str.charAt(j) == c) p = 0;
            else {
                p++;
                result[j] = Math.min(result[j], p);
            }
        }
        return result;
    }

    public String solution11(String str) {
        str += " ";
        String answer = "";
        int checker = 1;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                checker++;
            }
            else {
                answer += str.charAt(i);
                if(checker > 1) answer += checker;
                checker = 1;
            }
        }
        return answer;
    }

    public String solution12(int wordCnt, String cyperText) {
        String answer = "";
        for(int i = 0; i<wordCnt; i++) {
            String word = cyperText.substring(0, 7)
                            .replace("#", "1")
                            .replace("*", "0");
            int asciiNum = Integer.parseInt(word, 2);
            char character = (char)asciiNum;
            answer += character;
            cyperText = cyperText.substring(7);
        }
        return answer;
    }
}
