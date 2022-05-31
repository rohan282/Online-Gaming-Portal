

package com.example.crewmgmt;

public class member {
    private int player_id ;
    private String first_name,last_name,game_title;


    public int getPlayer_id() {
        return player_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGame_title() {
        return game_title;
    }

    public member(int player_id, String first_name, String last_name, String game_title) {
        this.player_id = player_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.game_title = game_title;
    }



}
