public class Four_Letter_Words_Mutations {
    public static boolean Check(String word1, String word2) {
        if(word2.charAt(0) == '*')
            return false;
        int cnt = 0;
        for(int i=0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        else
            return false;
    }

    public static void Kill(String[] arr) {
        for(int i=0; i < arr.length; i++) {
            if(arr[i].charAt(0) == arr[i].charAt(1) || arr[i].charAt(0) == arr[i].charAt(2) || arr[i].charAt(0) == arr[i].charAt(3)
                    || arr[i].charAt(1) == arr[i].charAt(2) || arr[i].charAt(1) == arr[i].charAt(3) || arr[i].charAt(2) == arr[i].charAt(3))
                arr[i] = "****";
        }
    }

    public static void removeWord(String[] arr, String word) {
        for(int i=0; i < arr.length; i++) {
            if(arr[i].equals(word)){
                arr[i] = "****";
                break;
            }
        }
    }

    public static int mutations(String[] alice, String[] bob, String word, int first) {
        Kill(alice);
        Kill(bob);
        int cnt = 0;
        boolean flagA = false, flagB = false;
        removeWord(bob, word);
        removeWord(alice, word);
        while(true) {

            cnt++;
            if(first == 0) {
                for(int i=0; i < alice.length; i++) {
                    if(Check(word, alice[i])) {
                        if(cnt == 2 && !flagB)
                            return 0;
                        flagA = true;
                        word = alice[i];
                        removeWord(bob, word);
                        alice[i] = "****";
                        first = 1;
                        break;
                    } else if(i == alice.length - 1 && cnt != 1) {
                        if(cnt == 2 && !flagB)
                            return -1;
                        return 1;
                    }

                    first = 1;
                }
            } else if(first == 1) {
                for(int i=0; i < bob.length; i++) {
                    if(Check(word, bob[i])) {
                        if(cnt == 2 && !flagA)
                            return 1;
                        flagB = true;
                        word = bob[i];
                        removeWord(alice, word);
                        bob[i] = "****";
                        first = 0;
                        break;
                    } else if(i == bob.length - 1 && cnt != 1) {
                        if(cnt == 2 && !flagA)
                            return -1;
                        return 0;
                    }
                    first = 0;
                }

            }
        }
    }
}
