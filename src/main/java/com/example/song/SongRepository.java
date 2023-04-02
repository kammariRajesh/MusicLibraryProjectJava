
package com.example.song;
import java.util.*;

public interface SongRepository {
    ArrayList<Song> getSongs();
    Song addSong(Song song);
    Song getSong(int songId);
    Song updateSong(int songId, Song song);
    void deleteSong(int songId);
}