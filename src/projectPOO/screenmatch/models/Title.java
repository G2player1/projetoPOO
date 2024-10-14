package projectPOO.screenmatch.models;

public class Title{
    private final String name;
    private final Integer yearOfRelease;
    private String sinopse;
    private Boolean included;
    private Double review;
    private Double reviewSum;
    private Integer totalReviews;

    public Title(String name, String sinopse, Boolean included, Integer yearOfRelease) {
        this.review = 0.0;
        this.totalReviews = 0;
        this.reviewSum = 0.0;
        this.name = name;
        this.sinopse = sinopse;
        this.included = included;
        this.yearOfRelease = yearOfRelease;
    }

    public Boolean getIncluded() {
        return included;
    }

    public String getName() {
        return name;
    }

    public Double getReview() {
        return review;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setIncluded(Boolean included) {
        this.included = included;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void rate(double rating){
        totalReviews++;
        reviewSum += rating;
        review = reviewSum/totalReviews;
    }

    public String showTechnicalSheet(){
        String technicalSheet =
                "Name: " + this.getName() + "\n" +
                        "Year of release: " + this.getYearOfRelease() + "\n" +
                        "Review: " + this.getReview() + "\n" +
                        "Total of Reviews: " + this.getTotalReviews() + "\n" +
                        "Sinopse: \n" + this.getSinopse() + "\n";
        return technicalSheet;
    }
}
