package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingLab {
    public static void main(String[] args) {
        Bridges bridges = new Bridges(3, "wangj17", "833702757243");
        DataSource ds = bridges.getDataSource();
        List<ActorMovieIMDB> movieData = null;

        try {
            movieData = ds.getActorMovieIMDBData(Integer.MAX_VALUE);
        } catch (Exception e) {
            System.out.println("Unable to connect to Bridges.");
        }

        for (int i = 0; i < 5; i++) {
            ActorMovieIMDB entry = movieData.get(i);
            System.out.println("" + i + ".  " + entry.getActor() + " was in " + entry.getMovie());
        }

        for (ActorMovieIMDB names : movieData) {
            if (names.getMovie().equals("Being_John_Malkovich_(1999)")) {
                System.out.println(names.getActor());
            }


            ArrayList<ActorMovieIMDB> filteredMovieList = new ArrayList<>();
            Collections.sort(filteredMovieList, new ActorComparator());
            for (ActorMovieIMDB act : filteredMovieList) {
                System.out.println(act);
            }
        }

    }
}
