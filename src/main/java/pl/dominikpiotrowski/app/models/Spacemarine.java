
package pl.dominikpiotrowski.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Spacemarine {
    private String name;
    private Chapter chapter;
    private Rank rank;
    private String image;
}