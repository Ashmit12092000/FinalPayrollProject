package Manager;

public class practiec{
    public static void main(String[] args) {
        String url="Ashmit%20Singh%20x";
        //Pattern pattern=Pattern.compile("(%2F)..*(%2F)");
       // Matcher matcher=pattern.matcher(url);
        System.out.println(url.replace("%20"," ")) ;
    }
}