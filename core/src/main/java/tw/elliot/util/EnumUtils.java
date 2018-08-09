package tw.elliot.util;

import tw.elliot.model.RoleEnum;

import java.util.Collection;
import java.util.Iterator;

public abstract class EnumUtils {
	public static <E extends Enum<E>> String[] names(Collection<E> collection) {
		if (collection.isEmpty()) {
			return new String[0];
		}

		String[] result = new String[collection.size()];

		Iterator<E> ri = collection.iterator();

		int i = 0;
		while (ri.hasNext()) {
			result[i++] = ri.next().name();
		}

		return result;
	}
}
