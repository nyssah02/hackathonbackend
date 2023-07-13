package com.dbhackathon.aidbhackathon.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class List {
    private String name;
    private String idBoard;
    private String idListSource;
    private long pos;
}
