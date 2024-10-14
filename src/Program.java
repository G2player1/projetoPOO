import projectPOO.screenmatch.models.*;

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
        Serie serie = new Serie("the 100",sinopse,false,2022,Status.COMPLETED);
        serie.showTechnicalSheet();

        serie.rate(9.1);
        serie.rate(7.2);
        serie.rate(4.5);
        serie.showTechnicalSheet();

        Season season1 = new Season(serie,"temporada1");
        Episode episode1 = new Episode(100,"episodio1",1,1,serie,season1);
        season1.addEpisode(episode1);
        serie.addSeason(season1);

        System.out.println(serie.showTechnicalSheet());
        System.out.println(serie.showSeasons());


    }
}
