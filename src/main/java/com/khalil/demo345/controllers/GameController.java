package com.khalil.demo345.controllers;

import com.khalil.demo345.entities.Game;
import com.khalil.demo345.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GameController {
    @Autowired
    GameService gameService;

    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createGame";
    }
    @RequestMapping("/saveGame")
    public String saveGame(@ModelAttribute("game") Game game,
                              @RequestParam("date") String date,
                              ModelMap modelMap) throws
            ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        game.setDateCreation(dateCreation);

        Game saveGame = gameService.saveGame(game);
        String msg ="game enregistré avec Id "+saveGame.getIdGame();
        modelMap.addAttribute("msg", msg);
        return "createGame";
    }


    @RequestMapping("/ListeGames")
    public String listeGames(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Game> gms = gameService.getAllGamesParPage(page, size);
        modelMap.addAttribute("games", gms);
        modelMap.addAttribute("pages", new int[gms.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeGames";
    }

    @RequestMapping("/supprimerGame")
    public String supprimerGame(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "2") int size)
    {
        gameService.deleteGameById(id);
        Page<Game> gms = gameService.getAllGamesParPage(page,
                size);
        modelMap.addAttribute("games", gms);
        modelMap.addAttribute("pages", new int[gms.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeGames";
    }



    @RequestMapping("/modifierGame")
    public String editerGame(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Game p= gameService.getGame(id);
        modelMap.addAttribute("game", p);
        return "editerGame";
    }

    @RequestMapping("/updateGame")
    public String updateGame(@ModelAttribute("game") Game game, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        game.setDateCreation(dateCreation);

        gameService.updateGame(game);
        return "redirect:/ListeGames";
    }



}
