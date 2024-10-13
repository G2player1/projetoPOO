public class Program {
    public static void main(String[] args) {
        Movie filme = new Movie("Top Gun: Maverick",2022,true,143);
        filme.showTechnicalSheet();

        filme.rateMovie(9.1);
        filme.rateMovie(7.6);
        filme.rateMovie(6.3);
        filme.showTechnicalSheet();

        filme.rateMovie(9.1);
        filme.rateMovie(8.9);
        filme.rateMovie(7.5);
        filme.showTechnicalSheet();
    }
}
