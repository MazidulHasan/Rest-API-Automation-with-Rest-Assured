package pojo;

public class PostApiPojo {
    private String name;
    private String job;
    private int id;
    private String createdAt;

    public PostApiPojo(String name, String job, int id, String createdAt) {
        this.name = name;
        this.job = job;
    }
    public PostApiPojo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
