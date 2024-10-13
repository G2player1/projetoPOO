import projectPOO.screenmatch.models.Movie;
import projectPOO.screenmatch.models.Series;

public class Program {
    public static void main(String[] args) {

        String sinopse = """
                Filme de ação com galã dos anos 80
                Muito Bom
                Adorado pela critica
                Lançamento
                """;
        Movie filme = new Movie("Top Gun: Maverick",sinopse,true,2022,143);
        filme.showTechnicalSheet();

        filme.rate(9.1);
        filme.rate(7.6);
        filme.rate(6.3);
        filme.showTechnicalSheet();

        filme.rate(9.1);
        filme.rate(8.9);
        filme.rate(7.5);
        filme.setSinopse(sinopse + "Relançamento");
        filme.showTechnicalSheet();

        sinopse = """
                serie de ficção adolescente sobre apocalipse espacial
                """;
        Series serie = new Series("the 100",sinopse,false,2022,143,8);
        serie.showTechnicalSheet();

        serie.rate(9.1);
        serie.rate(7.2);
        serie.rate(4.5);
        serie.showTechnicalSheet();

        serie.rate(10);
        serie.rate(6.3);
        serie.rate(5);
        serie.showTechnicalSheet();
    }
}
