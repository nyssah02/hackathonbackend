package com.dbhackathon.aidbhackathon.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    private String id;
    private String name;
    private boolean closed;
    private String idBoard;
    private long pos;
    private String status;
}
