package dynamicprogramming;

public class ScambledString {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        if(s1.length() == 0)
            return true;
        return scramble(s2, s2);
    }
    
    private boolean scramble(String s1, String s2)
    {
        if(s1.length() == 0)
            return true;
        if(s1.length() == 1)
            return s1.equals(s2);
        boolean res = false;
        for(int split = 1; split < s1.length(); split++)
        {
            String s11 = s1.substring(0, split);
            String s21 = s2.substring(0, split);
            
            String s12 = s1.substring(split, s1.length());
            String s22 = s1.substring(split, s1.length());
            res |= scramble(s11, s21) && scramble(s12, s22);
            
            s21 = s2.substring(s1.length() - split, s1.length());
            s22 = s2.substring(0, s1.length() - split);
            
            res |= scramble(s11, s21) && scramble(s12, s22);
        }
        return res;
    }
}
