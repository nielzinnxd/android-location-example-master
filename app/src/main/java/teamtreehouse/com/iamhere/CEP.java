package teamtreehouse.com.iamhere;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dleite on 23/12/2016.
 */

public class CEP  implements Serializable {

    Long lat, lng;
    String results,address_components;


    public CEP(){
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getAddress_components() {
        return address_components;
    }

    public void setAddress_components(String address_components) {
        this.address_components = address_components;
    }



    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLng() {
        return lng;
    }

    public void setLng(Long lng) {
        this.lng = lng;
    }
}
