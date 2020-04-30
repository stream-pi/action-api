package in.dubbadhar.StreamPiPluginAPI;

public abstract class Plugin {
    String name, author, repo, version, description;

    public Plugin(String name, String author, String repo, String version, String description)
    {
        this.name = name;
        this.author = author;
        this.repo = repo;
        this.version = version;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getRepo()
    {
        return repo;
    }

    public String getVersion()
    {
        return version;
    }

    public String getDescription()
    {
        return description;
    }

    public abstract void actionOnClient();
    public abstract void actionOnServer();
}
