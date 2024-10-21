package projectPOO.screenmatch.models;

import projectPOO.screenmatch.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Title{
    private List<Season> seasons;
    private Integer seasonsNumber;
    private Integer episodesNumber;
    private Status status;

    public Serie(String name, String sinopse, Integer yearOfRelease, Status status, String genres) {
        super(name, sinopse, yearOfRelease,genres);
        seasons = new ArrayList<Season>();
        this.episodesNumber = this.getEpisodesNumber();
        this.seasonsNumber = this.getSeasonsNumber();
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String addEpisode(Season season,Episode episode){
        int index = this.seasons.indexOf(season);
        String msg = seasons.get(index).addEpisodes(episode);
        this.episodesNumber = this.getEpisodesNumber();
        return msg;
    }

    public String removeEpisode(Episode episode){
        String msg;
        for(Season season : seasons){
            if(season.getEpisodes().contains(episode)){
                msg = season.removeEpisodes(episode);
                return msg;
            }
        }
        return  "episode cannot be removed";
    }

    public Episode getEpisode(String title){
        for(Season season : seasons){
            Episode episode = season.getEpisode(title);
            if(episode != null){
                return episode;
            }
        }
        return null;
    }

    public String addSeason(Season season){
        this.seasons.add(season);
        this.seasonsNumber = seasons.size();
        this.episodesNumber = this.getEpisodesNumber();
        return "Season has been added";
    }

    public String removeSeason(Season season){
        this.seasons.remove(season);
        this.seasonsNumber = seasons.size();
        this.episodesNumber = this.getEpisodesNumber();
        return "Season has been removed";
    }

    public Season getSeason(String title){
        for(Season season : seasons){
            if(season.getTitle().equals(title)){
                return season;
            }
        }
        return null;
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

    public String showSeasons(){
        String msg = "";
        for(Season season : seasons){
            msg += "Season: " + season.getTitle() + "\n";
            msg += season.showEpisodes();
        }
        return msg;
    }

    @Override
    public String showTechnicalSheet(){
        return "Name: " + this.getName() + "\n" +
                        "Genre(s): " + this.getGenres() + "\n" +
                        "Year of release: " + this.getYearOfRelease() + "\n" +
                        "Review: " + this.getReview() + "\n" +
                        "Total of Reviews: " + this.getTotalReviews() + "\n" +
                        "Seasons: " + this.seasonsNumber + "\n" +
                        "Episodes: " + this.episodesNumber + "\n" +
                        "Status: " + this.status + "\n" +
                        "Popularity: " + this.getPopularity() + "\n" +
                        "Sinopse: \n" + this.getSinopse() + "\n";
    }
}
