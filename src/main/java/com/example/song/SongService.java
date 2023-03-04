package com.example.song;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

import com.example.song.Song;
import com.example.song.SongRepository;

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

int uniqueSongId=6;
        public ArrayList<Song> getALLSongs(){
            Collection<Song> SongCollection = playlist.values();
            ArrayList<Song> allSongs=new ArrayList<>(SongCollection);
            return allSongs;
        }
        public Song getSongById(int songId){
            Song song =playlist.get(songId);
            if (song==null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            return song;
        }
        public Song addSong(Song song){
            song.setsongId(uniqueSongId);
            playlist.put(uniqueSongId,song);
            uniqueSongId+=1;
            return song;

        }
          public void deleteSong(int songId){
            Song song = playlist.get(songId);
            if (song==null){
              throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            } else {
                playlist.remove(songId);
                throw new ResponseStatusException(HttpStatus.NO_CONTENT);
            }
          }
          public Song updateSong(int songId, Song updatedSong){
    Song song = playlist.get(songId);
    if (song == null){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    else {
        song.setsongId(updatedSong.getsongId());
        song.setsongName(updatedSong.getsongName());
        song.setlyricist(updatedSong.getlyricist());
        song.setsinger(updatedSong.getsinger());
        song.setmusicDirector(updatedSong.getmusicDirector());
        return song;
    }
    }
          
}
    // Don't modify the above code

    // Write your code here

