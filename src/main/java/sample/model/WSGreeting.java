package sample.model;

public class WSGreeting {
	
	private final long id;
    private final String content;

    public WSGreeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
