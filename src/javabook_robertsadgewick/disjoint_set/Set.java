package JavaBook_RobertSadgewick.disjoint_set;

public class Set {
    int rank;
    int parent;

    public Set(int rank, int parent) {
        this.rank = rank;
        this.parent = parent;
    }
}
