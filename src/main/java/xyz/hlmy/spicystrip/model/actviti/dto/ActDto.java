package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActDto implements Serializable {


    private String process_name;

    private String sponsor;


    public String getProcess_name() {
        return process_name;
    }

    public ActDto setProcess_name(String process_name) {
        this.process_name = process_name;
        return this;
    }

    public String getSponsor() {
        return sponsor;
    }

    public ActDto setSponsor(String sponsor) {
        this.sponsor = sponsor;
        return this;
    }
}
