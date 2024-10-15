package projectPOO.screenmatch.models;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private List<Episode> episodes;
    private String title;
    private Integer episodesNumber;

    public Season(String title) {
        episodes = new ArrayList<Episode>();
        this.episodesNumber = this.getEpisodesNumber();
        this.title = title;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public Integer getEpisodesNumber() {
        return episodes.size();
    }

    public String getTitle() {
        return title;
    }

    protected String addEpisodes(Episode episode){
        this.episodes.add(episode);
        this.episodesNumber = this.episodes.size();
        return "Episode has been added";
    }

    protected String removeEpisodes(Episode episode){
        this.episodes.remove(episode);
        this.episodesNumber = this.episodes.size();
        return "Episode has been removed";
    }

    protected Episode getEpisode(String title){
        for(Episode episode : episodes){
            if(episode.getTitle().equals(title)){
                return episode;
            }
        }
        return null;
    }

    public String showEpisodes(){
        String msg = "";
        for(Episode episode : episodes){
            msg += "Episode: " + episode.getTitle() + "\n";
        }
        return msg;
    }
}
