public enum StudentRank {
    EXCELLENT(9),
    GOOD(8),
    FAIR(7),
    POOR(6),
    BAD(5),
    VERY_BAD(0),
    NONE(-1);

    private float grade;

    StudentRank(float grade) {
        this.grade = grade;
    }
    public static StudentRank getRankByGrade(float grade ){
        for (StudentRank rank: StudentRank.values()){
            if(grade >= rank.grade) {
                return rank;
            }
        }
        return null;
    }
}
