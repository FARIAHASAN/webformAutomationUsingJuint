public class system {
    public static void main(String[] args) {
        System.out.println("this is "+System.getProperty("user.dir")+"/src/test/resources/sampleImage.png");
        System.out.println("this is "+System.getProperty("user.dir")+"./src/test/resources/sampleImage.png");
    }
}
