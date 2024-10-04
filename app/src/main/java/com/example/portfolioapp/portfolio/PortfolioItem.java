package com.example.portfolioapp.portfolio;

import java.io.Serializable;

public class PortfolioItem implements Serializable {
    private final int image;
    private final String title;
    private final String description;
    private final String githubLink; // Add this field for GitHub link
    private final String liveDemoLink; // Add this field for Live Demo link

    public PortfolioItem(int image, String title, String description, String githubLink, String liveDemoLink) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.githubLink = githubLink; // Initialize the GitHub link
        this.liveDemoLink = liveDemoLink; // Initialize the Live Demo link
    }

    // Getters for the fields
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGithubLink() { // Add this getter for GitHub link
        return githubLink;
    }

    public String getLiveDemoLink() { // Add this getter for Live Demo link
        return liveDemoLink;
    }

    public String getLiveDemoUrl() {
        return "";
    }

    public String getGithubUrl() {
        return "";
    }
}
