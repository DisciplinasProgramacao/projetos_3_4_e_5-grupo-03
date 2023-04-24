public class App {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Midia m = new Midia(1, "la casa de papel",LocalDate.now(),2,1);
       System.out.println(m.getGenero());
       System.out.println(m.getIdioma());

    }
}
