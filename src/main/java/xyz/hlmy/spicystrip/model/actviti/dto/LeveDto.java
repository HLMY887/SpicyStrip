package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeveDto implements Serializable {

    private String tile;

    private Double day;
    private String reason;

    private String deploy;


    public String getTile() {
        return tile;
    }

    public LeveDto setTile(String tile) {
        this.tile = tile;
        return this;
    }

    public Double getDay() {
        return day;
    }

    public LeveDto setDay(Double day) {
        this.day = day;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public LeveDto setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getDeploy() {
        return deploy;
    }

    public LeveDto setDeploy(String deploy) {
        this.deploy = deploy;
        return this;
    }
}
