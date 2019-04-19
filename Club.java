package org.softuni.AFIF.web.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name = "clubs")
@Entity
public class Club extends BaseEntity {
    @Column(name = "`name`" , nullable = false)
    private String name;

    @Column(name = "foundedOn" , nullable = false)
    private Date foundedOn;

    @Column(name = "ownerFirstName" , nullable = false)
    private String ownerFirstName;

    @Column(name = "ownerLastName" , nullable = false)
    private String ownerLastName;

    @ManyToMany(targetEntity = Player.class, fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(
            name = "clubs_players",
            joinColumns = @JoinColumn(
                    name = "club_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "player_id",
                    referencedColumnName = "id"
            )
    )
    private List<Player> ownedPlayers;

    public Club() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundedOn() {
        return foundedOn;
    }

    public void setFoundedOn(Date foundedOn) {
        this.foundedOn = foundedOn;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

}
