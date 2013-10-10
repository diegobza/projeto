/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import javafx.event.Event;

/**
 *
 * @author dev
 */
public class MapEvent extends Event {

    public MapEvent(MapController map, double lat, double lng) {
        super(map, Event.NULL_SOURCE_TARGET, Event.ANY);
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }
    private double lat;
    private double lng;
}
