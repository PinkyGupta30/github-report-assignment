package github_report_task.dto;

public class RepositoryDto
{
    private Long id;

    private String name;

    private String full_name;

    public RepositoryDto()
    {

    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFull_name()
    {
        return full_name;
    }
    public void setFull_name(String full_name)
    {
        this.full_name = full_name;
    }
}
