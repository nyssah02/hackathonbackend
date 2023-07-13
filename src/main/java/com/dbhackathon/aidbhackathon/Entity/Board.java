package com.dbhackathon.aidbhackathon.Entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {
  private String id;
  private String name;
  private String url;
  private Map<String, String> labelNames;
  private String lists;
}
