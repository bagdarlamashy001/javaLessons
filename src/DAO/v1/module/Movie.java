package DAO.v1.module;

public class Movie {
    int id;
    String nameKz, description;

    public Movie(){}
    public Movie(int id, String nameKz, String description) {
        this.id = id;
        this.nameKz = nameKz;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameKz='" + nameKz + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
