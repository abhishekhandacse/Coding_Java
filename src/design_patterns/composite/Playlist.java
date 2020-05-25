package design_patterns.composite;

import java.util.ArrayList;

public class Playlist implements IComponent{

    public String playlistName;
    public ArrayList<IComponent> playlist = new ArrayList();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }


    @Override
    public void play(){
        for(IComponent component : playlist) {
            component.play();
        }
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        for(IComponent component : this.playlist){
            component.setPlaybackSpeed(speed);
        }
    }

    @Override
    public String getName() {
        return playlistName;
    }
    public void add(IComponent iComponent){
        playlist.add(iComponent);
    }
    public void remove(IComponent iComponent){
        playlist.remove(iComponent);
    }
}
