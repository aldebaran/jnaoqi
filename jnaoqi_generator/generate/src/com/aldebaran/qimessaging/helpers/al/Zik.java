package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;
import java.util.List;
import java.util.Map;
import com.aldebaran.qimessaging.*;

import java.util.List;

/**
 * Created by erwan and emile on 01/05/2014.
 */
public class Zik extends ALModule {

    public Zik(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("clearStats");
        else
            service.call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isTraceEnabled").get();
    }

    /**
    * Create a ZikService object and its associated audio sink.
    * 
    */
    public java.lang.Object __init__(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("__init__", param1).get();
    }

    /**
    * 
        Fade playback output volume to `target', in `duration' seconds.

        Keyword arguments:
        target -- targeted volume, an integer in [0, 100]
        duration -- fading duration, in seconds
        
    * 
    */
    public java.lang.Object fade(java.lang.Object param1, java.lang.Object param2) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("fade", param1, param2).get();
    }

    /**
    * 
        Fade playback output volume to 0, in `duration' seconds.

        Keyword arguments:
        duration -- fading duration, in seconds
        
    * 
    */
    public java.lang.Object fade_out(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("fade_out", param1).get();
    }

    /**
    * 
        Return the artist full name.

        artist_id -- artist identifier
        
    * 
    */
    public java.lang.Object get_artist_name(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("get_artist_name", param1).get();
    }

    /**
    * 
        Return a list of artist ids for the track.

        track_id -- track identifier
        
    * 
    */
    public java.lang.Object get_track_artists(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("get_track_artists", param1).get();
    }

    /**
    * 
        Return the duration of the track, in milliseconds.

        track_id -- track identifier
        
    * 
    */
    public java.lang.Object get_track_duration(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("get_track_duration", param1).get();
    }

    /**
    * 
        Return the title of the track.

        track_id -- track identifier
        
    * 
    */
    public java.lang.Object get_track_title(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("get_track_title", param1).get();
    }

    /**
    * Get the current playback output volume, in [0, 100].
    * 
    */
    public java.lang.Object get_volume() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("get_volume").get();
    }

    /**
    * Stop the currently playing track, if any.
    * 
    */
    public java.lang.Object halt() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("halt").get();
    }

    /**
    * 
        Login to a music provider.

        Keyword arguments:
        provider -- the music provider identifier, in ['spotify']
        login -- the music provider login
        password -- the associated password
        
    * 
    */
    public java.lang.Object login(java.lang.Object param1, java.lang.Object param2, java.lang.Object param3) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("login", param1, param2, param3).get();
    }

    /**
    * Logout, if logged in.
    * 
    */
    public java.lang.Object logout() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("logout").get();
    }

    /**
    * Pause the current track playback, and pause streaming as well.
    * 
    */
    public java.lang.Object pause() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("pause").get();
    }

    /**
    * 
        Play a track by its id, obtained via the search_tracks method.

        Keyword arguments:
        track_id -- a valid track id
        
    * 
    */
    public java.lang.Object play(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("play", param1).get();
    }

    /**
    * Resume the current track playback, and resume streaming as well.
    * 
    */
    public java.lang.Object resume() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("resume").get();
    }

    /**
    * 
        Search for a track by title, artist, or both.

        Keyword arguments:
        query -- a query string, e.g. `daft punk get happy'
        
    * 
    */
    public java.lang.Object search_tracks(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("search_tracks", param1).get();
    }

    /**
    * 
        Set the playback output volume.

        Keyword arguments:
        volume -- an integer in [0, 100]
        
    * 
    */
    public java.lang.Object set_volume(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("set_volume", param1).get();
    }

}
    