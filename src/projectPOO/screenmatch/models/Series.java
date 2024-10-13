package projectPOO.screenmatch.models;

public class Series extends Title{
    private Integer seasonsNumber;
    private Integer episodesNumber;

    public Series(String name, String sinopse, Boolean included, Integer yearOfRelease, Integer episodesNumber, Integer seasonsNumber) {
        super(name, sinopse, included, yearOfRelease);
        this.episodesNumber = episodesNumber;
        this.seasonsNumber = seasonsNumber;
    }

    public Integer getEpisodesNumber() {
        return episodesNumber;
    }

    public void setEpisodesNumber(Integer episodesNumber) {
        this.episodesNumber = episodesNumber;
    }

    public Integer getSeasonsNumber() {
        return seasonsNumber;
    }

    public void setSeasonsNumber(Integer seasonsNumber) {
        this.seasonsNumber = seasonsNumber;
    }

    public void showTechnicalSheet(){
        String technicalSheet = """
                Name: %s
                Year of release: %d
                Review: %.1f
                Total of Reviews: %d
                Seasons: %d
                Episodes: %d
                Sinopse: 
                %s \n
                """;
        System.out.printf(technicalSheet,this.getName(),this.getYearOfRelease(),this.getReview(),this.getTotalReviews(),this.seasonsNumber,this.episodesNumber,this.getSinopse());
    }
}
