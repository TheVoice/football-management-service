package com.karol.players.rest;

import com.karol.players.model.Player;
import com.karol.players.model.Team;
import com.karol.players.services.PlayersService;
import com.karol.players.services.TeamsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class FootballController {

    private TeamsService teamsService;
    private PlayersService playersService;

    @Autowired
    public void setTeamsService(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @Autowired
    public void setPlayersService(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("/football")//default get - allows to display all the player + team data
    public String getHomepage(Model model) {
        model.addAttribute("teams", teamsService.getTeams());
        model.addAttribute("players", playersService.getPlayers());
        model.addAttribute("player", new Player());
        model.addAttribute("team", new Team());
        return "football";
    }

    @PostMapping(value = "team/add")
    public String addTeam(@ModelAttribute("team") Team team) {
        if(team.getId() == null) {
            //add new team
            this.teamsService.addTeam(team);
        } else {
            //update existing team
            this.teamsService.updateTeam(team);
        }

        return "redirect:/football";
    }

    @PostMapping(value = "player/add")
    public String addPlayer(@ModelAttribute("player") Player player) {
        if(player.getId() == 0) {
            //add new player
            this.playersService.addPlayer(player);
        } else {
            //update existing player
            this.playersService.updatePlayer(player);
        }

        return "redirect:/football";
    }

    @RequestMapping(value = "player/remove/{playerId}")
    public String removePlayer(@PathVariable("playerId") int id) {
        this.playersService.removePlayer(id);
        return "redirect:/football";
    }

    @RequestMapping(value = "team/remove/{teamId}")
    public String removeTeam(@PathVariable("teamId") int id) {
        this.teamsService.removeTeam(id);
        return "redirect:/football";
    }


    /**
     * Loads the player details into the edit window.
     * @param id the player id
     * @param model session model
     * @return the destination view
     */
    @RequestMapping(value = "player/edit/{id}")
    public String editPlayer(@PathVariable("id") int id, Model model){
        Player player = this.playersService.getPlayerById(id);
        model.addAttribute("player", player);
        model.addAttribute("players", this.playersService.getPlayers());
        model.addAttribute("teams", teamsService.getTeams());
        model.addAttribute("team", new Team());
        return "football";
    }

    /**
     * Loads the team details into the edit window.
     * @param id the team id
     * @param model session model
     * @return the destination view
     */
    @RequestMapping(value = "team/edit/{id}")
    public String editTeam(@PathVariable("id") int id, Model model){
        Team team = this.teamsService.getTeamById(id);
        model.addAttribute("player", new Player());
        model.addAttribute("players", this.playersService.getPlayers());
        model.addAttribute("teams", teamsService.getTeams());
        model.addAttribute("team", team);
        return "football";
    }
}
