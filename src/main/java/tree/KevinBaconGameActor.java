package tree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author voyageth
 *         2016-10-27
 */
public class KevinBaconGameActor {
    private String actorName;
    private Set<KevinBaconGameActor> coWorkedActorSet = new HashSet<>();

    public KevinBaconGameActor(String actorName) {
        this.actorName = actorName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Set<KevinBaconGameActor> getCoWorkedActorSet() {
        return coWorkedActorSet;
    }

    public void setCoWorkedActorSet(Set<KevinBaconGameActor> coWorkedActorSet) {
        this.coWorkedActorSet = coWorkedActorSet;
    }

    public void addCoWorker(KevinBaconGameActor actor) {
        if (actor == null) {
            return;
        }

        this.coWorkedActorSet.add(actor);
    }

    public boolean equals(Object other) {
        if (other instanceof KevinBaconGameActor) {
            KevinBaconGameActor otherActor = (KevinBaconGameActor) other;
            return actorName.equals(otherActor.getActorName());
        }

        return false;
    }
}
