package edu.pro.jpa.samples.cards.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {

    @Id
    private long id;
    private String language;
    private String content;
    private String transcription;
    private String definition;

    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public void setLanguage(String language) { this.language = language; }
    public String getLanguage() { return language; }

    public void setContent(String content) { this.content = content; }
    public String getContent() { return content; }

    public void setTranscription(String transcription) { this.transcription = transcription; }
    public String getTranscription() { return transcription; }

    public void setDefinition(String definition) { this.definition = definition; }
    public String getDefinition() { return definition; }
}
