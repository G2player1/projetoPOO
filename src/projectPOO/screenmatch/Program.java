package projectPOO.screenmatch;

import projectPOO.screenmatch.enums.EmployeePosition;
import projectPOO.screenmatch.enums.Status;
import projectPOO.screenmatch.models.*;

public class Program {
    public static void main(String[] args) {

        String sinopse = """
                Filme de ação com galã dos anos 80
                Muito Bom
                Adorado pela critica
                Lançamento
                """;
        Movie filme = new Movie("Top Gun: Maverick", sinopse, 2022, 143,"Action");
        System.out.println(filme.showTechnicalSheet());

        filme.rate(9.1);
        filme.rate(7.6);
        filme.rate(6.3);
        System.out.println(filme.showTechnicalSheet());

        filme.rate(9.1);
        filme.rate(8.9);
        filme.rate(7.5);
        filme.setSinopse(sinopse + "Relançamento");
        System.out.println(filme.showTechnicalSheet());

        sinopse = """
                serie de ficção adolescente sobre apocalipse espacial
                """;
        Serie serie = new Serie("the 100", sinopse, 2022, Status.COMPLETED,"Utopia");
        System.out.println(serie.showTechnicalSheet());

        serie.rate(9.1);
        serie.rate(7.2);
        serie.rate(4.5);
        System.out.println(serie.showTechnicalSheet());

        Season season1 = new Season("temporada1");
        Season season2 = new Season("temporada2");
        serie.addSeason(season1);
        serie.addSeason(season2);
        for (int i = 1; i <= 10; i++) {
            Episode episode = new Episode(40, "episode" + i, 1 + i - 1);
            serie.addEpisode(season1, episode);
            serie.addEpisode(season2, episode);
        }

        System.out.println(serie.showTechnicalSheet());
        System.out.println(serie.showSeasons());

        serie.removeSeason(season2);
        System.out.println(serie.showTechnicalSheet());
        System.out.println(serie.showSeasons());

        serie.addSeason(season2);
        serie.addEpisode(season2, new Episode(30, "especial de natal", 0));
        System.out.println(serie.showTechnicalSheet());
        System.out.println(serie.showSeasons());

        serie.removeEpisode(serie.getEpisode("especial de natal"));
        System.out.println(serie.showTechnicalSheet());
        System.out.println(serie.showSeasons());

        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee(EmployeePosition.ACTOR, "chuchuquinha" + i);
            System.out.println(serie.addEmployee(employee));
        }
        Employee employee = null;
        System.out.println(serie.addEmployee(employee));
        Employee employee1 = new Employee(EmployeePosition.ACTOR, "chuchuquinha0");
        System.out.println(serie.addEmployee(employee1));

        System.out.println(serie.removeEmployee(employee1));

        System.out.println(serie.addEmployee(employee1));
    }
}
