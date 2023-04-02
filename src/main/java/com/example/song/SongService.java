
package com.example.song;

import java.util.*;

import com.example.song.Song;
import com.example.song.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    int uniqueId = 6;

    @Override
    public ArrayList<Song> getSongs(){
        Collection<Song> songCollection = playlist.values();
        ArrayList<Song> Songs = new ArrayList<>(songCollection);
        return Songs;
    }

    @Override
    public Song addSong(Song Song){
       Song.setsongId(uniqueId);
       playlist.put(uniqueId,Song);
       uniqueId += 1;
       return Song;
    }

    @Override
    public Song getSong(int SongId){
        Song Song = playlist.get(SongId);
        if(Song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return Song;
    }
    @Override
    public Song updateSong(int SongId, Song Song){
        Song existingSong = playlist.get(SongId);
        if(existingSong == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(Song.getsongName() != null){
            existingSong.setsongName(Song.getsongName());
        }
        if(Song.getlyricist() != null){
            existingSong.setlyricist(Song.getlyricist());
        }
        if(Song.getsinger() != null){
            existingSong.setsinger(Song.getsinger());
        }
        if(Song.getmusicDirector() != null){
            existingSong.setmusicDirector(Song.getmusicDirector());
        }
        return existingSong;
    }
    @Override
    public void deleteSong(int SongId){
        Song existSong = playlist.get(SongId);
        if(existSong == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            playlist.remove(SongId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        
    }

}