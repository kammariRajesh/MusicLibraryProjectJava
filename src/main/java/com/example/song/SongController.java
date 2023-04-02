
package com.example.song;

import org.springframework.web.bind.annotation.*;
 import java.util.ArrayList;
 import com.example.song.SongService;
 import com.example.song.Song;
@RestController
public class SongController{
    SongService s = new SongService();

    
    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return s.getSongs();
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return s.addSong(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable int songId){
        return s.getSong(songId);
    }
    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable int songId, @RequestBody Song song){
        return s.updateSong(songId,song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable int songId){
         s.deleteSong(songId);
    }
}