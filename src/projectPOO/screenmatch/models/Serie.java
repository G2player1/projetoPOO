package projectPOO.screenmatch.models;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Title implements Classifcation{
    private List<Season> seasons;
    private Integer seasonsNumber;
    private Integer episodesNumber;
    private Status status;

    public Serie(String name, String sinopse, Boolean included, Integer yearOfRelease, Status status) {
        super(name, sinopse, included, yearOfRelease);
        seasons = new ArrayList<Season>();
        this.episodesNumber = episodesNumber;
        this.seasonsNumber = seasonsNumber;
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getEpisodesNumber() {
        int number = 0;
        for(Season season : seasons){
            number += season.getEpisodesNumber();
        }
        return number;
    }

    public Integer getSeasonsNumber() {
        return seasons.size();
    }

    public String addSeason(Season season){
        this.seasons.add(season);
        return "season has been added";
    }

    public String removeSeason(Season season){
        this.seasons.remove(season);
        return "season has been removed";
    }

    public String showSeasons(){
        String msg = "";
        for(Season season : seasons){
            msg += "Season: " + season.getTitle() + "\n";
            msg += season.showEpisodes();
        }
        return msg;
    }

    public String showTechnicalSheet(){
        String technicalSheet =
                "Name: " + this.getName() + "\n" +
                "Year of release: " + this.getYearOfRelease() + "\n" +
                "Review: " + this.getReview() + "\n" +
                "Total of Reviews: " + this.getTotalReviews() + "\n" +
                "Seasons: " + this.seasonsNumber + "\n" +
                "Episodes: " + this.episodesNumber + "\n" +
                "Status: " + this.status + "\n" +
                "Sinopse: \n" + this.getSinopse() + "\n";
        return technicalSheet;
    }

    @Override
    public int getClassification() {
        double review = this.getReview();
        return (int)(review/2);
    }
}
