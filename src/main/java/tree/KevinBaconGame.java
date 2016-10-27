package tree;

import java.util.*;

/**
 * @author voyageth
 *         2016-10-27
 */
public class KevinBaconGame {
	private Map<String, KevinBaconGameActor> actorMap = new HashMap<>();

	public int getKevinBaconNumber(String actorName, String targetActorName) {
		if (actorName == null || targetActorName == null) {
			return -1;
		}

		KevinBaconGameActor actor = actorMap.get(actorName);
		KevinBaconGameActor targetActor = actorMap.get(targetActorName);
		if (actor == null || targetActor == null) {
			return -1;
		}

		if (actor.equals(targetActor)) {
			return 0;
		}

		Set<KevinBaconGameActor> alreadyCheckedActorSet = new HashSet<>();
		Queue<KevinBaconGameActor> currentLevelQueue = new LinkedList<>();
		Queue<KevinBaconGameActor> nextLevelQueue = new LinkedList<>();
		currentLevelQueue.add(actor);

		int number = 1;
		KevinBaconGameActor currentActor = currentLevelQueue.poll();
		while (currentActor != null) {
			for (KevinBaconGameActor coWorker : currentActor.getCoWorkedActorSet()) {
				if (alreadyCheckedActorSet.contains(coWorker)) {
					continue;
				}

				if (coWorker.equals(targetActor)) {
					alreadyCheckedActorSet.add(coWorker);
					return number;
				} else {
					nextLevelQueue.add(coWorker);
				}
			}

			currentActor = currentLevelQueue.poll();
			if (currentActor == null) {
				currentLevelQueue = nextLevelQueue;
				nextLevelQueue = new LinkedList<>();
				number++;

				currentActor = currentLevelQueue.poll();
			}
		}

		return -1;
	}

	public void addMovieActorList(List<String> actorNameList) {
		for (int i = 0; i < actorNameList.size(); i++) {
			KevinBaconGameActor actor1 = getActor(actorNameList.get(i));

			for (int j = 0; j < actorNameList.size(); j++) {
				if (i == j) {
					continue;
				}

				KevinBaconGameActor actor2 = getActor(actorNameList.get(j));
				addCoWorkInfo(actor1, actor2);
			}
		}
	}

	private KevinBaconGameActor getActor(String actor1Name) {
		KevinBaconGameActor actor = actorMap.get(actor1Name);
		if (actor == null) {
			actor = new KevinBaconGameActor(actor1Name);
			actorMap.put(actor1Name, actor);
		}
		return actor;
	}

	public void addCoWorkInfo(KevinBaconGameActor actor1, KevinBaconGameActor actor2) {
		if (actor1 == null || actor2 == null) {
			return;
		}

		actor1.addCoWorker(actor2);
		actor2.addCoWorker(actor1);
	}
}
