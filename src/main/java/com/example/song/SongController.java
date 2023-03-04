package com.example.song;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.song.SongService;

@RestController 
public class SongController {
    SongService songService = new SongService();
    @GetMapping("/songs")
    public ArrayList<Song>  getALLSongs(){
        return songService. getALLSongs();
    }
    @GetMapping("/songs/{songId}")
    
    public Song getPlayerById(@PathVariable("songId")int songId){
        return songService.getSongById(songId);
    }
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songService.addSong(song);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId ){
        songService.deleteSong(songId);
        
    }
    
    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song updatedSong){
        return songService.updateSong(songId, updatedSong);
    }


}