package pkkkw.zadanie3;

public class Analysis {
    private long upperCase;
    private String stringToCheck;
    private long lowerCase;
    private long countNumber;
    private long specialMarks;
    private boolean hasCombination;


    public Analysis(long upperCase, String stringToCheck, long lowerCase, long countNumber, long specialMarks, boolean hasCombination) {
        this.upperCase = upperCase;
        this.stringToCheck = stringToCheck;
        this.lowerCase = lowerCase;
        this.countNumber = countNumber;
        this.specialMarks = specialMarks;
        this.hasCombination = hasCombination;
    }
}
