package lt.vu.usecases;

import lt.vu.services.GenreService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GetGenrePopularity implements Serializable {

    @Inject
    private GenreService genreService;

    private CompletableFuture<Map<String, Long>> genrePopularity;

    public String calculateGenrePopularity() {
        if (genrePopularity == null || genrePopularity.isDone()) {
            genrePopularity = CompletableFuture.supplyAsync(() -> genreService.calculateGenrePopularity());
        }

        return "genres?faces-redirect=true";
    }

    public boolean isGenrePopularityRunning() {
        return genrePopularity != null && !genrePopularity.isDone();
    }

    public String getGenrePopularityStatus() throws ExecutionException, InterruptedException {
        if (genrePopularity == null) {
            return "";
        } else if (isGenrePopularityRunning()){
            return "Calculating...";}

        StringBuilder sb = new StringBuilder();
        sb.append("<h3>Genre popularity: <h3>");
        Map<String, Long> genrePopularityMap = genrePopularity.get();
        for (Map.Entry<String, Long> entry : genrePopularityMap.entrySet()) {
            sb.append("<p>").append(entry.getKey()).append(": ").append(entry.getValue()).append("</p>");
        }
        return sb.toString();
    }
}
