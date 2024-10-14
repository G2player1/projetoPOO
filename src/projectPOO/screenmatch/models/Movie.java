package projectPOO.screenmatch.models;

public class Movie extends Title implements Classifcation{
    private final Integer movieTime;

    public Movie(String name, String sinopse, Boolean included, Integer yearOfRelease, Integer movieTime) {
        super(name, sinopse, included, yearOfRelease);
        this.movieTime = movieTime;
    }

    public Integer getMovieTime() {
        return movieTime;
    }

    @Override
    public String showTechnicalSheet(){
        String technicalSheet =
                "Name: " + this.getName() + "\n" +
                        "Year of release: " + this.getYearOfRelease() + "\n" +
                        "Review: " + this.getReview() + "\n" +
                        "Total of Reviews: " + this.getTotalReviews() + "\n" +
                        "Viewing time: " + this.movieTime + "\n" +
                        "Sinopse: \n" + this.getSinopse() + "\n";
        return technicalSheet;
    }

    @Override
    public int getClassification() {
        double review = this.getReview();
        return (int)(review/2);
    }
}
