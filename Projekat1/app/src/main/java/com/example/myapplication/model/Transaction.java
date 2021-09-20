package com.example.myapplication.model;

import java.util.Objects;
import java.util.UUID;

public class Transaction {

    private UUID uuid;
    private String type;
    private Integer value;
    private String title;
    private String description;

    public Transaction() {
    }

    public Transaction(String type, Integer value, String title, String description) {
        this.uuid = UUID.randomUUID();
        this.type = type;
        this.value = value;
        this.title = title;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uuid=" + uuid +
                ",      type='" + type + '\'' +
                ",      value=" + value +
                ",      title='" + title + '\'' +
                ",      description='" + description + '\'' +
                "}\n ----------------------------------------------------------------------------------";
    }
}
