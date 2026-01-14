public class StringsRotationsOfEachOther {
    public boolean areRotations(String s1, String s2){
        return new StringBuilder(s1).append(s1).toString().lastIndexOf(s2) >= 0;
    }
}
