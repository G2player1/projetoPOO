package projectPOO.screenmatch.models;

import projectPOO.screenmatch.Interfaces.Classifcation;
import projectPOO.screenmatch.enums.Popularity;

public class RecommendedFilter {

    public Popularity filter(Classifcation classifcated){
        if(classifcated.getClassification() >= 4){
            return Popularity.TOP_TRENDING;
        } else if (classifcated.getClassification() < 4 && classifcated.getClassification() >= 3){
            return Popularity.WELL_RATED;
        } else {
            return  Popularity.OUT_OF_TRENDING;
        }
    }
}
