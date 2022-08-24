package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dashboard {
    String owner;
    String name;
    String description;
    boolean share;
}
