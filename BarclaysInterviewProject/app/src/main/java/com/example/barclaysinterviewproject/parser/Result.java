package com.example.barclaysinterviewproject.parser;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DrakeBoltz on 11/14/2016.
 */


public class Result implements Serializable
{
    private String wrapperType;

    public String getWrapperType() { return this.wrapperType; }

    public void setWrapperType(String wrapperType) { this.wrapperType = wrapperType; }

    private String kind;

    public String getKind() { return this.kind; }

    public void setKind(String kind) { this.kind = kind; }

    private int artistId;

    public int getArtistId() { return this.artistId; }

    public void setArtistId(int artistId) { this.artistId = artistId; }

    private int trackId;

    public int getTrackId() { return this.trackId; }

    public void setTrackId(int trackId) { this.trackId = trackId; }

    private String artistName;

    public String getArtistName() { return this.artistName; }

    public void setArtistName(String artistName) { this.artistName = artistName; }

    private String trackName;

    public String getTrackName() { return this.trackName; }

    public void setTrackName(String trackName) { this.trackName = trackName; }

    private String trackCensoredName;

    public String getTrackCensoredName() { return this.trackCensoredName; }

    public void setTrackCensoredName(String trackCensoredName) { this.trackCensoredName = trackCensoredName; }

    private String artistViewUrl;

    public String getArtistViewUrl() { return this.artistViewUrl; }

    public void setArtistViewUrl(String artistViewUrl) { this.artistViewUrl = artistViewUrl; }

    private String trackViewUrl;

    public String getTrackViewUrl() { return this.trackViewUrl; }

    public void setTrackViewUrl(String trackViewUrl) { this.trackViewUrl = trackViewUrl; }

    private String previewUrl;

    public String getPreviewUrl() { return this.previewUrl; }

    public void setPreviewUrl(String previewUrl) { this.previewUrl = previewUrl; }

    private String artworkUrl30;

    public String getArtworkUrl30() { return this.artworkUrl30; }

    public void setArtworkUrl30(String artworkUrl30) { this.artworkUrl30 = artworkUrl30; }

    private String artworkUrl60;

    public String getArtworkUrl60() { return this.artworkUrl60; }

    public void setArtworkUrl60(String artworkUrl60) { this.artworkUrl60 = artworkUrl60; }

    private String artworkUrl100;

    public String getArtworkUrl100() { return this.artworkUrl100; }

    public void setArtworkUrl100(String artworkUrl100) { this.artworkUrl100 = artworkUrl100; }

    private double collectionPrice;

    public double getCollectionPrice() { return this.collectionPrice; }

    public void setCollectionPrice(double collectionPrice) { this.collectionPrice = collectionPrice; }

    private double trackPrice;

    public double getTrackPrice() { return this.trackPrice; }

    public void setTrackPrice(double trackPrice) { this.trackPrice = trackPrice; }

    private Date releaseDate;

    public Date getReleaseDate() { return this.releaseDate; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    private String collectionExplicitness;

    public String getCollectionExplicitness() { return this.collectionExplicitness; }

    public void setCollectionExplicitness(String collectionExplicitness) { this.collectionExplicitness = collectionExplicitness; }

    private String trackExplicitness;

    public String getTrackExplicitness() { return this.trackExplicitness; }

    public void setTrackExplicitness(String trackExplicitness) { this.trackExplicitness = trackExplicitness; }

    private int trackTimeMillis;

    public int getTrackTimeMillis() { return this.trackTimeMillis; }

    public void setTrackTimeMillis(int trackTimeMillis) { this.trackTimeMillis = trackTimeMillis; }

    private String country;

    public String getCountry() { return this.country; }

    public void setCountry(String country) { this.country = country; }

    private String currency;

    public String getCurrency() { return this.currency; }

    public void setCurrency(String currency) { this.currency = currency; }

    private String primaryGenreName;

    public String getPrimaryGenreName() { return this.primaryGenreName; }

    public void setPrimaryGenreName(String primaryGenreName) { this.primaryGenreName = primaryGenreName; }

    private Integer collectionId;

    public Integer getCollectionId() { return this.collectionId; }

    public void setCollectionId(Integer collectionId) { this.collectionId = collectionId; }

    private String collectionName;

    public String getCollectionName() { return this.collectionName; }

    public void setCollectionName(String collectionName) { this.collectionName = collectionName; }

    private String collectionCensoredName;

    public String getCollectionCensoredName() { return this.collectionCensoredName; }

    public void setCollectionCensoredName(String collectionCensoredName) { this.collectionCensoredName = collectionCensoredName; }

    private String collectionViewUrl;

    public String getCollectionViewUrl() { return this.collectionViewUrl; }

    public void setCollectionViewUrl(String collectionViewUrl) { this.collectionViewUrl = collectionViewUrl; }

    private Integer discCount;

    public Integer getDiscCount() { return this.discCount; }

    public void setDiscCount(Integer discCount) { this.discCount = discCount; }

    private Integer discNumber;

    public Integer getDiscNumber() { return this.discNumber; }

    public void setDiscNumber(Integer discNumber) { this.discNumber = discNumber; }

    private Integer trackCount;

    public Integer getTrackCount() { return this.trackCount; }

    public void setTrackCount(Integer trackCount) { this.trackCount = trackCount; }

    private Integer trackNumber;

    public Integer getTrackNumber() { return this.trackNumber; }

    public void setTrackNumber(Integer trackNumber) { this.trackNumber = trackNumber; }

    private String contentAdvisoryRating;

    public String getContentAdvisoryRating() { return this.contentAdvisoryRating; }

    public void setContentAdvisoryRating(String contentAdvisoryRating) { this.contentAdvisoryRating = contentAdvisoryRating; }
}
