package fi.gapps.intra.thesis.utils;

import java.util.Comparator;

import fi.gapps.intra.thesis.model.Edge;

public class EdgeComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		if (o1.getWeight() < o2.getWeight()) {
			return 1;
		} else if (o1.getWeight() > o2.getWeight()) {
			return -1;

		} else {
			return 0;
		}

	}

}
