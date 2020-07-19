package ru.qa.addressbook.model;

public class GroupData {


    private final String name;
    private final String header;
    private final String footer;
    private int id;

    public int getId() {
        return id;
    }


    public GroupData(String name, String header, String footer, int id) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = id;
    }

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
