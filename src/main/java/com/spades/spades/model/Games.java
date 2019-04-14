package com.spades.spades.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "games", schema = "public")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private int gameId;
    @Column(name = "player1_id")
    private int player1Id;
    @Column(name = "player_2")
    private int player2Id;
    @Column(name = "game_status")
    private String gameStatus;
    @Column(name = "winner_id")
    private int winnerId;


    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Users> users;

    public Games(){}

    public Games(Games games) {
        this.player1Id = games.getPlayer1Id();
        this.player2Id = games.getPlayer2Id();
        this.gameStatus = games.getGameStatus();
        this.winnerId = games.getWinnerId();
        this.users = games.getUsers();
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(int player1Id) {
        this.player1Id = player1Id;
    }

    public int getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(int player2Id) {
        this.player2Id = player2Id;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}