package projectPOO.screenmatch.models;

public class Movie extends Title {
    private final Integer movieTime;

    public Movie(String name, String sinopse, Boolean included, Integer yearOfRelease, Integer movieTime) {
        super(name, sinopse, included, yearOfRelease);
        this.movieTime = movieTime;
    }

    public Integer getMovieTime() {
        return movieTime;
    }

    @Override
    public void showTechnicalSheet(){
        String technicalSheet = """
                Name: %s
                Year of release: %d
                Review: %.1f
                Total of Reviews: %d
                Viewing Time: %d
                Sinopse: 
                %s \n
                """;
        System.out.printf(technicalSheet,this.getName(),this.getYearOfRelease(),this.getReview(),this.getTotalReviews(),this.movieTime,this.getSinopse());
    }
}
