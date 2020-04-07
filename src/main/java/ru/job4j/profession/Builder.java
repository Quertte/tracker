package ru.job4j.profession;

public class Builder extends Engineer {

    private int countOfBuildings;

    public Builder(int countOfBuildings) {
        this.countOfBuildings = countOfBuildings;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getCountOfBuildings() {
        return countOfBuildings;
    }

    public boolean buildHouse(Project project) {
        return true;
    }
}
